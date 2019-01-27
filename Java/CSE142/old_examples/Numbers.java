// This program demonstrates the usage of if-else statements and return
//   values by computing various facts about an integer entered by the user.
import java.util.*;

public class Numbers {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      System.out.print("Number? ");
      int number = console.nextInt();
      
      // check whether the number is even or odd
      if (number % 2 == 0) {
         System.out.println(number + " is even");
      } else {
         System.out.println(number + " is odd");
      }

      // check whether the number is positive or negative
      if (number < 0) {
         System.out.println(number + " is negative");
      } else if (number > 0) {
         System.out.println(number + " is positive");
      }

      // check which prime numbers are factors of the number
      if (number % 2 == 0) {
         System.out.println(number + " is a multiple of 2");
      }
      if (number % 3 == 0) {
         System.out.println(number + " is a multiple of 3");
      }
      if (number % 5 == 0) {
         System.out.println(number + " is a multiple of 5");
      }

      // compute the next hailstone number  
      int next = hailstone(number);
      System.out.println("The next hailstone number is " + next);    
   }
   
   // Computes the number that follows num in the hailstone sequence.
   // The hailstone sequence is defined as follows:
   //   - if the input is even, the next value is half the input (n / 2)
   //   - if the input is odd, the next value is three times the input plus 1 (3n + 1)
   public static int hailstone(int num) {
      int result;
      
      System.out.println("Input is " + num);
      if (num % 2 == 0) {
         System.out.println(num + " is even; in (n / 2) case");
         result = num / 2;
      } else {    // (num % 2 == 1)
         System.out.println(num + " is odd; in (3n + 1) case");        
         result = 3 * num + 1;
      }
      System.out.println("New value is " + result);
      System.out.println();
      
      return result;
   }
}