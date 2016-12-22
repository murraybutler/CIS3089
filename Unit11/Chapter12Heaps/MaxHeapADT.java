/**
 * HeapADT defines the interface to a Heap.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public interface MaxHeapADT<T> extends BinaryTreeADT<T> 
{
   /** 
    * Adds the specified object to this heap. 
    *
    * @param obj the element to be added to the heap
    */   
   public void addElement(T obj);
   
   /**
    * Removes element with the highest value from this heap.
    *
    * @return the element with the lowest value from the heap
    */
   public T removeMax();

   /**
    * Returns a reference to the element with the highest value in
    * this heap.
    *
    * @return a reference to the element with the lowest value in the heap
    */
   public T findMax();
}


