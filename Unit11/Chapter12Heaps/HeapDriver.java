import java.util.Random;
import exceptions.*;
/**
 * A cheap driver to perform some operations on a randomly created BST
 */
public class HeapDriver
{

  /** 
   * The main class for the driver
   */
  public static void main(String[] args)
  {

    Random rando = new Random();
    int len = 4 + rando.nextInt(50);
    ArrayMaxHeap<Integer> tree = new ArrayMaxHeap<Integer>();
    //ArrayHeap<Integer> mintree = new ArrayHeap<Integer>();
    
    for (int i = 0; i < len; i++) {
      Integer elem = rando.nextInt(90);
      tree.addElement(elem);
    }

    //for (int i = 0; i < len; i++) {
    //  Integer elem = rando.nextInt(90);
    //  mintree.addElement(elem);
    //}

    System.out.println("Search Tree Ops");
   
    //Integer min = tree.findMin();
    //System.out.println("Min: " + min);
    System.out.println(tree.printHeap());
    while (!tree.isEmpty()) {
      System.out.println("NextMax: " + tree.removeMax());
    }
    //System.out.println(mintree.printHeap());
    //while (!mintree.isEmpty()) {
    //  System.out.println("NextMin: " + mintree.removeMin());
    //}
    

  }
}
