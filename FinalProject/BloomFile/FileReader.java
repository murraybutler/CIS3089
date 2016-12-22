package BloomFile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * A basic class for reading in files for parsing to Bloom filter
 * @author Murray Butler
 * @version 1.0
 */

public class FileReader
{
 
  /** 
   * Basic buffered file reader to read at given extent size from file as bytes.
   * @param String Name of input file
   * @return byte[][] Byte matrix of lines of file
   */
  public static byte[][] BufferedFileReader(String filename) throws IOException 
    {
        byte[][] ret = new byte[4096][];
        byte[] conv;
        int i = 0;
        RandomAccessFile aFile = new RandomAccessFile(filename, "r");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(32);
        while(inChannel.read(buffer) > 0)
        {
            buffer.flip();
            ret[i] = new byte[buffer.remaining()];
            buffer.duplicate().get(ret[i]);
            buffer.clear();
            i++;
        }
        inChannel.close();
        aFile.close();
        return ret;
    }
}
