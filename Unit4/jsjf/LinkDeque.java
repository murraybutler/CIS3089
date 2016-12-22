import java.util.Arrays;

/**
 * LinkDeque class that implements DequeADT using linked lists
 * @author Murray Butler
 * @version 1.0
 */
public class LinkDeque<T> implements DequeADT<T>
{
  private final static int DEF_CAP = 100;
  
  private int count;
  private BiNode<T> last, first;

  /**
   * Constructor for LinkDeque class
   */
  public LinkDeque()
  {
    count = 0;
    first = last = null;
  }

  /**
   * Constructor for LinkDeque
   * @param element element argument for node
   */
  public void addFirst(T element)
  {
    BiNode<T> node = new BiNode<T>(element);

    if (isEmpty()) {
      first = last = node;
    } else {
      node.setNext(first);
      first.setPrev(node);
    }

    first = node;
    if (last == null) { 
      last = first;
    }

    count++;
  }

  /**
   * addLast method to add element to end of deque
   * @param element element to be added to deque
   */
  public void addLast(T element)
  {
    BiNode<T> node = new BiNode<T>(element);

    if (!isEmpty()) {
    node.setPrev(last);
    last.setNext(node);
    }

    last = node;
    if (first == null) {
      first = last;
    }

    count++;
  }

  /**
   * peekFirst method to reveal first element in deque
   * @return  T returns reference to first node in deque
   */
  public T peekFirst() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("deque");
    }

    return first.getElement();
  }

  /**
   * peekLast method to return last element value in deque
   * @return  T returns reference to last node in deque
   */
  public T peekLast() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("deque");
    }

    return last.getElement();
  }

  /**
   * removeFirst method to remove first element from deque
   * @return  T returns value of element of first node in deque
   */
  public T removeFirst() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("deque");
    }

    BiNode<T> tmp = first;
    first = first.getNext();

    if (first == null) {
      last = null;
    } else {
      first.setPrev(null);
    }

    count--;
    return tmp.getElement() ;
  }

  /**
   * removeLast method to remove last element from deque
   * @return  T returns the value of the element of the first node in the deque
   */
  public T removeLast() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("deque");
    }

    BiNode<T> tmp = last;
    last = tmp.getPrev();

    if (last == null) {
      first = null;
    } else {
      last.setNext(null);
    }
    count--;

    return tmp.getElement();
  }

  /**
   * isEmpty method for deque
   * @return boolean  returns true if no values in deque
   */
  public boolean isEmpty()
  {
      return count == 0;
  }

  /**
   * size method to determine size of current deque
   * @return int  returns size of the current number of elements in the deque
   */
  public int size()
  {
    return count;
  }

  /**
   * toString method to return values in deque as a string
   * @return String returns t values of the deque as a printable string
   */
  public String toString()
  {
    BiNode<T> o = last;
    String out = "[";

    while (o != null) {
      out += o.getElement() + " ";
      o = o.getPrev();
    }

    out += "]\n";
    return out;
  }

}
  
