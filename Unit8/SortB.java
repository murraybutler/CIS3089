

public class SortB
{

  /**
    * Sorts the specified array of objects using the quick sort algorithm.
    *
    * @param data the array to be sorted
    */
   public static <T extends Comparable<T>>
     void quickSort(T[] data)
   {
     quickSort(data, 0, data.length - 1);
   }

   /**
    * Recursively sorts a range of objects in the specified array using the
    * quick sort algorithm.
    *
    * @param data the array to be sorted
    * @param min  the minimum index in the range to be sorted
    * @param max  the maximum index in the range to be sorted
    */
   private static <T extends Comparable<T>>
     void quickSort(T[] data, int min, int max)
   {
     if (min < max)
     {
       // create partitions
       int indexofpartition = partition(data, min, max);

       // sort the left partition (lower values)
       quickSort(data, min, indexofpartition - 1);

       // sort the right partition (higher values)
       quickSort(data, indexofpartition + 1, max);
     }
   }

   /**
    * Used by the quick sort algorithm to find the partition.
    *
    * @param data the array to be sorted
    * @param min  the minimum index in the range to be sorted
    * @param max  the maximum index in the range to be sorted
    */
   private static <T extends Comparable<T>>
     int partition(T[] data, int min, int max)
   {
     T partitionelement;
     int left, right;
     int middle = (min + max) / 2;

     // use the middle data value as the partition element
     if (data.length < 5) { 
      partitionelement = data[middle];
      swap(data, middle, min);
     } else {
      partitionelement = med3(data, min, max);
     }

     left = min;
     right = max;

     while (left < right)
     {
       // search for an element that is > the partition element
       while (left < right && data[left].compareTo(partitionelement) <= 0)
         left++;

       // search for an element that is < the partition element
       while (data[right].compareTo(partitionelement) > 0)
         right--;

       // swap the elements
       if (left < right)
         swap(data, left, right);
     }

     // move the partition element into place
     swap(data, min, right);

     return right;
   }

  /**
    * Swaps to elements in an array. Used by various sorting algorithms.
    * This is public, since I'm using it in another sort class.
    *
    * @param data   the array in which the elements are swapped
    * @param index1 the index of the first element to be swapped
    * @param index2 the index of the second element to be swapped
    */
   public static <T extends Comparable<T>>
     void swap(T[] data, int index1, int index2)
   {
     T temp = data[index1];
     data[index1] = data[index2];
     data[index2] = temp;
   }

  /**
   * Find the median of 3 elements to pivot
   *
   * @param data  the array in which the elements are swapped
   * @param i1 the index of the first element to be swapped
   * @param i2 the index of the second element to be swapped
   */
  private static <T extends Comparable<T>>
    T med3(T[] data, int i1, int i2)
    {
      if (data.length < 5) {
        return data[i2 - 1];
      } else {
        int med = (i1 + i2)>>>1;

        if (data[med].compareTo(data[i1]) < 0) {
          swap(data, i1, med);
        }

        if (data[i1].compareTo(data[i2]) < 0) {
          swap(data, i1, i2);
        }

        if (data[i2].compareTo(data[med]) < 0) {
          swap(data, med, i2);
        }

        swap(data, med, i2 - 1);
        return data[i2 - 1];
      }
    }
}
