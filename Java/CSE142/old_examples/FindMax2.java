// Program to read numbers from a file and find the maximum value.
//
// This version does not make any assumptions about how many values
//   are in the file, but will throw an exception on non-numeric tokens.
import java.util.*;
import java.io.*;

public class FindMax2 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("numbers2.txt"));
      
      if (input.hasNextDouble()) {
         double max = input.nextDouble();
         System.out.println("Next value: " + max);      
      
         while(input.hasNextDouble()) {
            double number = input.nextDouble();
            System.out.println("Next value: " + number);
            if (number > max) {
               max = number;
            }
         }
         System.out.println("Maximum value: " + max);
      }
   }
}