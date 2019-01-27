// This program includes several methods demonstrating various uses
//   of for loops.
public class ForLoops {
   public static void main(String[] args) {
      for (int i = 1; i <= 1000; i++) {
         System.out.println("All work and no play...");
      }
      System.out.println();
   
      count();
      printSquares();
      countdown();
      countdown2();
      drawSquare();
      drawSquare2();
      drawPyramid();
   }
   
   // Count from 1 to 10 in the style of Count von Count from Sesame Street.
   //   Notice the use of the loop variable i inside the loop.
   public static void count() {
      for (int i = 1; i <= 10; i++) {
         System.out.println("That's " + i + "!  Ha ha ha!");
      }
      System.out.println();   
   }
   
   // Print out the squares of the integers from 1 to 10, one per line.
   public static void printSquares() {
      for (int i = 1; i <= 10; i++) {
         System.out.println(i + " squared = " + (i * i));
      } 
      System.out.println();   
   }
   
   // Print out a countdown from 10 to 1, followed by "Blast off!"
   //   Each number will appear on it's own line.
   public static void countdown() {
      for (int i = 10; i > 0; i--) {
         System.out.println("T-" + i);
      }    
      System.out.println("Blast off!");
      System.out.println();
   }
   
   // Print out a countdown from 10 to 1, followed by "Blast off!"
   //   All numbers appear on the same line.
   public static void countdown2() {
      System.out.print("T-");
      for (int i = 10; i > 0; i--) {
         System.out.print(i + ", ");
      }    
      System.out.println("Blast off!");
      System.out.println();
   }
   
   // Draw a 10 x 5 "square" of asterisks.
   public static void drawSquare() {
      for (int i = 1; i <= 5; i++) {
         System.out.println("**********");
      }
      System.out.println();
   }
   
   // Draw another 10 x 5 "square" of asterisks, this time
   //   using nested for loops.
   public static void drawSquare2() {
      for (int i = 1; i <=5; i++) {
         for (int j = 1; j <= 10; j++) {
            System.out.print("*");
         }
         System.out.println();
      }
      System.out.println();
   }
   
   // Draw a 5-row pyramid of asterisks.
   public static void drawPyramid() {
      for (int i = 1; i <= 5; i++) {
         for (int j = 1; j <= i; j++) {
            System.out.print("*");
         }
         System.out.println();
      }
      System.out.println();
   }
}