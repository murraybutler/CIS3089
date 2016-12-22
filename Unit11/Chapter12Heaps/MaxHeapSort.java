/**
 * HeapSort sorts a given array of Comparable objects using a heap.
 * 
 * @author Murray Butler
 * @version 1.0
 */
public class MaxHeapSort<T>
{
    /**
     * Sorts the specified array using a Heap
	 *
	 * @param data the data to be added to the heapsort
     */
	public void heapSort(T[] data) 
	{
		ArrayMaxHeap<T> temp = new ArrayMaxHeap<T>();

		// copy the array into a heap 
		for (int i = 0; i < data.length; i++)
		    temp.addElement(data[i]);

		// place the sorted elements back into the array 
		int count = 0;
		while (!(temp.isEmpty()))
		{
			data[count] = temp.removeMax();
			count++;
		}
	}
}


