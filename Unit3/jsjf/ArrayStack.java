package jsjf;

/**
 * ArrayStack class to implement StacjAbstractDataType interface.
 * @author  Murray Butler
 * @version 1.0
 */
import jsjf.exceptions.*;
import java.util.Arrays;

/**
 * StackADT interface implementation of a stack data type.
 */ 
public class ArrayStack<T> implements StackADT<T>
{
  private final static int DEF_CAP = 100;

  private int tindex = 0;
  private T[] stack;


  public ArrayStack()
  {
    this(DEF_CAP);
  }

  // Suppression of warnings given the cast on an undeclared type in the constructor.
  @SuppressWarnings("unchecked")
  public ArrayStack(int initCap)
  {
    tindex = 0;
    stack = (T[])(new Object[initCap]);
  }

  // Public interface methods
  /**
   * Push method, places new element on top of stack.
   * @param T Generic element on top of stack
   */
  public void push(T element)
  {
    if (size() == stack.length) {
      expandCap();
    }

    stack[tindex] = element;
    tindex++;
  }

  /** 
   * Pop method to remove top element from stack and move stack index.
   * @return  T Geneic element from top of stack is returned and stack index is moved
   */
  public T pop() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("stack");
    }

    tindex--;
    T ret = stack[tindex];
    stack[tindex] = null; //this is extraneous as long as we track tindex correctly

    return ret;
  }

  /**
   * Peek method returns next availble element without moving stack index.
   * @return  T Generic element is returned
   */
  public T peek() throws EmptyCollectionException
  {
    if (isEmpty()) {
      throw new EmptyCollectionException("stack");
    }

    return stack[tindex - 1];
  }

  /**
   * Oerridden toString method, converts stack contents to String object for printing.
   */
  @Override
  public String toString() {
    if(isEmpty()) {
      throw new EmptyCollectionException("stack"); 
    }

    StringBuffer out = new StringBuffer("[");
    for(int i = 0; i < tindex; i++) {
      out.append(stack[i] + " ");
    }

    out.append(stack[tindex] + "]");
    return out.toString();
  }

  /**
   * Simple method to determine if current stack contains any objects.
   */
  public boolean isEmpty()
  {
    return tindex == 0;
  }
    
  /**
   * Overridden size method to return the size of the current stack.
   */
  @Override
  public int size()
  {
      return tindex - 1;
  }

  // Internal methods

  /**
   * Private function to grow underlying array if stack grows beyond initial array size.
   * <p>
   * The size of the original array is simply doubled.
   */
  private void expandCap()
  {
    stack = Arrays.copyOf(stack, stack.length * 2);
  }
}
