import java.util.*;
import exceptions.*;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>
{
    protected BinaryTreeNode<T> root; 
    protected int modCount;
    
    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() 
    {
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the binary tree
     */
    public LinkedBinaryTree(T element) 
    {
        root = new BinaryTreeNode<T>(element);
    }
    
    /**
     * Creates a binary tree with the specified element as its root and the 
     * given trees as its left child and right child
     *
     * @param element the element that will become the root of the binary tree
     * @param left the left subtree of this tree
     * @param right the right subtree of this tree
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, 
                            LinkedBinaryTree<T> right) 
    {
        root = new BinaryTreeNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }
    
    /**
     * Returns a reference to the element at the root
     *
     * @return a reference to the specified target
     * @throws EmptyCollectionException if the tree is empty
     */
    public T getRootElement() throws EmptyCollectionException
    {
        // To be completed as a Programming Project
        if(isEmpty())
            throw new EmptyCollectionException("binary tree");
            
        return root.getElement();
    }
    
    /**
     * Returns a reference to the node at the root
     *
     * @return a reference to the specified node
     * @throws EmptyCollectionException if the tree is empty
     */
    protected BinaryTreeNode<T> getRootNode() throws EmptyCollectionException
    {
        // To be completed as a Programming Project
        if(isEmpty())
            throw new EmptyCollectionException("binary tree");
            
        return root;
    }
    
    /**
     * Returns the left subtree of the root of this tree.
     *
     * @return a link to the left subtree fo the tree
     */
    public LinkedBinaryTree<T> getLeft()
    {
        // To be completed as a Programming Project  
        LinkedBinaryTree<T> tree = new LinkedBinaryTree<T>();
        tree.root = root.getLeft();            
        return tree;
    }
    
    /**
     * Returns the right subtree of the root of this tree.
     *
     * @return a link to the right subtree of the tree
     */
    public LinkedBinaryTree<T> getRight()
    {
        // To be completed as a Programming Project
        LinkedBinaryTree<T> tree = new LinkedBinaryTree<T>();
        tree.root = root.getRight();            
        return tree;
    }
    
    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty, false otherwise
     */
    public boolean isEmpty() 
    {
        return (root == null);
    }

    /**
     * Returns the integer size of this tree.
     *
     * @return the integer size of the tree
     */
    public int size() 
    {
        // To be completed as a Programming Project
        if(isEmpty())
            return 0;
        else  
            return 1 + root.numChildren();
    }
    
    /**
     * Returns the height of this tree.
     *
     * @return the height of the tree
     */
    public int getHeight()
    {
        // To be completed as a Programming Project
        return this.height(root);
    }
    
    /**
     * Returns the height of the specified node.
     *
     * @param node the node from which to calculate the height
     * @return the height of the tree
     */
    private int height(BinaryTreeNode<T> node) 
    {
        if(node == null){
            return 0;
        } else {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        }
    }
    
    /**
     * Returns true if this tree contains an element that matches the
     * specified target element and false otherwise.
     *
     * @param targetElement the element being sought in this tree
     * @return true if the element in is this tree, false otherwise
     */
    public boolean contains(T targetElement) 
    {
        // To be completed as a Programming Project
        if(this.isEmpty())
            return false;
        else if(root.getElement().equals(targetElement))
            return true;
        else {
            return (this.getRight().contains(targetElement) || this.getLeft().contains(targetElement));
        }
    }
    
    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.  Throws a ElementNotFoundException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if the element is not in the tree
     */
    public T find(T targetElement) throws ElementNotFoundException
    {
        BinaryTreeNode<T> current = findNode(targetElement, root);
        
        if (current == null)
            throw new ElementNotFoundException("LinkedBinaryTree");
        
        return (current.getElement());
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findNode(T targetElement, 
                                        BinaryTreeNode<T> next)
    {
        if (next == null)
            return null;
        
        if (next.getElement().equals(targetElement))
            return next;
        
        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
        
        if (temp == null)
            temp = findNode(targetElement, next.getRight());
        
        return temp;
    }
    
    /**
     * Returns a string representation of this binary tree showing
     * the nodes in an inorder fashion.
     *
     * @return a string representation of this binary tree
     */
    public String toString() 
    {
        // To be completed as a Programming Project
        String description = "";
        
        //left
        if(root.getLeft() != null) {
            description += this.getLeft().toString();
        }
        
        //root
        description += root.getElement() + ", ";
        
        //right
        if(root.getRight() != null) {
            description += this.getRight().toString();
        }
        
        return description;
    }

    /**
     * Returns an iterator over the elements in this tree using the 
     * iteratorInOrder method
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iterator()
    {
        return iteratorInOrder();
    }
    
    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iteratorInOrder()
    {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inOrder(BinaryTreeNode<T> node, 
                           ArrayUnorderedList<T> tempList) 
    {
        if (node != null)
        {
            inOrder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }

    /**
     * Performs an preorder traversal on this binary tree by calling 
     * an overloaded, recursive preorder method that starts with
     * the root.
     *
     * @return a pre order iterator over this tree
     */
    public Iterator<T> iteratorPreOrder() 
    {
        // To be completed as a Programming Project
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preOrder(BinaryTreeNode<T> node, 
                            ArrayUnorderedList<T> tempList) 
    {
        // To be completed as a Programming Project
        if (node != null)
        {
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }        
    }

    /**
     * Performs an postorder traversal on this binary tree by calling
     * an overloaded, recursive postorder method that starts
     * with the root.
     *
     * @return a post order iterator over this tree
     */
    public Iterator<T> iteratorPostOrder() 
    {
        // To be completed as a Programming Project
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        postOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postOrder(BinaryTreeNode<T> node, 
                             ArrayUnorderedList<T> tempList) 
    {
        // To be completed as a Programming Project
        if (node != null)
        {
            tempList.addToRear(node.getElement());
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
        }        
    }

    /**
     * Performs a levelorder traversal on this binary tree, using a
     * templist.
     *
     * @return a levelorder iterator over this binary tree
     */
    public Iterator<T> iteratorLevelOrder() 
    {
        ArrayUnorderedList<BinaryTreeNode<T>> nodes = 
                              new ArrayUnorderedList<BinaryTreeNode<T>>();
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        BinaryTreeNode<T> current;

        nodes.addToRear(root);
        
        while (!nodes.isEmpty()) 
        {
            current = nodes.removeFirst();
            
            if (current != null)
            {
                tempList.addToRear(current.getElement());
                if (current.getLeft() != null)
                    nodes.addToRear(current.getLeft());
                if (current.getRight() != null)
                    nodes.addToRear(current.getRight());
            }
            else
                tempList.addToRear(null);
        }
        
        return new TreeIterator(tempList.iterator());
    }
    
    /**
     * Inner class to represent an iterator over the elements of this tree
     */
    private class TreeIterator implements Iterator<T>
    {
        private int expectedModCount;
        private Iterator<T> iter;
        
        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a tree traversal
         */
        public TreeIterator(Iterator<T> iter)
        {
            this.iter = iter;
            expectedModCount = modCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();
            
            return (iter.hasNext());
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws NoSuchElementException
        {
            if (hasNext())
                return (iter.next());
            else 
                throw new NoSuchElementException();
        }
        
        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}

