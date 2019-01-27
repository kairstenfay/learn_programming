import java.util.*;

public class test { 
   
   public static void main (String[] args) { 
   
      double[] arr = new double[]{1.1, 1.2, 1.3, 1.4, 1.5};
      System.out.println("Going to initialize the GuitarString with " + 
                         Arrays.toString(arr));
      GuitarString g = new GuitarString(arr);
      System.out.println("Sampling " + g.sample());
      System.out.println();
      
      
      System.out.println("now testing other constructor");
      GuitarString g2 = new GuitarString(1);
      System.out.println("Sampling " + g2.sample());
      
      System.out.println();
      System.out.println();
      
     double CONCERT_A = 440.0;
     double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);  
     GuitarString stringA = new GuitarString(CONCERT_A);
     GuitarString stringC = new GuitarString(CONCERT_C);
     
     System.out.println("Sampling " + stringA.sample());
     

   }
} 