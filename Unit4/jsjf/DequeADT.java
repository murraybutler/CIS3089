/**
 * Abstract data type for deque, accesible data type from both ends of a queue
 * @author  Murray Butler
 * @version 1.0
 */

public interface DequeADT<T>
{

  /**
   * adds element to front of deque
   * @param element element value for front of queue
   */
  public void addFirst(T element);

  /**
   * adds element to end of deque
   * @param element element value to add to end of deque
   */
  public void addLast(T element);

  /**
   * returns first value at head of deque
   * @return  T returns first element value at head of deque
   */
  public T removeFirst();

  /**
   * returns value of last element in deque
   * @return T  returns last element value at tail of deque
   */
  public T removeLast();

  /**
   * returns element value at front of deque without removing it
   * @return  T returns element value at head of deque without removing
   */
  public T peekFirst();

  /**
   * returns element value at tail of deque without removing it
   * @return  T returns element value at tail of deque without removing
   */
  public T peekLast();

  /**
   * returns true/false value based upon elements in deque or not
   * @return  boolean returns true/false value of presence of values in deque
   */
  public boolean isEmpty();

  /**
   * returns size of deque as an int
   * @return int  length of current deque values
   */
  public int size();

  /**
   * returns deque as printable string
   * @return  String  returns printable string of deque values
   */
  public String toString();

}
