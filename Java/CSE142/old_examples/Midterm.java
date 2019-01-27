// Program to calculate statistics about the midterm.
// Note the arrays used as parameters and return values.
import java.util.*;
import java.io.*;

public class Midterm {
   public static final int MAX_SCORE = 101;

   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("midterm.txt"));
      
      int[] scores = getScores(input);
      System.out.println("Average: " + getAverage(scores));
      System.out.println("High score: " + getMax(scores));

      int[] counts = getCounts(scores);
      System.out.println();
      drawHistogram(counts);
   }
   
   public static int[] getScores(Scanner input) {
      int[] scores = new int[input.nextInt()];
      for (int i = 0; i < scores.length; i++) {
         scores[i] = input.nextInt();
      }
      return scores;   
   }
   
   public static double getAverage(int[] scores) {
      int sum = 0;
      for (int i = 0; i < scores.length; i++) {
         sum += scores[i];
      }
      
      return (double) sum / scores.length;
   }
   
   public static int getMax(int[] values) {
      if (values.length < 1) {
         return 0;
      }
      
      int max = values[0];
      for (int i = 1; i < values.length; i++) {
         // max = Math.max(max, values[i]);
         if (values[i] > max) {
            max = values[i];
         }
      }
      return max;
   }
   
   public static int[] getCounts(int[] scores) {
      int[] counts = new int[MAX_SCORE + 1];
      for (int i = 0; i < scores.length; i++) {
         int score = scores[i];
         counts[score]++;
      }
      return counts;
   }
   
   public static void drawHistogram(int[] counts) {
      for (int i = 0; i < counts.length; i++) {
         System.out.printf("%3d | ", i);
         for (int j = 0; j < counts[i]; j++) {
               System.out.print("*");
         }
         System.out.println(" (" + counts[i] + ")");
      }
   }
}