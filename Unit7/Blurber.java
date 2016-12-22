import java.io.*;
import java.util.*;

/**
 * A class to generate a "blurb"; a Whoozit followed by one or more Whatzits. 
 * A Whoozit is the character ‘x’ followed by zero or more ‘y’s. 
 * A Whatzit is a ‘q’ followed by either a ‘z’ or a ‘d’ followed by 
 * a Whoozit.
 * @author  Murray Butler
 * @version 1.0
 */
public class Blurber
{
 
  Random i = new Random();

  /**
   * The blurb generator method
   * @return String the Blurb
   */
  private String genBlurb()
  {
    String b = "";
    int w = i.nextInt(20) - 1;

    b += genWhoozit();

    while (w > 0) {
      b += genWhatzit(w);
      w--;
    }

    return b;
  }

  /**
   * The Whoozit generating method
   * @return String Whoozit
   */
  private String genWhoozit()
  {
    String wo = "x";

    while (i.nextInt() % 2 == 0) {
      wo += "y";
    }

    return wo;
  }

  /**
   * The Whatzit generator method
   * @param int rand number of times to call for Whoozit
   * @return String the Whatzit
   */
  private String genWhatzit(int g)
  {
    boolean t;
    String wa = "";
    
    t = i.nextBoolean();
    if (t) {
      wa += "qz";
    } else {
      wa += "qd";
    }

    if (g == 0) {
      return wa;
    } else {
      wa += genWhoozit();
    }
   
    return wa;
  }


  /**
   * Verification method
   * @param String the Blurb
   * @return boolean true/false "is a" Blurb
   */
  private boolean verifyBlurb(String blurb)
  {
    int postWho = preWho(blurb);
    
    if (postWho >= blurb.length()) {
      return false;
    } else {
      return findWhat(blurb.substring(postWho));
    }
  }

  /**
   * Find the end of the first Whoozit method
   * @param String the Blurb
   * @return int index of start of Whoozit
   */
  private int preWho(String b)
  {
    int j = 0;
    if (b.charAt(j) == 'x') {
      j++;
      while (j < b.length() && b.charAt(j) == 'y') {
        j++;
      }
      return j;
    } else {
      return -1;
    }
  }

  /**
   * Method to validate Whatzit string in Blurb
   * @param String input Blurb
   * @return boolean true/false is valid Whatzit
   */
  private boolean findWhat(String b)
  {
    if ((!b.startsWith("qd") && !b.startsWith("qz")) || b.length() < 3) {
      return false;
    }
    
    // move us beyond the "qz"/"qd" prefix
    b = b.substring(2);
    int postWho = preWho(b);

    if (postWho == -1) {
      return false;
    } else if (postWho == b.length()) {
      return true;
    } else {
      return findWhat(b.substring(postWho));
    }
  }

  /**
   * main method for class
   */
  public static void main(String[] args)
  {
    Blurber b = new Blurber();
    String blurb = b.genBlurb();
    
    System.out.println("blurb: " + blurb);
    System.out.println("Checking blurb...");
    
    boolean vblurb = b.verifyBlurb(blurb);
    
    System.out.println("Verification of blurb: " + blurb + "\nVerdict: " + vblurb);


  }
}
