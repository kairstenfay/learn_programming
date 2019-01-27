// This program simulates a simplified version of European Roulette
//   in which the player always bets the same amount and always bets
//   on "low."  
//
// Notice the use of Random objects, the tallying of the number of
//   spins, and the tracking of the maximum bank.
import java.util.*;

public class Roulette {
   public static final int BET = 15;

   public static void main(String[] args) {
      Random r = new Random();
      int bank = 100;
      int max = bank;
      int numSpins = 0;
      
      while (bank > 0) {
         int bet = Math.min(bank, BET);
         int spin = r.nextInt(37);

         // bet on "low"
         if (spin != 0 && spin <= 18) {
            // win!!
            bank += 5;
         } else {    // spin > 18
            // lose
            bank -= 5;
         }
         
         if (bank > max) {
            max = bank;
         }
         numSpins++;
         
         System.out.println("Betting $" + bet + ", Spin was " + spin + ", new bank = $" + bank);
      }
      
      System.out.println("Spun " + numSpins + " times, Max bank = $" + max);
   }
}