import java.util.*;
import exceptions.*;

/** 
 * Implementation of binary tree in an array
 * @author  Murray Butler
 * @version 1.0
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>
{

  protected int count;
  protected T[] tree;
  private int len = 50;
  private int root = 0;

  /**
   * Constructor of empty Binary tree
   */
  @SuppressWarnings("unchecked")
  public ArrayBinaryTree()
  {
    int count = 0;
    tree = (T[]) new Object[len];
  }

  /**
   * Creates Binary tree with one element (root)
   * @param element root element
   */
  @SuppressWarnings("unchecked")
  public ArrayBinaryTree(T element)
  {
    int count = 1;
    tree = (T[]) new Object[len];
    tree[0] = element;
    int rindex = 0;
    int pindex = 0;

  }

  /**
   * Method to grow underlying array in the case where the tree expands beyond the limit of the current array
   */
  @SuppressWarnings("unchecked")
  protected void grow()
  {
    T[] tmp = (T[]) new Object[len * 2];

    for (int i = 0; i < tree.length; i++) {
      tmp[i] = tree[i];
    }

    tree = tmp;
  }

  /**
   * Returns root element value in tree
   * @return T element at index 0
   */
  public T getRootElement()
  {
    return tree[0];
  }

  /**
   * Test if collection is empty
   * @return boolean true if empty
   */
  public boolean isEmpty()
  {
    return (count == 0);
  }

  /**
   * Returns the number of elements in the current tree
   * @return int  count of elements in tree
   */
  public int size()
  {
    return count;
  }

  /**
   * Returns the left child node's index in the array
   * @param int Index of parent
   * @return  int Index of left child node
   */
  private int leftNode(int pindex)
  { 
    return 2 * pindex + 1;
  }

  /**
   * Returns the right child node's index in the array
   * @param int Index of the parent node
   * @return  int Index of the right child node
   */
  private int rightNode(int pindex)
  { 
    return 2 * (pindex + 1);
  }

  /**
   * Returns the midpoint of the array for use in search and insert
   * @param int begin index
   * @param int end index
   * @return int  midpoint of indices
   */
  private int midpoint(int b, int e)
  {
    return (b + e)>>>1; 
  }

  /**
   * Returns parent node of given child
   * @param int Index of child node
   * @return  int Index of parent node
   */
  private int findParent(int cindex)
  {
    return cindex/2;
  }

  /**
   * Returns true/false if the tree contains the value
   * @param T Element to search for
   * @return  boolean True/False if the element is contained in the array
   * @throws ElementNotFoundException
   */
  public boolean contains(T targetElement) throws ElementNotFoundException
  {
    boolean fnd = false;
    int tindex = -1; 
    // int tindex = binarySearch(tree, targetElement); This is sooo much faster...

    for (int i = 0; i < tree.length; i++) {  // Linear search
      if (tree[i] == targetElement) {
        fnd = true;
      }

      if (tindex < 0) {
        throw new ElementNotFoundException("ArrayBinaryTree");
      } else {
        fnd = true;
      }
    }

    return fnd;
  }

  /**
   * Returns the requested element reference
   * @param T Element to search for
   * @return int  Index of searched element
   * @throws ElementNotFoundException
   */
  public T find(T targetElement) throws ElementNotFoundException
  {
    // int tindex = binarySearch(tree, targetElement);

    int tindex = -1;

    for (int i = 0; i < tree.length; i++) {  // Linear search
      if (tree[i] == targetElement) {
        tindex = i;
        break;
      }
    }

    if (tindex < 0) {
      throw new ElementNotFoundException("ArrayBinaryTree");
    }  
 
    return tree[tindex];
  
  }

  /**
   * Returns a string output of the tree's contents
   * @return String String concatenation of tree elements
   */
  public String toString()
  {
    if (isEmpty()) {
      return null;
    }

    ArrayUnorderedList<T> temp = new ArrayUnorderedList<T>();
    inOrder(0, temp);
    return temp.toString();
  }

  /**
   * Returns and iterator for element sof the tree
   * @return iterator of tree elements
   */
  public Iterator<T> iterator()
  {
    return iteratorInOrder();
  }

  /**
   * Returns and iterator for element sof the tree
   * @return iterator of tree elements
   */  
  public Iterator<T> iteratorInOrder()
  {
    ArrayUnorderedList<T> temp = new ArrayUnorderedList<T>();
    inOrder(root, temp);

    return temp.iterator();
  }

  /**
   * Traverses elements in order of tree insertion
   * @param int PArent index
   * @param T[] input array
   */
  protected void inOrder(int pindex, ArrayUnorderedList<T> temp)
  {
    if (tree[pindex] != null) {
      inOrder(leftNode(pindex), temp);
      temp.addToRear(tree[pindex]);
      inOrder(rightNode(pindex), temp);
    }
  }

  /**
   * Returns and iterator for element sof the tree
   * @return iterator of tree elements
   */
  public Iterator<T> iteratorPostOrder()
  {
    ArrayUnorderedList<T> temp = new ArrayUnorderedList<T>();
    postOrder(root, temp);

    return temp.iterator();
  }

  /**
   * Traverses tree elements in post process order
   * @param int Parent Index
   * @param T[] input array
   */
  protected void postOrder(int pindex, ArrayUnorderedList<T> temp)
  {
    if (tree[pindex] != null) {
      postOrder(leftNode(pindex), temp);
      postOrder(rightNode(pindex), temp);
      temp.addToRear(tree[pindex]);
    }
  }

  /**
   * TRaverses level order 
   * @return ITerator iterator for tree in level order
   */
  public Iterator<T> iteratorLevelOrder() 
  {
    return null;
  }

  /**
   * Traverses preorder through tree
   * @return Iterator iterator for preorder tree traversal
   */
  public Iterator<T> iteratorPreOrder()
  {
    return null;
  }
}
