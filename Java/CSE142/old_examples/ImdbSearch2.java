// This program searches through the 250 top-rated movies on 
//   IMDB for a particular phrase. This updated version replaces
//   the search word with a given word only when the target word
//   appears as an entire token. It also prints the output to a
//   file instead of to the console.
import java.util.*;
import java.io.*;

public class ImdbSearch2 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("imdb.txt"));
      Scanner console = new Scanner(System.in);
      
      System.out.print("Search phrase? ");
      String phrase = console.nextLine();
      System.out.print("Replace with? ");
      String replacement = console.nextLine();
      System.out.print("Output file? ");
      String outFile = console.nextLine();
      PrintStream output = new PrintStream(new File(outFile));
      System.out.println();

      int count = 0;      
      while (input.hasNextLine()) {
         String result = find(phrase, input);
         if (result.length() > 0) {
            String newLine = replace(result, phrase, replacement);
            print(newLine, output);
            count++;
         }
      }
      System.out.println(count + " matching films found");
   }
   
   // Print a short introduction to the program.
   public static void intro() {
      System.out.println("This program searches a text database of highly-rated movies");
      System.out.println("for movies whose title includes a given phrase");
      System.out.println();
   }
   
   // Search through the file connected to the given Scanner
   //   for lines that contain the given phrase. Returns the
   //   first such line found, or the empty string if no
   //   such line exists.
   //
   // String phrase - the phrase to search for
   // Scanner input - the input file to search through
   public static String find(String phrase, Scanner input) {
      int matches = 0;
      
      while (input.hasNextLine()) {
         String line = input.nextLine();
         if (line.toLowerCase().contains(phrase.toLowerCase())) {
            return line;
         }
      }
      
      return "";
   }
   
   // Replace all tokens in line that match target with replacement.
   //
   // String line - the String in which to search and replace
   // String target - the token to search for
   // String replacement - the token to replace target with when found
   public static String replace(String line, String target, String replacement) {
      String result = "";
      Scanner tokens = new Scanner(line);
      
      while (tokens.hasNext()) {
         String token = tokens.next();
         if (token.equalsIgnoreCase(target)) {
            result += replacement + " ";
         } else {
            result += token + " ";
         }
      }
      
      return result;
   }
   
   // Print out information about the given film in the
   //   following format:
   // Title -- Rank #N, Rated X.X (X ratings)
   //
   // String info - the rank, # of ratings, average rating, and 
   //   title of the movie to print out
   public static void print(String info, PrintStream output) {
      Scanner tokens = new Scanner(info);
      int rank = tokens.nextInt();
      int ratings = tokens.nextInt();
      double average = tokens.nextDouble();
      String title = "";
      while (tokens.hasNext()) {
         title += tokens.next() + " ";
      }
      
      output.println(title + "-- Rank #" + rank + ", Rated " + average + " (" + ratings + " ratings)");
   }
}