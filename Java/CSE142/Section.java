// This program computes the overall section score for a group of
//   of students based on their section attendance.  Students earn
//   3 points per section attended, up to a maximum of 20 total
//   points.
//
// Notice the use of arrays to store various values, and the 
//   transformation from one version of the data array to another.
import java.util.*;
import java.io.*;

public class Section {
   public static final int MAX_SCORE = 20;

   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("section.txt"));
      PrintStream output = new PrintStream(new File("output.txt"));
      
      while (input.hasNextLine()) {
         int[] scores = computeScores(input.nextLine());
         printResults(output, scores);
         printResults(System.out, scores);
      }
      
   }
   
   // Compute the section scores for the student represented by the
   //   given line.  Return an array containing the points earned
   //   for each section.
   //
   // String line - attendance data for an individual student
   public static int[] computeScores(String line) {
      int[] scores = new int[line.length()];
      int total = 0;
      
      for (int i = 0; i < line.length(); i++) {
         char ch = line.charAt(i);
         if (ch == '1') {
            int score = Math.min(3, MAX_SCORE - total);
            scores[i] = score;
            total += score;
         }
      }
      
      return scores;
   }
   
   // Prints out the individual section scores and total points for
   //   an individual student.
   //
   // PrintStream output - the output stream to print to
   // int[] scores - the student's scores
   public static void printResults(PrintStream output, int[] scores) {
      int total = 0;
      for (int i = 0; i < scores.length; i++) {
         output.print(scores[i] + " ");
         total += scores[i];
      }
      output.println(" = " + total);
   }
}