// Kairsten Fay
// 5/27/2018
// CSE142
// TA: Rachel Imhof
// Assignment #8
//
// Hippos are displayed as a number depicting their hunger level and move five times in a random
//   direction before changing path. 
// They pick scratch in a fight while they're still hungry; otherwise they pounce.
// They eat a set number of times.
//
import java.awt.*;
import java.util.*;

public class Hippo extends Critter {

   private Random rand;
   private int hunger;
   private int movesCounter;
   private Direction[] movesMap;
   private int currentIndex;
   
   public Hippo(int hunger) { 
      this.hunger = hunger;
      movesCounter = 0;
      movesMap = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
      rand = new Random();
      currentIndex = -1;
   }
   
   // Returns true while the hippo is hungry, otherwise returns false. 
   public boolean eat() { 
      if (hunger > 0) { 
         hunger--;
         return true;
      } else { 
         return false;
      }
   }
   
   // Returns a random direction which changes after five moves. 
   public Direction getMove() { 
      if (movesCounter == 5) { 
         movesCounter = 0;
      }
      
      if (movesCounter == 0) { 
         currentIndex = rand.nextInt(4);
      }
      
      movesCounter++;
      return movesMap[currentIndex];
   }
   
	// Returns scratch while hungry, otherwise returns pounce. 
   //
   // String opponent - the string representation of the opponent on the game board. 
	public Attack fight(String opponent) {
      if (hunger > 0) { 
         return Attack.SCRATCH;
      } else { 
         return Attack.POUNCE;
      }
	}

	// Returns gray while hungry, otherwise returns white. 
	public Color getColor() {
      if (hunger > 0) { 
		   return Color.GRAY;
      } else { 
         return Color.WHITE;
      }
	}

	// Returns the string representation of the hippo on the game board which changes as the hippo
   //   gets less hungry.
	public String toString() {
      return "" + hunger;
	}
}