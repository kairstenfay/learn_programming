// Example of a typical "inheritance mystery" problem you might see
//  on a CSE142 final exam.
public class Client {
   public static void main(String[] args) {
      You[] us = { new You(), new Me(), new Them() };
      
      for (int i = 0; i < us.length; i++) {
         us[i].method1();
         System.out.println();
         us[i].method2();
         System.out.println();
         System.out.println();
      }
   }
}