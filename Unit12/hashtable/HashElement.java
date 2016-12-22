
/**
 * Class for elements in HashMap structure
 */
public class HashElement<K,V>
{

  private K key;
  private V val;

  /**
   * Default constructor
   * @param K Key value
   * @param V Value
   */
  HashElement(K key,V val)
  {
    this.val = val;
    this.key = key;
  }

  /**
   * Getter method for key
   * @return  K Key value
   */
  public K getKey()
  {
    return key;
  }

  /**
   * Getter method for value
   * @return  V Value from HAshMap
   */
  public V getVal()
  {
    return val;
  }

  /**
   * Setter method for Value
   * @param V Value
   */
  public void setVal(V val)
  {
    this.val = val;
  }

  /**
   * Setter method for Key
   * @param K Key value
   */
  public void setKey(K key)
  {
    this.key = key;
  }
}
