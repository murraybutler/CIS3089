import java.util.Random;
import exceptions.*;
/**
 * A cheap driver to perform some operations on a randomly created BST
 */
public class BSTDriver
{

  /** 
   * The main class for the driver
   */
  public static void main(String[] args)
  {

    Random rando = new Random();
    int len = 4 + rando.nextInt(50);
    LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();
    
    for (int i = 0; i < len; i++) {
      tree.addElement(rando.nextInt(90));
    }

    System.out.println("Search Tree Ops");

    System.out.println("Search Tree as String");
    String treout = tree.toString();
    System.out.println("Tree: " + treout); 

    System.out.println("Search Tree Find");
    try {
    Integer fnd = tree.find(rando.nextInt(60));
    System.out.println("Found : " + fnd);
    } catch (ElementNotFoundException e) {
      System.out.println("ElemNotFoundException: " + e.getMessage());
    }

    System.out.println("Search Tree FindMin");
    Integer min = tree.findMin();
    System.out.println("FindMin : " + min);


    System.out.println("Search Tree FindMax");
    Integer max = tree.findMax();
    System.out.println("FindMax : " + max);

  }
}
