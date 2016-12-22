/**
 * QueuTester driver class
 * @author Murray Butler
 * @version 1.1
 */
import java.util.*;

/**
 * Class to drive Unit 4 Assignment.
 */
public class Tweetdriver {

  /** 
   * Main function of driver class.
   * @param String std input
   * @return void
   */
  public static void main(String args[]) {
    
    LinkedOrderedList<Tweet<String>> deq = new LinkedOrderedList<Tweet<String>>();
   
    ArrayList<String> t = new ArrayList<String>();
      t.add("I like popcorn"); 
      t.add("my dog is cute");
      t.add("Kardashians are hilarious");
      t.add("I hate twitter");

    String h = "TwerkFrk";

   
    for (int i = 0; i < t.size(); i++) {
      Date dNow = new Date();
      Tweet<String> twt = new Tweet<String>(dNow, h, t.get(i));
      deq.add(twt);
    }


    for (int i = 0; i < t.size(); i++) {
      Tweet<String> out = deq.removeFirst();
      System.out.println("Date: " + out.getDate());
      System.out.println("Handle: " + out.getHandle());
      System.out.println("Date: " + out.getElement() + "\n\n");
    }
  }
}
