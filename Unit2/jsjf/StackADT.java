package jsjf;

/**
 * Interface definition for Stack implementations
 *
 * @author  Murray Butler
 * @version 1.0
 */

public interface StackADT<T>
{
  /**
   * places element at the top of the current stack.
   * @param element element to be placed on the stack
   */
  public void push(T element);

  /**
   * Remove and return top element from current stack.
   * @return  element removed from stack
   */
  public T pop();

  /**
   * Return value of element at top of current stack without removal.
   * @return element value from stack
   */
  public T peek();

  /**
   * Boolean value indicating if there are still elements on the current stack.
   * @return true if current stack empty, false otherwise
   */
  public boolean isEmpty();

  /**
   * Return size of current stack from value of top index.
   * @return number of elements in current stack (value of tope index - 1)
   */
  public int size();

  /**
   * Return string representation of elements in current stack.
   * @return string representation of current stack
   */
  public String toString();

}
