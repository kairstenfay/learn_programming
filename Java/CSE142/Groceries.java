import java.awt.*;
import java.util.*;
import java.io.*;


public class Groceries { 


   public static void main (String[] args) throws FileNotFoundException  { 
      
      Scanner input = new Scanner(new File("groceries.txt"));
      double total = groceries(input);
      System.out.print(total);

   }
   
   public static double groceries (Scanner input) { 
      double total = 0.0;
      while (input.hasNext()) { 
         input.next();
         String category = input.next().toLowerCase();
         double price = input.nextDouble();
         if (category.equals("red")) { 
            total += price * 0.9;
         } else if (category.equals("blue")) { 
            total += price * 0.75;
         } else { 
            total += price;
         }
      }
      return total;
  }
}