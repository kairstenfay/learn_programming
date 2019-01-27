// This short program calculates the average temperature for a sequence
//   of days and reports how many days were above average.
//
// Note the use of an array to store the temperatures, even though we 
//   don't know how many days there will be before the program runs. 
//   We would not have been able to write this program without arrays.
import java.util.*;

public class Weather {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      System.out.print("How many days? ");
      int numDays = console.nextInt();

      double[] temps = new int[numDays];
      double total = 0;
      for (int i = 0; i < temps.length; i++) {
         System.out.print("Day #" + (i + 1) + "'s temperature? ");
         int today = console.nextDouble();
         temps[i] = today;
         total += today;
      }
      
      double average = total / numDays;
      int numAboveAvg = 0;
      for (int i = 0; i < temps.length; i++) {
         if (temps[i] > average) {
            numAboveAvg++;
         }
      }
      
      System.out.println("Average temperature: " + average);
      System.out.println("There were " + numAboveAvg + " days above average.");
   }
}