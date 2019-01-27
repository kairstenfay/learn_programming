// This program searches through the 250 top-rated movies on 
//   IMDB for a particular phrase.
// Note the file input, the use of line-based input in the
//   find method, the use of token-based input in the print
//   method, and the use of two separate Scanners for reading
//   lines and tokens.
import java.util.*;
import java.io.*;

public class ImdbSearch {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("imdb.txt"));
      Scanner console = new Scanner(System.in);
      
      System.out.print("Search phrase? ");
      String phrase = console.nextLine().toLowerCase();
      System.out.println();
      
      int count = find(phrase, input);
      System.out.println(count + " matching films found");
   }
   
   // Print a short introduction to the program.
   public static void intro() {
      System.out.println("This program searches a text database of highly-rated movies");
      System.out.println("for movies whose title includes a given phrase");
      System.out.println();
   }
   
   // Search through the file connected to the given Scanner
   //   for lines that contain the given phrase. Prints out
   //   all such lines and returns the number of lines found.
   //
   // String phrase - the phrase to search for
   // Scanner input - the input file to search through
   public static int find(String phrase, Scanner input) {
      int matches = 0;
      
      while (input.hasNextLine()) {
         String line = input.nextLine();
         if (line.toLowerCase().contains(phrase)) {
            matches++;
            print(line);
         }
      }
      
      return matches;
   }
   
   // Print out information about the given film in the
   //   following format:
   // Title -- Rank #N, Rated X.X (X ratings)
   //
   // String info - the rank, # of ratings, average rating, and 
   //   title of the movie to print out
   public static void print(String info) {
      Scanner tokens = new Scanner(info);
      int rank = tokens.nextInt();
      int ratings = tokens.nextInt();
      double average = tokens.nextDouble();
      String title = "";
      while (tokens.hasNext()) {
         title += tokens.next() + " ";
      }
      
      System.out.println(title + "-- Rank #" + rank + ", Rated " + average + " (" + ratings + " ratings)");
   }
}