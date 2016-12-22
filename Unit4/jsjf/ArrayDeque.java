import java.util.Arrays;

/**
 * Class to implement a deque using an array
 * @author Murray Butler
 * @version 1.0
 */

public class ArrayDeque<T> implements DequeADT<T>
{
  private final static int DEF_CAP = 100;

  private int eindex, findex;
  private T[] deque;

  /**
   * constructor
   */
  public ArrayDeque()
  {
    this(DEF_CAP);
    eindex = 0;
    findex = 0;
  }

  /**
   * constructor allowing for sized array to be named
   * @param initCap size of array in int value
   */
  @SuppressWarnings("unchecked")
  public ArrayDeque(int initCap)
  {
    findex = 0;
    eindex = 0;
    deque = (T[])(new Object[initCap]);
  }

  /**
   * method to add element to front of deque
   * @param element element to be added to head of deque
   */
  public void addFirst(T element)
  {
    if (size() == deque.length) {
      expandCap();
    }

    if (findex != 0) {
      deque[findex - 1] = element;
      findex--;
    } else if (findex == 0 && eindex != findex && !isEmpty()) {
      for (int i = eindex + 1; i > 0; i--) {
        deque[i] = deque[i - 1];
      }
      deque[findex] = element;
      eindex++;
    } else {
      deque[findex] = element;
      eindex++;
    }
  }

  /**
   * method to add element to end of deque
   * @param element elemtn to add to tail of deque
   */
  public void addLast(T element)
  {
    if (size() == deque.length) {
      expandCap();
    }

    deque[++eindex] = element;
  }

  /**
   * method to return value from front of deque
   * @return T element value at front of array
   */
  public T peekFirst() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("deque");
    }

    return deque[findex];
  }

  /**
   * method to return element value at tail of deque
   * @return  T element value at tail of array
   */
  public T peekLast() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("deque");
    }

    return deque[eindex];
  }

  /**
   * removes and returns element value at front of deque
   * @return  T element value at front of deque
   */
  public T removeFirst() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("deque");
    }

    T ret = deque[findex];
    findex++;

    return ret;
  }

  /**
   * removes and returns element value from tail of deque
   * @return T  element value from end of deque
   */
  public T removeLast() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("deque");
    }

    T ret = deque[eindex];
    eindex--;

    return ret;
  }

  /**
   * returns true/false value for presence of elements in deque
   * @return  boolean true if elements are present, false if not
   */
  public boolean isEmpty()
  {
    return size() == 0;
  }

  public int size()
  {
    int t = eindex - findex;
    return eindex - findex;
  }

  /**
   * Private function to grow underlying array if stack grows beyond initial array size.
   * The size of the original array is simply doubled.
   */
  public void expandCap()
  {
    deque = Arrays.copyOf(deque, deque.length * 2);
  }
}
  
