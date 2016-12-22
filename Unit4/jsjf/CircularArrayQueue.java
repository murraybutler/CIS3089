/**
 * CircularArrayQueue represents an array implementation of a queue in 
 * which the indexes for the front and rear of the queue circle back to 0
 * when they reach the end of the array.
 * 
 * @author Murray Butler
 * @version 1.0
 */
public class CircularArrayQueue<T> implements QueueADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue; 
  
    /**
     * Creates an empty queue using the specified capacity.
     * @param initialCapacity the initial size of the circular array queue
     */
    public CircularArrayQueue (int initialCapacity)
    {
        //To be completed in class
    }
  
    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue()
    {
        //To be completed in class
    }    
	
	/**
     * Adds the specified element to the rear of this queue, expanding
     * the capacity of the queue array if necessary.
     * @param element the element to add to the rear of the queue
     */
    public void enqueue(T element)
    {
        //To be completed in class
    }
	
	/**
     * Creates a new array to store the contents of this queue with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        //To be completed in class
    }
	
    /**
     * Removes the element at the front of this queue and returns a
     * reference to it. 
	 * @return the element removed from the front of the queue
     * @throws EmptyCollectionException  if the queue is empty
     */
    public T dequeue() throws EmptyCollectionException
    {
        return null;
        //To be completed in class
    }
  
    /** 
     * Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.  
     * @return the first element in the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first() throws EmptyCollectionException
    {
        return null;
        // To be completed as a Programming Project
    }
  
    /**
     * Returns true if this queue is empty and false otherwise.
     * @return true if this queue is empty 
     */
    public boolean isEmpty()
    {
        return true;
        // To be completed as a Programming Project
    }
  
    /**
     * Returns the number of elements currently in this queue.
     * @return the size of the queue
     */
    public int size()
    {
        return 0;
        // To be completed as a Programming Project
    }
  
    /**
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString()
    {
        return "";
        // To be completed as a Programming Project
    }
}
