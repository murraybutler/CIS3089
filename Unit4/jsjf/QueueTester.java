/**
 * QueuTester driver class
 * @author Murray Butler
 * @version 1.0
 */
import java.util.Scanner;

/**
 * Class to drive Unit 4 Assignment.
 */
public class QueueTester {

  /** 
   * Main function of driver class.
   * @param String std input
   * @return void
   */
  public static void main(String args[]) {
    
    // Instantiate our ADT
    ArrayDeque<String> ars = new ArrayDeque<String>(200);
    LinkDeque<String> deq = new LinkDeque<String>();
    
    System.out.println("enter sentence below:");
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    System.out.println("words or letters?");
    String a = scanner.nextLine();

    // Given the choice of reversing the word order or letters
    if (a.equalsIgnoreCase("words") || a.equalsIgnoreCase("letters")) {
      switch(a) {
        case "letters":
         for (int i = 0; i < s.length(); i++) {
           ars.addLast(s.substring(i, i+1));
           deq.addFirst(s.substring(i, i+1));
         }

         //Test out the toString method for clarity, commented out.
         //if (ars.isEmpty()) {
         //  System.out.println("stack is empty!!");
         //} else {
         //  System.out.println(ars.toString());
         //}

         System.out.println("Last: ");
         while (!ars.isEmpty()) {         
           System.out.print(ars.removeLast());
         }
         System.out.println("");

         System.out.println("First: ");
         while (!deq.isEmpty()) {         
           System.out.print(deq.removeFirst());
         }
         break;

        case "words":
         String[] words = s.split("\\s+");
         for (int i = 0; i < words.length; i++) {
           ars.addLast(words[i]);
           deq.addFirst(words[i]);
         }
        
         System.out.println("Last:");
         while (!ars.isEmpty()) {         
           System.out.print(ars.removeLast() + " ");
         }
         System.out.println("");

         System.out.println("First:");
         while (!deq.isEmpty()) {         
           System.out.print(deq.removeFirst() + " ");
         }
         System.out.println("");

         break;
      }
    }
        System.out.println("");
  }
}
