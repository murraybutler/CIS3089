
/**
 * A simple driver for the HashMap structure
 * @author  Murray Butler
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class hashDriver
{
  /**
   * Simple and easy.  Put some values in, get some out, remove one.
   */
  public static void main(String args[])
  {

    HashMap<String,String> test = new HashMap();
   
    System.out.println("Loading HashMap.."); 
    test.put("466789234","Mary J Blige");
    test.put("123456789","EE Cummings");
    test.put("987123463","Sum Guy");
    test.put("987237654","Bill W");
    test.put("918273645","Stuff N Things");
    test.put("856273645","S N T");

    System.out.println("\n\nFinding some elements (and a collision)..");
    String ret = test.get("123456789");
    System.out.println("First try: " + ret);

    ret = test.get("987123463");
    System.out.println("Second try: " + ret);

    ret = test.get("466789234");
    System.out.println("Third try: " + ret);

    ret = test.get("856273645");
    System.out.println("Fourth try: " + ret);

    ret = test.get("918273645");
    System.out.println("Fourth try: " + ret);

    System.out.println("\n\nLet's remove something...  And try to get it.");
    test.remove("987123463");
    ret = test.get("987123463");
    System.out.println("Removed: " + ret); 
  }
}


