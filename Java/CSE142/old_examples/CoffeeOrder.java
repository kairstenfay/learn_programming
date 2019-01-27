// A program to calculate the total due from a coffee order.
// Includes 10% tax and a 5% "preferred customer" discount.
public class CoffeeOrder {
   public static void main(String[] args) {
      // latte ($5), frappuccino ($6), drip coffee ($2)
      int latte = 5;
      int frappuccino = 6;
      int drip = 2;
      
      int subtotal = latte + frappuccino + drip;
      double tax = subtotal * 0.1;
      double discount = subtotal * 0.05;
      
      System.out.println("Subtotal: $" + subtotal);
      System.out.println("Tax: $" + tax);
      System.out.println("Discount: ($" + discount + ")");
      System.out.println("TOTAL: $" + (subtotal - discount + tax));
   }
}