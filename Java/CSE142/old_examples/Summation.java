// Program to sum up the integers between 1 and some maximum
//   value (inclusive).  Notice the usage of Scanner to take
//   use input and the cumulative algorithm to calculate the
//   sum.
import java.util.*;

public class Summation {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in); 
   
      System.out.print("Enter an integer (greater than 0): ");
      int number = console.nextInt();
      if (number < 1) {
         System.out.println("That's not greater than 0; you didn't listen!");
      } else {
         int sum = sumTo(number);
         System.out.println("Total = " + sum);
      }
   }
   
   // Calculates and returns the sum of the integers between
   //   1 and max (inclusive).
   //
   // int max - maximum value to include in the sum
   public static int sumTo(int max) {
      int total = 0;
      for (int i = 1; i <= max; i++) {
         total += i;
      }
      return total;
   }
}