package jsjf;

/**
 * Node class for linked list StackADT implementation
 * @author  Murray Butler
 * @version 1.2
 */

public class LinearNode<T>
{
  // private members
  private LinearNode<T> next;
  private T element;

  // public interfaces
  /**
   * Base constructor
   */
  public LinearNode()
  {
    next = null;
    element = null;
  }

  /** PArameterized constructor
   * @param elem  Element at top of stack
   */
  public LinearNode(T elem)
  {
    next = null;
    element = elem;
  }

  /**
   * Method to read next pointer in current node
   * @return  LinearNode  Returns next node pointer
   */
  public LinearNode<T> getNext() throws NullPointerException
  {
    return next;
  }

  /**
   * Method to set pointer for next node
   * @param node  Pointer to next node in list
   */
  public void setNext(LinearNode<T> node)
  {
    next = node;
  }

  /**
   * Gets value of element in node
   * @return  T Returns pointer to element of node
   */
  public T getElement()
  {
    // need to check for null and set exception
    return element;
  }
 
  /**
   * Sets element value of node
   * @param elem  Element value of node
   */
  public void setElement(T elem)
  {
    this.element = elem;
  }

}
