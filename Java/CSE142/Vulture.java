// Kairsten Fay
// 5/27/2018
// CSE142
// TA: Rachel Imhof
// Assignment #8
//
// Vultures are displayed as either "^", ">", "V", or "<" and move clockwise three steps in each 
//   cardinal direction.
// They pick roar in a fight with ants and pounce in all other fights.
// They eat when they're born and after a fight.
//
import java.awt.*;

public class Vulture extends Bird {

   private boolean hunger;
   
   public Vulture() { 
      hunger = true;
   }
   
   // Returns true when a vulture is hungry, otherwise returns false. 
   public boolean eat() { 
      if (hunger) {
         hunger = false;
         return true;
      } else { 
         return false;
      }
   }
   
   // Returns roar in fights with ants. OTherwise returns pounce. Sets the hunger level to true.
   //
   // String opponent - the string representation of the opponent on the game board. 
   public Attack fight(String opponent) {
      hunger = true;
      if (opponent.equals("%")) { 
         return Attack.ROAR;
      } else { 
         return Attack.POUNCE;
      }
	}

	// Returns black.
	public Color getColor() {
		return Color.BLACK;
	}


}
