import exceptions.*;
import java.util.*;

/**
 * LinkedList represents a linked implementation of a list.
 * 
 * @author Murray Butler
 * @version 1.0
 */
public abstract class LinkedList<T> implements ListADT<T>, Iterable<T>
{
    protected int count;
    protected BiNode<T> head, tail;
	  protected int modCount;
    
    /**
     * Creates an empty list.
     */
    public LinkedList()
    {
        count = 0;
        head = tail = null;
		    modCount = 0;
	  }
   
    /**
     * Removes the first element in this list and returns a reference
     * to it. Throws an EmptyCollectionException if the list is empty.
     *
     * @return a reference to the first element of this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T removeFirst() throws EmptyCollectionException
    {
      if (isEmpty()) {
        throw new EmptyCollectionException("LinkedList");
      }

      T tmp = head.getElement();
      head = head.getNext();

      count--;
      modCount++;

      return tmp;

    }
   
    /**
     * Removes the last element in this list and returns a reference
     * to it. Throws an EmptyCollectionException if the list is empty.
     *
     * @return the last element in this list
     * @throws EmptyCollectionException if the list is empty    
     */
    public T removeLast() throws EmptyCollectionException
    {
      if (isEmpty()) {
        throw new EmptyCollectionException("LinkedList");
      }

      T tmp = tail.getElement();
      tail = tail.getPrev();

      count--;
      modCount++;

      return tmp;
    }
   
    /**
     * Removes the first instance of the specified element from this
     * list and returns a reference to it. Throws an EmptyCollectionException 
     * if the list is empty. Throws a ElementNotFoundException if the 
     * specified element is not found in the list.
     *
     * @param  targetElement the element to be removed from the list
     * @return a reference to the removed element
     * @throws EmptyCollectionException if the list is empty
	   * @throws ElementNotFoundException if the target element is not found
     */
    public T remove(T targetElement) throws EmptyCollectionException, 
         ElementNotFoundException 
    {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedList");
      
        boolean found = false;
        BiNode<T> finder = head;
        T tmp = null;

        while (!isEmpty() && !found) {
          if (targetElement.equals(finder.getElement())) {
            found = true;
            tmp = finder.getElement();
            finder.getPrev().setNext(finder.getNext());
            finder.getNext().setPrev(finder.getPrev());
            break;
          } else {
            finder = finder.getNext();
          }
        }
            
        if (!found) {
          throw new ElementNotFoundException("LinkedList");
        }

      
      count--;
		  modCount++;
      
      return tmp;
    }
   
    /**
     * Returns the first element in this list without removing it. 
     *
     * @return the first element in this list
	   * @throws EmptyCollectionException if the list is empty
     */
    public T first() throws EmptyCollectionException
    {
      return head.getElement();
    }
	
    /**
     * Returns the last element in this list without removing it. 
     *
     * @return the last element in this list  
	   * @throws EmptyCollectionException if the list is empty
     */
    public T last() throws EmptyCollectionException
    {
      return tail.getElement();
    }
	
    /**
     * Returns true if the specified element is found in this list and 
     * false otherwise. Throws an EmptyCollectionException if the list 
	   * is empty.
     *
     * @param  targetElement the element that is sought in the list
     * @return true if the element is found in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public boolean contains(T targetElement) throws 
         EmptyCollectionException 
    {
      if (isEmpty()) {
        throw new EmptyCollectionException("LinkedList");
      }

      boolean found = false;
      BiNode<T> finder = head;

      for (Iterator<T> itr = iterator();;itr.hasNext()) {
        if (itr.next() == targetElement) {
          found = true;
          break;
        }
      }

      if (!found) {
        throw new ElementNotFoundException("LinkedList");
      }

      return found;
    }
   
    /**
     * Returns true if this list is empty and false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
      return count == 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in the list
     */
    public int size()
    {
      return count;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of the list    
     */
    public String toString()
    {
      StringBuilder sb = new StringBuilder();
      sb.append('[');

      for (Iterator<T> itr = iterator();;itr.hasNext()) {
        T e = itr.next();
        sb.append(e);
       
        if (! itr.hasNext()) {
          return sb.append(']').toString();
        }
     
        sb.append(" ");
      }
    }

    /**
     * Returns an iterator for the elements in this list. 
     *
     * @return an iterator over the elements of the list
     */
    public Iterator<T> iterator()
    {
        return new LinkedListIterator();
    }

	/**
	 * LinkedIterator represents an iterator for a linked list of linear nodes.
	 */
	private class LinkedListIterator implements Iterator<T>
	{
		private int iteratorModCount;  // the number of elements in the collection
		private BiNode<T> current;  // the current position
		
		/**
		 * Sets up this iterator using the specified items.
		 *
		 * @param collection  the collection the iterator will move over
		 * @param size        the integer size of the collection
		 */
		public LinkedListIterator()
		{
			current = head;
			iteratorModCount = modCount;
		}
		
		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (iteratorModCount != modCount) 
				throw new ConcurrentModificationException();
			
			return (current != null);
		}
		
		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */
		public T next() throws ConcurrentModificationException
		{
			if (!hasNext())
				throw new NoSuchElementException();
			
			T result = current.getElement();
			current = current.getNext();
			return result;
		}

    /**
     * removes the current element
     *
     */
    public void remove() throws ConcurrentModificationException
    {
      if (current != null) {
        if (current.getPrev() != null) {
          current.getPrev().setNext(current.getNext());
        } else {
          head = current.getNext();
        }
      }
    }
  }
}
