/**
 * Unit 2 Assignment driver class
 * @author Murray Butler
 * @version 1.0
 */
import jsjf.ArrayStack;
import java.util.Scanner;

/**
 * Class to drive Unit 2 Assignment.
 */
public class Unit2Assignment {

  /** 
   * Main function of driver class.
   * @param String std input
   * @return void
   */
  public static void main(String args[]) {
    
    // Instantiate our ADT
    ArrayStack<String> ars = new ArrayStack<String>(200);
    
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
           ars.push(s.substring(i, i+1));
         }

         //Test out the toString method for clarity, commented out.
         //if (ars.isEmpty()) {
         //  System.out.println("stack is empty!!");
         //} else {
         //  System.out.println(ars.toString());
         //}

         for (int j = s.length()-1; j >= 0; j--) {
           System.out.print(ars.pop());
         }
         break;

        case "words":
         String[] words = s.split("\\s+");
         for (int i = 0; i < words.length; i++) {
           ars.push(words[i]);
         }
        
         for (int j = words.length-1; j >= 0; j--) {
           System.out.print(ars.pop() + " ");
         }
         break;
      }
    }
        System.out.println("");
  }
}
