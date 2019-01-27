// A program to demonstrate the usage of return values by calculating 
//   various baseball statistics.
public class BaseballStats {
   public static void main(String[] args) {
      double felixEra = earnedRunAverage(15, 11);
      double paxtonEra = earnedRunAverage(15.66666667, 10);
      double canoAvg = battingAverage(13, 32);
      double seguraSlug = sluggingPercentage(42, 9, 4, 1, 0);
      
      System.out.println("Felix Hernandez's ERA: " + felixEra);
      System.out.println("James Paxton's ERA: " + paxtonEra);
      System.out.println("James Paxton's ERA: " + round3(paxtonEra));      
      System.out.println("James Paxton's ERA: " + roundN(paxtonEra, 2));
      System.out.println("Robinson Cano's Batting Average: " + canoAvg);
      System.out.println("Robinson Cano's Batting Average: " + roundN(canoAvg, 3));
      System.out.println("Jean Segura's Slugging Percentage: " + seguraSlug);
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