import exceptions.*;

/**
 * Abstract interface of HAshMap class
 */
public interface HashMapADT<K,V>
{

  /**
   * Method to get value from HashMap
   */
  public V get(K key) throws EmptyCollectionException;

  /**
   * Method to place key/value pair into HashMap
   */
  public void put(K key,V val);

  /**
   * Mehtod to remove key/value pair from HashMap
   */
  public void remove(K key) throws ElementNotFoundException;

}
