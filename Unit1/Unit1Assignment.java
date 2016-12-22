/**
 * Class built for Unit 1 of CIS3089.  Contains 3 method assignments: randomAvg(), bigDiff(int[]), 
 * and matchUp(String[], String{})
 * @author  Murray Butler
 * @version 1.0
 */
import java.util.stream.IntStream;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Unit1Assignment
{
  public static void main(String[] args) 
  {
    /**
     * Instantiation of class and creation of test data.
     * Test data is constructed as a matrix, so data arrays
     * will be cycled against all other arrays in test.
     */
    Unit1Assignment Unit1Ass = new Unit1Assignment();
    int ret = 0;
   
    /**
     * Test data for bigDiff() method tests
     */
    int[][] testarrays = {
                          {2,5,7,1,9,10},
                          {0,0,0,0,0,0},
                          {Integer.MAX_VALUE,3,4,2,Integer.MIN_VALUE},
                          {},
                          {Integer.MAX_VALUE,0,0,0,0,Integer.MAX_VALUE},
                          {543,738,7216,78129,123,8820}
    };

    /**
     * Test data for matchUp() method tests
     */
    String[][] wordarrays = {
                            {"","","","","",""},
                            {" "," "," "," "," "," "},
                            {"\n","\t","r\n","a\t"},
                            {"aaa","bb","c","dd","eee"},
                            {"a","bbb","cc","ddd","e"},
                            {"f","gg","cccc","r"},
                            {"5","t'h","738","a45"},
                            {"","t'h","73,8","45a"}
    };

    /**
     * Test run for randomAvg() method
     */
    System.out.println("Test run for randomAvg() method.");
    Unit1Ass.randomAvg();  
  
    /**
     * Test run for bigDiff() method
     */
    System.out.println("\n\nTest run for bigDiff() method.");
    for (int i = 0; i < testarrays.length; i++) {
      try {
        ret = Unit1Ass.bigDiff(testarrays[i]);
      }

      catch (IllegalArgumentException ex) {
        System.out.println(ex);
      }

      System.out.println(ret);
    }

    /**
     * Test run for matchUp() method
     */
    System.out.println("\n\nTest run for matchUp() method.");
    for (int j = 0; j < wordarrays.length; j++) {
      for (int n = j+1; n < wordarrays.length; n++) {
        try {
          ret = Unit1Ass.matchUp(wordarrays[j], wordarrays[n]);
          System.out.println(ret);
        }
        
        catch (IllegalArgumentException ex) {
          System.out.println(ex);
        }

      }

    }

  } //end of main function


  /**
   * A self contained method for totalling the values in a randomly generated array of ints 0..99, inclusive.
   * The array is generated local to the method at each call.  The ThreadLocalRandom collection verifies
   * the elements as correct type and value. The sum of the array is done via IntStream, Java1.8 or later.
   * <p>
   * Output consists of printing the numbers in the array and the average of the numbers.
   * @param none  No Input parameters
   * @return      Void return type
   */
  public void randomAvg()
  {
    int[] nums = new int[15];
    int min = 0;
    int max = 99;
   
    for (int i = 14; i >= 0; i--) {
      nums[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
      System.out.print(nums[i] + " ");
      System.out.flush();
    }

    int sum = IntStream.of(nums).sum();
    System.out.println("\nAverage of numbers: " + (sum / nums.length));
  }


  /**
   * A method for determining the largest difference present in an integer array.
   * The search is short circuited via sorting the array and subtracting the first element from last.
   * <p>
   * The method returns an integer that is the largest difference between two members
   * in the array, or we return -1 on a null or empty array. 
   * @param nums  Array of integers 
   * @return      Integer, largest difference between elements
   */
  public int bigDiff(int[] nums)
  {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("Illegal array length");
    } 
  
    Arrays.sort(nums);
    return (nums[nums.length - 1] - nums[0]); 
  }


  /**
   * A method to match arrays of strings that are not NULL and start with the same letter.
   * <p>
   * The return value is the number of times the strings in the array meet the matching criteria.
   * @param testA String Array contianing multiple strings of different lengths
   * @param testB String Array contianing multiple strings of different lengths
   * @return      Number of times the strings contained in the arrays are NOT NULL and start with the same
   * character
   */
  public int matchUp(String[] textA, String[] textB)
  {
    /**
     * scrub inputs
     */
    if (textA == null || textB == null) {
      throw new IllegalArgumentException("Illegal array length");
    }

    if (textA.length == 0 || textB.length == 0) {
      throw new IllegalArgumentException("Illegal array lenght");
    }

    if (textA.length != textB.length) {
      throw new IllegalArgumentException("Illegal array length");
    }

    int found = 0;
    for (int i = 0; i < textA.length; i++) {
      if (!checkString(textA[i])) {
        continue;
      }
  
      for (int j = 0; j < textB.length; j++) {
        if (!checkString(textB[j])) {
          continue;
        }
     
        if (textB[j].startsWith(textA[i].substring(0, 1))) {
          found++;
        }
      
      }
    
    }

    return found;
  }

  /**
   * A private helper function to determine the validity of a string.
   * <p>
   * Used to help matchUP() function determine valid string inputs for comparison.
   * @param ins String to be checked
   * @return    boolean true or false
   */
  private boolean checkString(String ins)
  {
    if (ins == null || ins.matches("^\\s+")) {
      return false;
    } else {
      return true;
    }
  
  }

}
