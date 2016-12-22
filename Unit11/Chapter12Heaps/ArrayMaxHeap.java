import exceptions.*;

/**
 * ArrayMaxHeap provides an array implementation of a minheap.
 * 
 * @author Murray Butler
 * @version 1.0
 */
public class ArrayMaxHeap<T> extends ArrayBinaryTree<T> implements MaxHeapADT<T> 
{
    /**
     * Creates an empty heap.
     */
    public ArrayMaxHeap() 
    {
        super();
    }

    /**
     * REturn parent index
     * @param child child index
     */
    private int parent(int child)
    {
      return (child - 1)/2;
    }

    /**
     * Return left child of index
     * @param parent parent index
     * @return int left child index
     */
    private int left(int parent)
    {
      return 2 * parent + 1;
    }

    /**
     * REturn right child of index
     * @param parent parent index
     * @return int right child index
     */
    private int right(int parent)
    {
      return 2 * (parent + 1);
    }
    
    /**
     * Adds the specified element to this heap in the appropriate
     * position according to its key value.  
     *
     * @param obj the element to be added to the heap
     */
    public void addElement(T obj) 
    {
        if (count == tree.length)
            expandCapacity();

        tree[count] = obj;
        count++;
	    modCount++;

        if (count > 1)
            heapifyAdd();
    }

    /**
     * Reorders this heap to maintain the ordering property after
     * adding a node.
     */
    private void heapifyAdd()
    {
        T temp;
        int next = count - 1;
        
        temp = tree[next];
       
        // Changed to compare for larger than zero result for Max
        while ((next != 0) && 
			(((Comparable)temp).compareTo(tree[parent(next)]) > 0))
        {
            //System.out.println("Moving " + temp + " to index " + parent(next));
            tree[next] = tree[parent(next)];
            next = parent(next);
            //System.out.println(temp + " at index " + next);
        }

        tree[next] = temp;
    }

    /**
     * Remove the element with the lowest value in this heap and
     * returns a reference to it. Throws an EmptyCollectionException if
     * the heap is empty.
     *
     * @return a reference to the element with the lowest value in this heap
     * @throws EmptyCollectionException if the heap is empty
     */
    public T removeMax() throws EmptyCollectionException 
    {
        if (isEmpty())
            throw new EmptyCollectionException("ArrayMaxHeap");

        T maxElement = tree[0];
        tree[0] = tree[count-1];
        //heapifyRemove();
        heapifyRem(0);
        count--;
		modCount--;
        
        return maxElement;
    }
    
    /**
     * Determines if node is a leaf node with no children
     * @param pos index to inspect
     * @return boolean is/is not leaf
     */
    private boolean isLeaf(int pos)
    {
      if (pos >= (count/2) && pos <= count) {
        return true;
      }
      return false;
    }

    /**
     * Reorders this heap to maintain the ordering property
     * after the minimum element has been removed.
     * @param int position index to start from (for recursion)
     */
    private void heapifyRem(int pos)
    {
      if (!isLeaf(pos)) {
        if (((Comparable)tree[pos]).compareTo(tree[left(pos)]) < 0 || ((Comparable)tree[pos]).compareTo(tree[right(pos)]) < 0) {
          if (((Comparable)tree[left(pos)]).compareTo(tree[right(pos)]) > 0) {
            swap(pos, left(pos));
            heapifyRem(left(pos));
          } else {
            swap(pos, right(pos));
            heapifyRem(right(pos));
          }
        }
      }
    }
    
    /**
     * Returns the element with the lowest value in this heap.
     * Throws an EmptyCollectionException if the heap is empty.
     *
     * @return the element with the lowest value in this heap
     * @throws EmptyCollectionException if the heap is empty
     */
    public T findMax() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("ArrayHeap");
        
        return tree[0];
    }

    /**
     * Swaps first and second inputs
     * @param first index of first element
     * @param second index of second element
     */
    public void swap(int first, int second)
    {
      T temp;
      temp = tree[first];
      tree[first] = tree[second];
      tree[second] = temp;
    }

    /**
     * public interface to print heap to string
     */
    public String printHeap() {
        
        if (count != 0) {
            StringBuilder build = new StringBuilder();
            
            printHeap(build, 0, "-");
            
            return build.toString();
        }
        else {
            
            return "-";
        }
    }
    
    /**
     * Helper recursive method for printHeap. Traverses down to the rightmost element, 
     * and then prints it; with the help of the properties of a heap in an array.
     *  
     * @param build the StringBuilder object used to concatenate the string together.
     */
    private void printHeap(StringBuilder build, int index, String branch) {
        
        //check if there is a right element. 
        if (right(index) < count && tree[right(index)] != null) {
           
            //if so, follow it.
            printHeap(build, right(index), branch + "----");
        }
        //print the item at index, with appropriate formatting.
        build.append(branch).append("|").append(tree[index].toString()).append("\n");
        //check if there is a left element
        if (left(index) < count && tree[left(index)] != null) {
            
            printHeap(build, left(index), branch + "----");
        }
    }


}


