package jsjf.exceptions;

/**
 * Exception class def for query of empty structure.
 * @author  Murray Butler
 * @version 1.0
 */
public class EmptyCollectionException extends RuntimeException
{

  /**
   * Exception for emtpy collection returns appropriate collection message.
   * @param collection  Name of the collection throwing exception
   */
  public EmptyCollectionException(String collection)
  {
    super("The " + collection + " is empty.");
  }
}

