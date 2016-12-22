import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
/**
 * Class to drive quicksort changes for median of 3 pivots
 * @author Murray Butler
 * @version 1.0
 */
public class sortDriver
{
  /**
   * main() for class
   */
  public static void main(String[] args) throws IOException
  {
    //  9.4 assignment
    Random rando = new Random();
    int len = 4 + rando.nextInt(20);
    Integer[] sorti = new Integer[len];
    sorti = generateRandomArray(len);
    //sorti = file2String(len);

    System.out.println("");
    for (int i=0; i<len; i++){
       System.out.println(i + ":" + sorti[i]);
    }
    System.out.println("");

    SortB.quickSort(sorti);

    System.out.println("");
    for (int i=0; i<len; i++){
       System.out.println(i + ":" + sorti[i]);
    }
    System.out.println("");
 

    //  9.2 assignment
    int gap = rando.nextInt(5);
    int len2 = 4 + rando.nextInt(20);
    Integer[] bubbli = new Integer[len2];
    bubbli = generateRandomArray(len2);

    System.out.println("");
     for (int i=0; i<len2; i++){
        System.out.println(i + ":" + bubbli[i]);
     }
     System.out.println("");

     GapSort.bubbleSort(bubbli);

     System.out.println("");
     for (int i=0; i<len2; i++){
        System.out.println(i + ":" + bubbli[i]);
     }
     System.out.println("");

  }

  /**
   * method to create random string array
   *
   * @param len length of array to gen
   */
  private String[] file2String(int len) throws IOException
  {
    Path file = Paths.get("words2.txt");
    InputStream in = null;
    String[] arr = new String[len];
    in = Files.newInputStream(file);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String line = null;
    for (int i = 0; i < len; i++) {
        arr[i] = reader.readLine();
    }

    return arr;
  }

  /**
   * Randomw integer array generator
   *
   * @param n length of array to gen
   */
  public static Integer[] generateRandomArray(int n){
    Integer[] arr = new Integer[n];
    Random random = new Random();

    for (int i = 0; i < n; i++)
    {
      arr[i] = random.nextInt(100);
    }
   return arr;
  } 

}
