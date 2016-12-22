
import java.util.Date;

public class Tweet<T> extends BiNode<T>
{
  private Date date;
  private String handle;

  /**
   * Creates a Tweet instance
   */
  public Tweet()
  {
    prev = next = null;
    this.element = null;
    this.date = null;
    this.handle = null;
  }

  /**
   * Creates a populated Tweet
   * @param date Date object of tweet
   * @param handle  name of tweeter
   * @param tweet content of tweet
   */
  public Tweet(Date indate, String hdl, T tweet)
  {
    prev = next = null;
    this.element = tweet;
    this.date = indate;
    this.handle = hdl;
  }

  /**
   * Sets date of tweet
   * @param indate  Date object of tweet
   */
  public void setDate(Date indate)
  {
    this.date = indate;
  }

  /**
   * Sets handle of tweet
   * @param hdl String handle of tweeter
   */
  public void setHandle(String hdl)
  {
    this.handle = hdl;
  }

  /**
   * Sets Tweet content for object
   * @param tweet Sets element of node
   */
  public void setTweet(T tweet)
  {
    this.element = tweet;
  }

  /**
   * Gets date of tweet
   * @return  Date  Date object of tweet
   */
  public Date getDate()
  {
    return this.date;
  }

  /**
   * Gets tweet
   * @return T Tweet contents
   */
  public T getTweet()
  {
    return this.element;
  }

  /**
   * Gets handle of tweeter
   * @return String Handle of tweeter
   */
  public String getHandle()
  {
    return this.handle;
  }
}
