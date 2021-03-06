// A program to demonstrate the usage of return values by calculating 
//   various baseball statistics.
//
// This version uses a simple if-else statement to ask the user whether
//   they would like to calculate statistics for a pitcher or a batter.
import java.util.*;

public class BaseballStats3 {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      System.out.print("Enter 1 for pitcher or 2 for batter: ");
      int option = console.nextInt();
      if (option == 1) {
            pitcher(console);
      } else {
         batter(console);
      }
   }

   // Calculate and print out statistics for a pitcher based on
   //   user input.
   //
   // Scanner console - Scanner from which to take input   
   public static void pitcher(Scanner console) {
      System.out.print("Number of innings pitched? ");
      double innings = console.nextDouble();
      System.out.print("Number of earned runs allowed? ");
      int earnedRuns = console.nextInt();
      
      double era = earnedRunAverage(innings, earnedRuns);
      System.out.println("ERA: " + roundN(era, 2));
      System.out.println();   
   }
   
   // Calculate and print out statistics for a batter based on
   //   user input.
   //
   // Scanner console - Scanner from which to take input   
   public static void batter(Scanner console) {
      System.out.print("Number of at bats? ");
      int atBats = console.nextInt();
      System.out.print("Number of singles? ");
      int singles = console.nextInt();
      System.out.print("Number of doubles? ");
      int doubles = console.nextInt();
      System.out.print("Number of triples? ");
      int triples = console.nextInt();
      System.out.print("Number of home runs? ");
      int homers = console.nextInt();
      
      double average = battingAverage((singles + doubles + triples + homers), atBats);
      double slugging = sluggingPercentage(atBats, singles, doubles, triples, homers);
      
      System.out.println("batting average: " + roundN(average, 3));
      System.out.println("slugging percentage: " + roundN(slugging, 3));   
   }
   
   // Calculates and returns a pitcher's earned run average (ERA).
   // ERA is defined as (earned runs allowed) / (innings pitched) * 9
   //
   // double innings - number of innings pitched
   // int earnedRuns - number of earned runs allowed
   public static double earnedRunAverage(double innings, int earnedRuns) {
      double runsPerInning = earnedRuns / innings;
      double era = runsPerInning * 9;
      return era;
   }

   // Calculates and returns a batter's batting average.
   // Batting average is defined as (hits) / (at bats)
   //
   // int hits - number of hits achieved
   // int at bats - number of official at bats accrued
   public static double battingAverage(int hits, int atBats) {
      return (double)hits / atBats;
   }
   
   // Calculates and returns a batter's slugging percentage from the number of
   //   singles, double, triples, and home runs the batter has hit.
   // Slugging percentage is defined as (total bases from hits) / (at bats)
   //
   // int atBats - number of official at bats accrued
   // int singles - number of singles hit
   // int doubles - number of doubles hit
   // int triples - number of triples hit
   // int homeRuns - number of home runs hit
   public static double sluggingPercentage(int atBats, int singles, int doubles, int triples, int homeRuns) {
      int bases = 0;
      bases += singles;
      bases += doubles * 2;
      bases += triples * 3;
      bases += homeRuns * 4;
      
      return (double)bases / atBats;
   }
   
   // Rounds a real number to 3 decimal places and returns the result.
   //
   // double num - the number to round
   public static double round3(double num) {
      return (int)(num * 1000 + 0.5) / 1000.0;
   }
   
   // Rounds a real number to a specified number of decimal places and 
   //   returns the result.
   //
   // double num - the number to round   
   // int places - the number of decimal places to round to
   public static double roundN(double num, int places) {
      return (int)(num * Math.pow(10, places) + 0.5) / (Math.pow(10, places));
   }
}