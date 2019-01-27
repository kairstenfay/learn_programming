// Kairsten Fay
// 07/04/2018
// CSE 143 Section AA (Melissa Hovik)
// HW 2
//
// The Guitar37 class contains 37 playable notes on the chromatic scale from 
//   110Hz to 880Hz. Specific, given pitches are playable using playNote(). 
//   Strings (simulated notes) can be played by passing a key to pluck().
//   Guitar37 also has the following additional functionalities:
//     - Checking if certain keys are implemented as notes using hasString()
//     - Getting the sum of the first values in the 37 ring buffers using 
//         sample()
//     - Making the current sound sample advance in time using tic()
//     - Checking the number of ticks (place in time) in the sound sample 
//         using time()

public class Guitar37 implements Guitar {
   public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
   public static final double CONCERT_A = 440.0;  // frequency. 
   public static final int PITCH_INDEX_OFFSET = 24; // A is pitch 0, index 24 ("v")
   private int time;
        
   private GuitarString[] strings;
   
   // creates 37 guitar strings from pitch -24 to 12
   public Guitar37() { 
      strings = new GuitarString[37];
      for (int i = 0; i < KEYBOARD.length(); i++) { 
         strings[i] = new GuitarString(CONCERT_A * Math.pow(2.0, (i - 24)/12.0));
      }
   }

   // Plays the given pitch. Pitch is an integer where pitch of concert-A == 0.
   // Pitch is specified as an integer where the value 0 represents concert-A 
   //   and all other notes are specified relative to concert-A using what is 
   //   known as a chromatic scale. 
   // Not every value of pitch can be played by 
   //   any given guitar.  If it can’t be played, it is ignored.
   public void playNote(int pitch) {
      if (pitch >= 0 - PITCH_INDEX_OFFSET && pitch <= PITCH_INDEX_OFFSET / 2) {  
         strings[pitch + PITCH_INDEX_OFFSET].pluck();
      }
   }

   // pre: the key is legal for this guitar 
   public boolean hasString(char key) {
      return KEYBOARD.contains("" + key);
   }

   // A client can also specify a character that indicates which note to play 
   //   by calling the pluck method.  Different guitar objects will have 
   //   different mappings from characters to notes.  The interface includes a 
   //   method called hasString that is paired with pluck that lets a client 
   //   verify that a particular character has a corresponding string for this 
   //   guitar.  The pluck method has a precondition that the key is legal for 
   //   this guitar.
   // Recall that Strings have an indexOf method that you might 
   //   find helpful.
   public void pluck(char key) throws IllegalArgumentException {
      if (!hasString(key)) { 
         throw new IllegalArgumentException("The '" + key + "' key is not valid for this guitar");
      } else { 
         strings[KEYBOARD.indexOf(key)].pluck();
      }
   }

   // returns the sum of the values
   public double sample() { 
      double sum = 0.0;
      for (int i=0; i < strings.length; i++) { 
         sum += strings[i].sample();
      }
      return sum;
   }

   // comment
   public void tic() {
      for (int i=0; i < strings.length; i++) { 
         strings[i].tic();
      }
      time++;
   }

   // comment
   public int time() { 
      return time;
   }
}

/*
The Guitar interface also has methods for getting the current sound sample 
(the sum of all samples from the strings of the guitar), to advance the time 
forward one “tic,” and an optional method for determining the current time 
(the number of times tic has been called).  If the time method is not 
implemented, it returns -1.

*/ 