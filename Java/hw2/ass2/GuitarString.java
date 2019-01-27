// Kairsten Fay
// 07/04/2018
// CSE 143 Section AA (Melissa Hovik)
// HW 2

import java.util.*;

// The GuitarString class constructs a guitar string of a given frequency and 
//   initializes the string to be at rest. The user may also initialize a 
//   guitar string by specifying the ring buffer's values for testing purposes.
//   The GuitarString class gives methods for plucking, tic-ing (applying the 
//   Karplus-Strong algorithm), and for sampling the front of the ring buffer.
public class GuitarString { 

   public static final double ENERGY_DECAY_FACTOR = 0.996;

   private int capacity;  // "N"
   private Queue<Double> ringBuffer; 
   	
   // pre: the frequency is > 0 and the size of the ring buffer is >= 2 
   //   (throws IllegalArgumentExceptions if violated)
   // post: constructs a guitar string of a given frequency. It creates a ring 
   //   buffer and initializes it to be at rest. 
   public GuitarString(double frequency) throws IllegalArgumentException { 
      if (frequency <= 0) {  
         throw new IllegalArgumentException("Your frequency must be > 0");
      } else {
         System.out.println("The sample rate is " + StdAudio.SAMPLE_RATE);
         capacity = (int) Math.round(StdAudio.SAMPLE_RATE / frequency);
         checkLength();
         ringBuffer = new LinkedList<Double>();
         
         for (int i = 0; i < capacity; i++) { 
            ringBuffer.add(0.0); // initialize to all 0s (at rest) 
         }
      }
   } 
   
   // This constructor is used only for testing purposes. 
   // 
   // pre: the size of the ring bufer is >= 2 (throws 
   //   IllegalArgumentException if violated)
   // post: constructs a guitar string, initializing the contents of the ring 
   //   buffer to the given values in the array. 
   public GuitarString(double[] init) { 
      capacity = init.length;
      checkLength();
      ringBuffer = new LinkedList<Double>();

      for (int i = 0; i < init.length; i++) { 
         ringBuffer.add(init[i]);
      }
   } 
   
   // pre: the size of the ring buffer is >= 2. Throws an
   //   IllegalArgumentException if violated.  
   private void checkLength() throws IllegalArgumentException { 
      if (capacity < 2) { 
         throw new IllegalArgumentException("The size of your ring buffer must be >= 2.");
      }
   }
   
   // post: Simulates the plcking of a guitar string by replacing the values in
   //   the ring buffer with random values where -0.5 <= value < 0.5. 
   public void pluck() { 
      Random rand = new Random();
      
      for (int i = 0; i < capacity; i++) {
         ringBuffer.remove();
         ringBuffer.add(rand.nextDouble() - 0.5); 
      }
   }
   
   // post: applies the Karplus-Strong update once to the first two values in 
   //   the ring buffer, adding the result to the end of the ring buffer and
   //   removing the first value. 
   public void tic() { 
      double front = ringBuffer.remove();
      ringBuffer.add(((front + ringBuffer.peek()) / 2) * ENERGY_DECAY_FACTOR);
   } 
   
   // post: returns the current sample (the value at the front of the ring 
   //   buffer)
   public double sample() { 
      return ringBuffer.peek();
   }
} 