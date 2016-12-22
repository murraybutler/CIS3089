import java.util.*;

/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Murray Butler
 * @version 4.1
 */
public class MazeSolver
{
    private Maze maze;
    
    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse()
    {
        boolean done = false;
        int row, column;
        Deque<Position> track = new LinkedList<Position>();
        Position pos = new Position(maze.startRow, maze.startCol);
        Deque<Position> stack = new LinkedList<Position>();
       
        if (pos.getx() == maze.getRows()-1 && pos.gety() == maze.getColumns()-1) {
          done = true;  // the maze is solved
        }
        if (maze.validPosition(pos.getx(),pos.gety())) {
          done = checkPath(pos);
        }

        // We always use our origin as part of the path (but last, so the recursion understands)
        maze.markPath(maze.startRow, maze.startCol);
      
        return done;
    }
   
    /**
     * Method to check the path recursively and solve for the correct path through the maze.
     *
     * @param cpos  Position in maze to run from
     * @return booean Whether or not the chosen position is part of the solution path
     */
      private boolean checkPath(Position cpos)
      {
       int x = cpos.getx();
       int y = cpos.gety();
     
       maze.tryPosition(x,y);

       System.out.println(maze);

       if (cpos.getx() == maze.getRows()-1 && cpos.gety() == maze.getColumns()-1) {
         maze.markPath(cpos.getx(),cpos.gety());
         return true;  // the maze is solved
       }
      
       if (maze.validPosition(cpos.up().getx(),cpos.up().gety()) && checkPath(cpos.up())) {
         maze.markPath(cpos.up().getx(),cpos.up().gety());
         return true;
       }

       if (maze.validPosition(cpos.down().getx(),cpos.down().gety()) && checkPath(cpos.down())) {
         maze.markPath(cpos.down().getx(),cpos.down().gety());
         return true;
       }

       if (maze.validPosition(cpos.left().getx(),cpos.left().gety()) && checkPath(cpos.left())) {
         maze.markPath(cpos.left().getx(),cpos.left().gety());
         return true;
       }
   
       if (maze.validPosition(cpos.right().getx(),cpos.right().gety()) && checkPath(cpos.right())) {
         maze.markPath(cpos.right().getx(),cpos.right().gety());
         return true;
       }
 
       System.out.println("tried: " + x + ":" + y);
       maze.tryPosition(x,y);
       return false;

     }
}
