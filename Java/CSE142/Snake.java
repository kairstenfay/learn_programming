import java.awt.*;
import java.util.*;

// Snakes act as follows:
//   - always appear black
//   - always appear as "S"
//   - never eat
//   - always pounce in fights
//   - take an initial segment length in their constructor
//   - pick and random direction and move in that direction a number
//     of times equal to the current segment length, then increment
//     the segment length and pick a new random direction
public class Snake extends Critter {
   private Random rand;
   private int segmentLength;
   private int numMoves;
   private int direction;
   
   // constructs a snake
   //
   // int segmentLength - the length of the snake's first segment
   public Snake(int segmentLength) {
      rand = new Random();
      this.segmentLength = segmentLength;
      numMoves = -1;
   }
   
   // returns the attack a snake should use when fighting (always pounce)
   public Attack fight(String opponent) {
      return Attack.POUNCE;
   }

   // returns the string representation of a snake (always "S")
   public String toString() {
      return "S";
   }
   
   // returns the direction the snake should move
   //   snakes move the current segment length in a randomly-chosen direction
   //   then increase the segment length by one and choose a new direction
   public Direction getMove() {
      if (numMoves == segmentLength) {
         direction = rand.nextInt(4);
         segmentLength++;
         numMoves = -1;
      }
      
      numMoves++;
      if (direction == 0) {
         return Direction.NORTH;
      } else if (direction == 1) {
         return Direction.SOUTH;
      } else if (direction == 2) {
         return Direction.EAST;
      } else {    // (direction == 3)
         return Direction.WEST;
      }
   }
}