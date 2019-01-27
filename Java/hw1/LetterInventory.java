// Kairsten Fay
// 06/23/2018
// CSE 143 HW 1
// Section AA: Melissa Hovik

// Represents a collection of letters (alphabetic characters) and provides
//   functionality for getting and setting character counts, returning size, 
//   checking if empty, and returning a string representation of the letter 
//   inventory. Additionally, the class can return an inventory representing 
//   the addition of two letter inventories or the difference between them. 
public class LetterInventory { 

   private int[] array;
   private int size;  // number of characters stored 
   
   public static final int CAPACITY = 26;  // # of unique alphabetic characters
   public static final int INTEGER_OFFSET = 97;  // (int) 'a' - 97 == 0
   
   // post: constructs a letter inventory from the given string, ignoring
   //   nonalphabetic characters 
   public LetterInventory(String data) { 
      data = data.toLowerCase();
      array = new int[CAPACITY];
      for (int i=0; i < data.length(); i++) { 
         if (data.charAt(i) >= 'a' && data.charAt(i) <= 'z' ) { 
            array[(int) data.charAt(i) - INTEGER_OFFSET]++;
            size++;
         } 
      }
   }
   
   // pre: given letter is alphabetic (throws IllegalArgumentException if not)
   // 
   // post: returns the number of times the given letter appears in the 
   //   inventory
   public int get(char letter) { 
      letter = Character.toLowerCase(letter);
      checkIfLetter(letter);
      return array[(int) letter - INTEGER_OFFSET];
   } 
   
   // post: checks that the given letter is alphabetic (throws 
   //   IllegalArgumentException if not)
   private void checkIfLetter(char letter) throws IllegalArgumentException { 
      if (letter < 'a' || letter > 'z') {
         throw new IllegalArgumentException("An alphabetic (a-z) character is required.");
      }
   }
   
   // pre: given letter is alphabetic (throws IllegalArgumentException if not) 
   // pre: value > 0 (throws IllegalArgumentException if not)
   //
   // post: sets the letter inventory to contain the given letter a specific 
   //   number of times using the given value 
   public void set(char letter, int value) {
      letter = Character.toLowerCase(letter);
      checkIfLetter(letter);
      
      if (value < 0) { 
         throw new IllegalArgumentException("A letter cannot occur fewer than 0 times.");
      }
      size += value - array[(int) letter - INTEGER_OFFSET];  // update size 
      array[(int) letter - INTEGER_OFFSET] = value;
   } 
   
   // post: returns the current number of letters in the inventory
   public int size() { 
      return size;
   }
   
   // post: returns true if the letter inventory is empty. Otherwise returns 
   //   false.
   public boolean isEmpty() { 
      if (size == 0) { 
         return true;
      } else { 
         return false;
      }
   }
   
   // post: returns a bracketed string representation of the letter inventory
   //   in alphabetical order
   public String toString() { 
      String formatted = "[";
      for (int i=0; i < array.length; i++) { 
         for (int j=0; j < array[i]; j++) { 
            formatted += (char) (i + INTEGER_OFFSET);  // add letter to string
         }
      }
      return formatted + "]";
   } 
   
   // post: returns a new letter inventory that represents the combined 
   //   inventories of the current and given other letter inventories
   public LetterInventory add(LetterInventory other) { 
      return combine(other, 1);
   }
   
   // pre: assumes the given letter inventory is a subset of the current letter
   //   inventory. Returns null if violated.
   // 
   // post: (if assumption is met) returns a new letter inventory that 
   //   represents the difference in the letter inventories of the current and 
   //   given other letter inventories. 
   public LetterInventory subtract(LetterInventory other) { 
      return combine(other, -1);
   }
   
   // pre: direction == -1 or direction == 1
   // post: either adds or subtracts letter inventories based on the given 
   //   direction. Returns null if any resulting frequency in the letter 
   //   inventory is below 0.
   private LetterInventory combine(LetterInventory other, int direction) { 
      LetterInventory combinedInventory = new LetterInventory("");
      for (int i=0; i < array.length; i++) { 
         int frequency = this.array[i] + direction * other.array[i];
         if (frequency < 0) { 
            return null;
         }
         combinedInventory.set((char) (i + INTEGER_OFFSET), frequency);
      }
      return combinedInventory;
   }       
}