import java.util.*;

public class Practice {
   public static void main(String[] args) {
      boolean result = containsSeven(468);
      // if (result == true) {         **BAD Boolean Zen**
      if (result) {
         System.out.println("Found one!");
      } else {
         System.out.println("No 7's found.");
      }

//       System.out.println(rollSeven());
//       System.out.println();
//       System.out.println(rollSeven());
//       System.out.println();
//       System.out.println(rollSeven());
//       System.out.println();
//       System.out.println(rollSeven());
//       System.out.println();       

//       System.out.println(insertDashes("CSE142"));
//       System.out.println(insertDashes("Hello"));      
//       System.out.println(insertDashes("abcdefgh"));
//       System.out.println(insertDashes("A"));
   }
   
   // Write a static method called containsSeven that takes
   // an integer as a parameter and returns true if the digit
   // 7 appears in the number and false otherwise.
   // You may assume value passed as the parameter is not
   // negative. You may not use Strings to solve this problem.
   public static boolean containsSeven(int num) {
      while (num != 0) {
         if (num % 10 == 7) {
            return true;
         }
         num = num / 10;
      }
      
      return false;
   }
   
   // Write a static method called roll7 that simulates the
   // rolling of two dice until their sum is equal to 7.  The
   // method should print each roll and its sum and show a count
   // of how many rolls it took to get to 7, as in:
   //     3 + 5 = 8
   //     2 + 1 = 3
   //     1 + 4 = 5
   //     3 + 4 = 7
   //     sum of 7 after 4 rolls
   // You must exactly reproduce the format of this sample
   // execution.
   public static void rollSeven() {
      Random rand = new Random();
      int rolls = 0;
      int sum = 0;

      while (sum != 7) {
         int roll1 = rand.nextInt(6) + 1;
         int roll2 = rand.nextInt(6) + 1;
         sum = roll1 + roll2;
         rolls++;
         
         System.out.println(roll1 + " + " + roll2 + " = " + sum);
      }
      
      System.out.println("sum of 7 after " + rolls + " rolls");
   }

   // Write a static method called insertDashes that takes a string
   // as a parameter and that returns a new string where in between
   // each pair of letters of the old string is a dash.  
   // For example, insertDashes("hello") should return "h-e-l-l-o".   
   public static String insertDashes(String str) {
      String result = "";
      if (str.length() < 2) {
         return str;
      }
      
      for (int i = 0; i < str.length() - 1; i++) {
         result += str.charAt(i);
         result += "-";
      }
      result += str.charAt(str.length() - 1);
      
      return result;
   }
}