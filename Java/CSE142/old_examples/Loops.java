// This program demonstrates several new types of loops:
//   fencepost loops, while loops, and sentinel loops.
//
// countUpTo and spellWord demonstrate fencepost loops
// powersOfTwo demonstrates while loops
// addNumbers demonstrates while loops, sentinel loops,
//   fencepost loops, and a cumulative sum
import java.util.*;

public class Loops {
   public static void main(String[] args) {
      countUpTo(10);
      countUpTo(15);
      System.out.println();
      
      spellWord("abracadabra");
      spellWord("CSE142");
      System.out.println();
      
      powersOfTwo(200);
      powersOfTwo(1000);
      System.out.println();
      
      Scanner console = new Scanner(System.in);
      addNumbers(console);
   }
   
   // Prints out the integers from 1 to max separated by commas.
   //
   // int max - the largest number to print
   public static void countUpTo(int max) {
      System.out.print(1);
      for (int i = 2; i <= max; i++) {
         System.out.print(", " + i);
      }
      System.out.println();
   }
   
   // Prints out the characters in word separated by dashes.
   //
   // String word - the string whose chracters should be printed
   public static void spellWord(String word) {
      for (int i = 0; i < word.length(); i++) {
         char letter = word.charAt(i);
         System.out.print(letter + "-");
      }
      System.out.println(word.charAt(word.length() - 1));
   }
   
   // Prints out the smallest power of two larger than last
   //
   // int last - a lower bound of the power of two to be printed
   public static void powersOfTwo(int last) {
      int power = 1;
      while (power <= last) {
         power *= 2;
      }
      System.out.println(power);
   }
   
   // Reads integers from the given Scanner until -1 is entered,
   //   then prints the sum and count of the numbers entered (not
   //   including the -1).
   //
   // Scanner input - Scanner to use for obtaining input
   public static void addNumbers(Scanner input) {
      int sum = 0;
      int count = 0;
      
      System.out.print("Next number (-1 to stop)? ");
      int next = input.nextInt();
      while (next != -1) {
         sum += next;
         count++;
         System.out.print("Next number (-1 to stop)? ");
         next = input.nextInt();
      }
      
      System.out.println("Total of numbers entered = " + sum);
      System.out.println("Count of numbers entered = " + count);
   }
}