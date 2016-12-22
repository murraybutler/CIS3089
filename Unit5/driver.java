/**
 * QueuTester driver class
 * @author Murray Butler
 * @version 1.1
 */
import java.util.Scanner;

/**
 * Class to drive Unit 4 Assignment.
 */
public class driver {

  /** 
   * Main function of driver class.
   * @param String std input
   * @return void
   */
  public static void main(String args[]) {
    
    // Instantiate our ADT
    //ArrayDeque<String> ars = new ArrayDeque<String>(200);
    //ArrayDeque<String> deq = new ArrayDeque<String>(200);
    //LinkDeque<String> ars = new LinkDeque<String>();
    LinkedOrderedList<String> deq = new LinkedOrderedList<String>();
    
    System.out.println("enter sentence below:");
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    System.out.println("words or letters?");
    String a = scanner.nextLine();

    //String s = "Test sentence to get things moving";
    //String a = "letters";

    // Given the choice of reversing the word order or letters
    if (a.equalsIgnoreCase("words") || a.equalsIgnoreCase("letters")) {
      switch(a) {
        case "letters":
         for (int i = 0; i < s.length(); i++) {
           //ars.addLast(s.substring(i, i+1));
           deq.add(s.substring(i, i+1));
         }

         //Test out the toString method for clarity, commented out.
         //if (ars.isEmpty()) {
         //  System.out.println("stack is empty!!");
         //} else {
           System.out.println(deq.toString());
         //  System.out.println(ars.toString());
         //}

         //System.out.println("Last: ");
         // for (int j = s.length() + 1; j >= 0; j--) {
         //while (!ars.isEmpty()) {  
         // System.out.print(ars.removeLast());
         //}

         System.out.println("\nFirst: ");
         //for (int j = 0; j < s.length(); j++) {
         while (!deq.isEmpty()) { 
           System.out.print(deq.removeFirst());
          // System.out.print(deq.removeLast());
         }
         break;

        case "words":
         String[] words = s.split("\\s+");
         for (int i = 0; i < words.length; i++) {
          // ars.addLast(words[i]);
           deq.add(words[i]);
         }
        
         //for (int j = words.length; j >= 0; j--) {
         //  System.out.print(ars.removeLast() + " ");
        // }
        // System.out.println("");

         while (!deq.isEmpty()) { 
           //System.out.print(deq.removeFirst() + " ");
           System.out.print(deq.removeLast() + " ");
         }
         System.out.println("");

         break;
      }
    }
        System.out.println("");
  }
}
