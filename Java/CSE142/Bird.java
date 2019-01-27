// Kairsten Fay
// 5/27/2018
// CSE142
// TA: Rachel Imhof
// Assignment #8
//
// Birds are displayed as either "^", ">", "V", or "<" and move clockwise three steps in each 
//   cardinal direction.
// They pick roar in a fight with ants and pounce in all other fights.
// They do not eat. 
//
import java.awt.*;

public class Bird extends Critter {

   private int movesCounter;
   private Direction[] movesMap;
   private String[] symbolsMap;
   
   public Bird() { 
      movesCounter = -1;   
      movesMap = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
      symbolsMap = new String[]{"^", ">", "V", "<"};
   }
   
   // Returns a direction North, East, South, or West which changes every three moves. 
   public Direction getMove() { 
      if (movesCounter == 11) { 
         movesCounter = -1;
      }  
      movesCounter++;
      return movesMap[movesCounter / 3];
   }
   
	// Returns roar in fights with ants and pounce in all other fights.
   //
   // String opponent - the string representation of the opponent on the game map.
	public Attack fight(String opponent) {
      if (opponent.equals("%")) { 
         return Attack.ROAR;
      } else { 
         return Attack.POUNCE;
      }
	}

	// Returns the color blue. 
	public Color getColor() {
		return Color.BLUE;
	}

	// Returns a string representation of "^", ">", "V", or "<" which changes every three moves.
	public String toString() {
      return symbolsMap[movesCounter / 3];
	}
}
