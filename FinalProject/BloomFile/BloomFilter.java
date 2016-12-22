package BloomFile;

import java.io.*;
import java.util.*;
import java.nio.file.*;


/**
 * This is a simple implementation of a bloom filter, it uses a chain of murmur
 * hashes to create the bloom filter.
 * Optional use of MurmurHash versus Murmur1 hashing is commented
 * 
 * @author Murray Butler
 * @version 1.0
 */
public class BloomFilter<T> implements Serializable {
	
	private BitSet bitset;
	private long NOBitsBy2;
	private int hashes;
  private int NOBits;
  private File bloomFile = null; 
  private boolean err = false;

	/**
	 * Creates a bloom filter with the provided number of hashed and hits.
	 * @param hashes the hashes to be performed.
	 * @param NOBits the Num of Bits to be used in the bit set.
	 */
	public BloomFilter(int hashes, int NOBits, String bFile) { 
		this.hashes = hashes;
    this.NOBits = NOBits;
		this.NOBitsBy2 = NOBits / 2;
		this.bitset = new BitSet(NOBits);
    this.bloomFile = new File(bFile);
    if (bloomFile.exists()) {
      if (this.loadBloom(bFile)) {
        System.out.println("Successfully loaded filter");
      }
    }
	}
	
	/**
	 * Add a key to the bloom filter.
	 * @param key the key.
	 */
	public void add(byte[] key) {
		addI(key);
	}

	/**
	 * Tests a key in the bloom filter, it may provide false positives.
	 * @param key the key.
	 * @return boolean.
	 */
	public boolean test(byte[] key) {
		return testI(key);
	}
	
	/**
	 * Test the key against the bit set with the proper number of hashes.
	 * @param key the key.
	 * @return boolean.
	 */
	private boolean testI(byte[] key) {
    //int hash1 = MurmurHash.hash(0,key,key.length);
    long hash1 = Murmur1.hash(key,key.length,0);
    //int hash2 = MurmurHash.hash(hash1,key,key.length);
    long hash2 = Murmur1.hash(key,key.length,hash1);
		for (int i = 0; i < hashes; i++) {
			int hash = (int) Math.abs((hash1 + i * hash2) % NOBits);
			//int hash = Math.abs(Murmur1.hash(key,key.length,i) % NOBits);
			if (!bitset.get(hash)) {
        return false;
      }
		}
		return true;
	}
	
	/**
	 * Adds the key to the bit set with the proper number of hashes.
	 * @param key the key.
	 */
	private void addI(byte[] key) {
    //int hash1 = MurmurHash.hash(0,key,key.length);
    long hash1 = Murmur1.hash(key,key.length,0);
    //int hash2 = MurmurHash.hash(hash1,key,key.length);
    long hash2 = Murmur1.hash(key,key.length,hash1);
		for (int i = 0; i < hashes; i++) {
			int hash = (int) Math.abs((hash1 + i * hash2) % NOBits);
			//int hash = Math.abs(Murmur1.hash(key,key.length,i) % NOBits);
			bitset.set(hash);
		}
	}

  /**
   * (1 - e^(-k * n / m)) ^ k
   * Calculate the probability of a false positive given the specified
   * number of inserted elements.
   *
   * @param numberOfElements number of inserted elements.
   * @return probability of a false positive.
   */
  public double accuProb() {
    return Math.pow((1 - Math.exp(-hashes * (double) NOBits 
    / (double) bitset.length())), hashes);
  }

  /**
   * k = (m / n) ln 2
   * Optimal number of hashes
   * @param elemsize Estimated number of elements in bitset
   * @param NOBits Number of bits in filter
   * @return int  number of hashes needed
   */
  public int optHashes(int elemsize, int NOBits)
  {
    return (int) Math.ceil(Math.log(2) * ((double) NOBits / elemsize));
  }

  /**
   * Save the current filter to a file
   *
   * @param String Output filename
   * @return boolean Success/Failure
   */
  public boolean saveBloom(String fout)
  {
    boolean err = true;

    byte[] tmp = bitset.toByteArray();

    try {
      FileOutputStream fos = new FileOutputStream(bloomFile,false);
      fos.write(tmp);
      fos.flush();
      fos.close();
    } catch (IOException e) {
      err = false;
      System.out.println(e.getMessage());
    }

    return err;
  }

  /**
   * Load bitset from file
   *
   * @param fin Input filename 
   * @return boolean Success/Failure
   */
  public boolean loadBloom(String fin)
  {
    boolean err = true;

    try {
      byte[] tmp = Files.readAllBytes(new File(fin).toPath());

      for (int i = 0; i < tmp.length * 8; i++) {
        if ((tmp[tmp.length - i / 8 - 1] & (1 << (i % 8))) > 0) {
          bitset.set(i);
        }
      }
    } catch (IOException e) {
      err = false;
      System.out.println(e.getMessage());
    }
    return err;
  }

  /**
   * Print the bitset filter to string
   *
   */
  public void bloomPrint()
  {
    String bfstr = new String(bitset.toString());
    System.out.println("Filter as String: " + bfstr);
  }

}

