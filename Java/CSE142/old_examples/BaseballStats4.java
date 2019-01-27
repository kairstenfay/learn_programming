// This program computes the batting averages of two hitters using
//   values input by the user.
//
// Note the use of if-else statements, parameters, and return values,
//   as well as the structure of the program.
import java.util.*;

public class BaseballStats4 {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      intro();
      double avg1 = batter(console);
      double avg2 = batter(console);
      reportResults(avg1, avg2);
   }
   
   // Prints out an introductory message describing the program.
   public static void intro() {
      System.out.println("This program calculates the batting averages");
      System.out.println("of two different hitters.");
      System.out.println();
   }
   
   // Calculate and print out statistics for a batter based on
   //   user input.
   //
   // Scanner console - Scanner from which to take input   
   public static double batter(Scanner console) {
      System.out.print("Number of at bats? ");
      int atBats = console.nextInt();
      System.out.print("How many hits? ");
      int hits = console.nextInt();
      System.out.println();
      
      double average = battingAverage(hits, atBats);
      return average;
   }
   
   // Prints out both batting averages as well as comment on about each
   //   player's average.
   //
   // double average1 - the batting average of the first batter
   // double average2 - the batting average of the second batter
   public static void reportResults(double average1, double average2) {
      System.out.println("First batter's average = " + roundN(average1, 3));
      describeAverage(average1);
      System.out.println("Second batter's average = " + roundN(average2, 3));
      describeAverage(average2);
   }
   
   // Prints out a comment relating to the given batting average.
   //
   // double average - the batting average to comment on
   public static void describeAverage(double average) {
      if (average < 0.200) {
         System.out.println("Back to the minors!");
      } else if (average < 0.250) {
         System.out.println("Your average is....average.");
      } else if (average < 0.300) {
         System.out.println("You're a hitting machine.");
      } else {    // average >= 0.300
         System.out.println("Call the Hall of Fame!");
      }
   }

   // Calculates and returns a batter's batting average.
   // Batting average is defined as (hits) / (at bats)
   //
   // int hits - number of hits achieved
   // int at bats - number of official at bats accrued
   public static double battingAverage(int hits, int atBats) {
      return (double)hits / atBats;
   }

   // Rounds a real number to a specified number of decimal places and 
   //   returns the result.
   //
   // double num - the number to round   
   // int places - the number of decimal places to round to
   public static double roundN(double num, int places) {
      return Math.round(num * Math.pow(10, places)) / (Math.pow(10, places));
   }
}