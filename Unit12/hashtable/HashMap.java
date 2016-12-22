import exceptions.*;

/**
 * Implementation of the HashMap structure with an array of objects
 * @author  Murray butler
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class HashMap<K,V> implements HashMapADT<K,V>
{
  private int TABLE = 31;
  private double LF = 0.8;
  private int count = 0;
  HashElement<K,V>[] table;

  /**
   * Default constructor
   */
  public HashMap()
  {
    table = new HashElement[TABLE];
    nullMap(table);
  }

  /**
   * Constructor adjusting array size on instantiation
   * @param int Size of underlying array
   */
  public HashMap(int sz)
  {
    table = new HashElement[sz];
    nullMap(table);
  }

  /**
   * Constructor adjusting array size and load factor on instantiation
   * @param int Size of underlying array
   * @param double Load Factor - percentage full factor of array to determine growth
   */
  public HashMap(int sz, double loadfactor)
  {
    table = new HashElement[sz];
    nullMap(table);
    this.LF = loadfactor;
  }

  /**
   * Hashing function for hash value
   * @param K Key value from HashElement
   * @return  int hash value of key
   */
  private int hashVal(K key)
  {
    if (key == null) {
      return 0;
    }
    String tem = key.toString();
    int temkey = Integer.parseInt(tem); // We need an int for the operators
    int keyval = temkey / 1000000; // This will extract the first three digits from the SSN
    int hash = Math.abs(keyval) % TABLE;
    System.out.println("Keyval: " + keyval + " Hash: " + hash);
    return hash;
  }

  /**
   * Secondary hashing method for collisions
   * @param K Key value
   * @return  int Hash of Key
   */
  private int hashCol(K key)
  {
    if (key == null) {
      return 0;
    }
    String tem = key.toString();
    int temkey = Integer.parseInt(tem);
    int keyval = temkey % 10000;
    int hash = Math.abs(keyval) % TABLE;
    System.out.println("Keyval: " + keyval + " Hash: " + hash);
    return hash;
  }

  /**
   * Method to get value using key from HashMap
   * @param K Key of K/V pair
   * @return  V Value of K/V pair
   */
  public V get(K key) throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("HashMap");
    }

    int idx = hashVal(key) % TABLE;
    if (table[idx] == null) {
      return null;
    } 
   
    while (table[idx].getKey() != key) {
      idx = hashCol(key) % TABLE;
    }
  
    System.out.println("Finding value at idx: " + idx);
    return table[idx].getVal();
  }

  /**
   * Method to place K/V pair into HashMap
   * @param K Key value for pair
   * @param V Value of pair
   */
  public void put(K key, V val) 
  {
    double load = count/(double)table.length;
    HashElement item = new HashElement(key,val);
    
    System.out.println("Current load on HashMap: " + load);
    if (load > 0.8) {
      growHash();
    }
    
    int idx = hashVal(key) % TABLE;
    while (table[idx] != null) {
      idx = hashCol(key) % TABLE;
    }

    table[idx] = item;
    System.out.println("Added: " + item.getKey() + " : " + item.getVal() + " @idx: " + idx);
    count++;
  }

  /**
   * Method to grow underlying array
   */
  private void growHash()
  {
    int sze = (this.size() * 2);
    HashElement[] temp = new HashElement[sze];
    for (int i = 0; i < table.length; i++) {
      temp[i] = table[i];
    }

    table = temp;
  }

  /**
   * Function to determine if HashMap has any entries
   * @return  boolean T/F of presence of values in HashMap
   */
  public boolean isEmpty() 
  {
    return (count == 0);
  }

  /**
   * Method to remove value and key from HashMap
   * @param K Key value of K/V pair to remove
   */
  public void remove(K key) throws ElementNotFoundException
  {
    int idx = hashVal(key) % TABLE;
    if (table[idx] == null || idx > table.length) {
      throw new ElementNotFoundException("Key: " + key.toString());
    }
    
    while (table[idx].getKey() != key) {
      idx = hashCol(key) % TABLE;
    }
    table[idx] = null;
    count--;
  }

  /**
   * Method to return the size in use of the underlying array
   * @return  int Number of K/V pairs in current HashMap
   */
  public int size()
  {
    return count;
  }

  /**
   * Method to null underlying array on instantiation
   * @param HashElement[] Array of HashElements as HashMap
   */
  private void nullMap(HashElement[] newtab)
  {
    for (int i = 0; i < newtab.length; i++) {
      newtab[i] = null;
    }
  }

}



