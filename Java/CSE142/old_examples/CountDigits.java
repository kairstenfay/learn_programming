// Simple program to count the number of times each digit 0-9
//   appears in a number provided the user.
// Note the use of an array to track the counts.
import java.util.*;

public class CountDigits {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
   
      System.out.print("Number? ");
      int number = console.nextInt();
      
      int[] counts = new int[10];
      while (number > 0) {
         int digit = number % 10;
         counts[digit]++;
         number /= 10;
      }
      
      System.out.println("Digit counts: " + Arrays.toString(counts));
   }
}