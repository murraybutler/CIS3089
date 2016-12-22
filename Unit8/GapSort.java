

public class GapSort
{
  /**
    * Sorts the specified array of objects using a bubble sort
    * algorithm. But we're adding a gap so it can sort in increments.
    *
    * @param data the array to be sorted
    * @param gap  int of the gap length
    */
   public static <T extends Comparable<T>>
   void bubbleSort(T[] data)
   {
       int position, scan, gap;
       boolean sorted = false;
       T temp;

       gap = data.length;

      while (!sorted) {
       boolean swap = false;
       if (gap > 1) {
          gap = (int)((double)gap/1.3);
       }
       System.out.println("gap is: " + gap);

       for (scan = 0; scan + gap < data.length; scan++)
       {
         int gscan = scan + gap;
         System.out.println("Comparing: " + scan + ":" + data[scan] + " to " + gscan + ":" 
             + data[scan + gap]);
          if (data[scan].compareTo(data[scan + gap]) > 0) {
            SortB.swap(data, scan, scan + gap);
            swap = true;
          }
       }

       if (gap <= 1 && !swap) {
         System.out.println("set sorted");
         sorted = true;
       }
     }
   }
}
