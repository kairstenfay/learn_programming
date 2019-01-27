// Program to read numbers from a file and find the maximum value.
//
// This version assumes that the file numbers.txt exists and has 
//   at least 5 numbers and no non-numeric tokens.
import java.util.*;
import java.io.*;

public class FindMax {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("numbers.txt"));
      
      double max = input.nextDouble();
      System.out.println("Next value: " + max);      
      
      for (int i = 1; i < 5; i++) {
         double number = input.nextDouble();
         System.out.println("Next value: " + number);
         if (number > max) {
            max = number;
         }
      }
      System.out.println("Maximum value: " + max);
   }
}