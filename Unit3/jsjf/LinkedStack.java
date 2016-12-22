package jsjf;

import jsjf.exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 * LinkedStack class to implement StackADT interface with a linked list.
 * @author Murray Butler
 * @version 1.2
 */
public class LinkedStack<T> implements StackADT<T>
{
  private int count;
  private LinearNode<T> top;

  /**
   * Base constructor
   */
  public LinkedStack()
  {
    count = 0;
    top = null;
  }

  /**
   * push method to place elements on the stack
   * @param element The element to be placed on the stack
   */
  public void push(T element)
  {
    LinearNode<T> tmp = new LinearNode<T>(element);

    tmp.setNext(top);
    top = tmp;
    count++;
  }

  /**
   * pop method to remove top element from the stack
   * @return  T Object of generic type at top dof stack
   */
  public T pop() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("stack");
    }

    T ret = top.getElement();
    top = top.getNext();
    count--;

    return ret;
  }

  /**
   * peek method to see value of element at front of stack
   * @return  T Object value at tope of stack
   */
  public T peek() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("stack");
    }

    return top.getElement();
  }

  /**
   * Method to return String of values in stack
   */
  public String toString() 
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("stack");
    }
    LinearNode<T> o = top;
    String out = "[";
    while (o != null) {
      out += o.getElement() + " ";
      o = o.getNext();
    }

    out += "]\n";
    return out;
  }

  /**
   * Method to determine if stack contains elements
   */
  public boolean isEmpty()
  {
    if (top == null) {
      return true;
    } else {
      return false; 
    }
  }

  /**
   * Method for returning size from count variable
   * @return int Internal counter of items pushed onto stack
   */
  public int size() 
  {
    return count;
  }

  /**
   * Alternative method for determining size by iterating over stack elements
   * @return  int Iterated size of stack
   */
  public int altSize()
  {
    LinearNode<T> c = top;
    int f = 0;
    while (c.getNext() != null) {
      f++;
      c = c.getNext();
    }

    return f;
  }

}
