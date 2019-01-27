// Program to read numbers from a file and find the maximum value.
//
// This version can handle any number of tokens of any types, and 
//   will ignore non-numeric input without throwing an exception.
import java.util.*;
import java.io.*;

public class FindMax3 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("numbers3.txt"));
      
      if (input.hasNextDouble()) {
         double max = input.nextDouble();
         System.out.println("Next value: " + max);      
      
         while(input.hasNext()) {
            if (input.hasNextDouble()) {
               double number = input.nextDouble();
               System.out.println("Next value: " + number);
               if (number > max) {
                  max = number;
               }
            } else {
               String token = input.next();
               System.out.println("Next token not a number: " + token);
            }
         }
         System.out.println("Maximum value: " + max);
      }
   }
}