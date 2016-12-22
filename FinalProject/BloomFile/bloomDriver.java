package BloomFile;

import java.io.*;
import java.security.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

/**
 * Driver class for Bloom filter.  Meant to manage extents tested against filter and 
 * used to measure effectiveness of the filter.  Just one big main()...
 */
public class bloomDriver
{
  public static void main(String[] args)
  {
    byte[][] segs = new byte[4096][128];
    String[] files = {"test1","test2","test3","test4","test5","test6","test7","test8","test9"};
    List<Integer> segarr = new ArrayList<Integer>();
    List<Integer> filemap;
    List<Integer> filenew;
    int ddf = 0;
    int ndf = 0;
    int totseg = 0;
    int dedup = 0;
    int filename = 0;
    boolean err = false;
    boolean fc = true;
    boolean yn = false;
    BufferedWriter map = null; // Map file write handle
    FileWriter seg = null; //segment file write handle
    FileWriter log = null;
    File mapstor = null; //Map file handle
    File segstor = null; //Segment file handle
    String filer;
    String mapstr;
    String savefile = "bloomOut";
    File ddstore = new File("DDStore");
    File ddmaps = new File("DDMaps");
    File errlog = new File("bloomLog");

    @SuppressWarnings("unchecked")
    BloomFilter<String> bf = new BloomFilter(12,4096,savefile);

    // Create error logging file
    try {
      if (!errlog.exists()) {
        fc = errlog.createNewFile();
      }
      if (!fc) {
        System.out.println("failed to create log file, exiting.");
        System.exit(-1);
      }
      log = new FileWriter(errlog, true);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    // Create directories for map and store files
    if (!ddstore.exists() || !ddmaps.exists()) {
      ddstore.mkdir();
      ddmaps.mkdir();
      System.out.println("Successfully created directories.");
    } 

    // Read in the input files and split them
    for (int n = 0; n < files.length; n++) {
      try {
        segs = FileReader.BufferedFileReader(files[n]);
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }

      // Load the map file if it exists to check against extent records
      mapstr = "DDStore" + File.separator + files[n];
      mapstor = new File(mapstr);
      filemap = new ArrayList<Integer>();
      filenew = new ArrayList<Integer>();
      if (mapstor.exists()) {
        Path mappath = Paths.get(mapstr);
        try {
          Scanner scan = new Scanner(mapstor);
          while (scan.hasNext()) {
            String tem = scan.next();
            Integer nem = Integer.parseInt(tem);
            filemap.add(nem);
          }
          System.out.println("Successfully loaded filemap for file " + mapstr + ":" + filemap.size());
        } catch (FileNotFoundException e) {
          System.out.println(e.getMessage());
        }
        System.out.println("filemap size: " + filemap.size());
      } 


      //Break up the segments and dedup and write maps for segments
      for (int i = 0; i < segs.length; i++) {
        if (segs[i] == null || segs[i].length == 0) {
          totseg += i;
          break;
        }
        String Strseg = new String(segs[i]);
        filename = Math.abs((int)Murmur1.hash(segs[i],segs[i].length,0));
        filer = "DDMaps" + File.separator + Integer.toString(filename);
        segstor = new File(filer);

        // Test against the Bloom filter for presence of the extent fingerprint
        if (bf.test(segs[i])) {
          if (!filemap.contains(filename)) { 
            filemap.add(filename);
          }
          if (!segarr.contains(filename)) {
            segarr.add(filename);
          }
          ndf++;
        } else {
          bf.add(segs[i]);
          filemap.add(filename);
          segarr.add(filename);
          ddf++;
          
          // If not present, create and write file for segment storage
          if (!segstor.exists()) {
            try {
              fc = segstor.createNewFile();
              if (fc) {
                seg = new FileWriter(segstor,true);
                seg.write(Strseg);
                seg.flush();
                seg.close();
              } else {
                log.write("Failed to create: " + filer + " file exists\n");
              }
            } catch (IOException e) {
              System.out.println(e.getMessage());
              System.exit(-1);
            }
          }
        }  
      }
      
      // Create the new file and FileWriter for the map of the file, write and close
      try {
        fc = mapstor.delete();
        if (!fc) {
          log.write("Failed to delete: DDStore" + File.separator + files[n] + " exists\n");
        }

        fc = mapstor.createNewFile();
        if (!fc) {
          log.write("Failed to create: DDStore" + File.separator + files[n] + " exists\n");
        }

        map = new BufferedWriter(new FileWriter(mapstor,false));
        for (int i = 0; i < filemap.size(); i++) {
          map.write(filemap.get(i).toString());
          map.newLine();
        }

        map.flush();
        map.close();
      } catch (IOException e) {
       System.out.println(e.getMessage());
      }
    }
  
    //Optional printing of the current filter to stdout
    //bf.bloomPrint();
    // Save filter to output file
    if (!bf.saveBloom(savefile)) { 
      System.out.println("Failed to save filter to file!!");
    } else {
      System.out.println("Saved filter to file: " + savefile);
    }

    // Report on read/dedup
    dedup = (ndf * 100)/totseg;
    double posit = bf.accuProb() * 100;
    System.out.println("Probability of Accuracy: " + posit + "%");
    System.out.println("Extents deduplicated: " + ndf + "\nExtents written: " + ddf +  "\nTotal Extents: " + totseg + "\nPercentage deduplicated: " + dedup + "%");
   
    // Close up shop
    try {
      log.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.exit(-1);
    }
  }
}
