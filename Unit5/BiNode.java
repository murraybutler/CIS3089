/**
 * Represents a node in a linked list.
 * 
 * @author Murray Butler
 * @version 1.0
 */
public class BiNode<T> 
{
    protected BiNode<T> next,prev;
    protected T element;
 
    /**
     * Creates an empty node.
     */
    public BiNode()
    {
        prev = next = null;
        element = null;
	}
 
    /**
     * Creates a node storing the specified element.
     * @param elem element to be stored
     */
    public BiNode(T elem)
    {
        prev = next = null;
        element = elem;
    }
 
    /**
     * Returns the node that follows this one.
     * @return reference to next node
     */
    public BiNode<T> getNext()
    {
        return next;
    }
 
    /**
     * Sets the node that follows this one.
     * @param node node to follow this one
     */
    public void setNext(BiNode<T> node)
    {
        next = node;
    }
 
    /**
     * Returns the element stored in this node.
     * @return element stored at the node
     */
    public T getElement()
    {
        return element;
    }
 
    /**
     * Sets the element stored in this node.
     * @param elem element to be stored at this node
     */
    public void setElement(T elem)
    {
        element = elem;
    }

    /**
     * Returns pointer to previous node
     * @return  reference to previous node
     */
    public BiNode<T> getPrev()
    {
      return prev;
    }

    /**
     * Sets pointer to previous node in list
     * @param node  reference to previous node
     */
    public void setPrev(BiNode<T> node)
    {
      prev = node;
    }
}
