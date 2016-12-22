/**
 * Represents a single position in a maze of characters.
 *
 * @author Murray Butler
 * @version 4.1
 */
public class Position
{
    private int x; 
    private int y;

    /**
     * Constructs a position and sets the x & y coordinates to 0,0.
     */
    Position ()
    {
        x = 0;
        y = 0;
    }

    /**
     * Constructs a Position with user input parameters
     * @param intx  Integer value for starting x
     * @param inty  Integer value for starting y
     */
    Position (int intx, int inty)
    {
      x = intx;
      y = inty;
    }

    /**
     * Returns the x-coordinate value of this position.
     * @return the x-coordinate of this position
     */
    public int getx()
    {
        return x;
    }

    /**
     * Returns the y-coordinate value of this position.
     * @return the y-coordinate of this position
     */
    public int gety()
    {
        return y;
    }

    /**
     * Sets the value of the current position's x-coordinate.
     * @param a value of x-coordinate
     */
    public void setx(int a)
    {
        x = a;
    }

    /**
     * Sets the value of the current position's x-coordinate.
     * @param a value of y-coordinate
     */ 
    public void sety(int a)
    {
        y = a;
    }

    /**
     * Method to return upper position from current
     * @return  Position  Position above current
     */
    public Position up()
    {
      Position n = new Position();
      n.setx(this.getx()+1);
      n.sety(this.gety());
      return n;
    }

    /**
     * Method to return lower position from current
     * @return  Position  Position below current
     */
    public Position down()
    {
      Position n = new Position();
      n.setx(this.getx()-1);
      n.sety(this.gety());
      return n;
    }

    /**
     * Method to return next rightmost position from current
     * @return  Position  Position right of current
     */
    public Position right()
    {
      Position n = new Position();
      n.setx(this.getx());
      n.sety(this.gety()+1);
      return n;
    }

    /**
     * Method to return next leftmost position from current
     * @return  Position  Position left of current
     */
    public Position left()
    {
      Position n = new Position();
      n.setx(this.getx());
      n.sety(this.gety()-1);
      return n;
    }

}
