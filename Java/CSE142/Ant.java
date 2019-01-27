// Kairsten Fay
// 5/27/2018
// CSE142
// TA: Rachel Imhof
// Assignment #8
//
// Ants are displayed as % and alternate movement between South or North and East
// They always pick scratch in a fight. 
// They always eat.
//
import java.awt.*;

public class Ant extends Critter {

   private boolean walkSouth;
   private int movesCounter;
   
   public Ant(boolean walkSouth) { 
      this.walkSouth = walkSouth;
      movesCounter = 0;
   }
   
   // Returns true to every food encounter.
   public boolean eat() { 
      return true;
   }
   
   // REturns alternate movement between North or South and East every two steps.
   public Direction getMove() {   
      movesCounter++;
      if (movesCounter % 2 == 1) { 
         if (walkSouth) { 
            return Direction.SOUTH;
         } else { 
            return Direction.NORTH;
         }
      } else { 
         return Direction.EAST;
      }
   }
   
	// Returns scratch for every attack.
   //
   // String opponent - the string representation of the opponent.
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}

	// Returns the color red.
	public Color getColor() {
		return Color.RED;
	}

	// Returns the string representation of "%" on the game board.
	public String toString() {
		return "%";
	}
}
