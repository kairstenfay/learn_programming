// Brett Wortzman
// Section: AZ
// TA: Grace Hopper
// Date: 3/28/18
// Assignment 0
//
// This is a program to draw two diamonds and an X.
//
// This version eliminates all redundancy by having methods 
//   that call other methods to create a clear structure.
public class Figure3 {
   public static void main(String[] args) {
      drawDiamond();
      System.out.println();
      
      drawDiamond();
      System.out.println();
      
      drawX();
   }
   
   public static void drawDiamond() {
      drawCarat();
      drawV();
   }
   
   public static void drawX() {
      drawV();
      drawCarat();
   }
   
   public static void drawCarat() {
      System.out.println("  /\\");
      System.out.println(" /  \\");
      System.out.println("/    \\");   
   }
   
   public static void drawV() {
      System.out.println("\\    /");
      System.out.println(" \\  /");
      System.out.println("  \\/");   
   }
}