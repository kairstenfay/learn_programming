// Program demonstrating some ArrayList operations.

import java.util.*;

// old operations:
//    String[] arr         ==>   ArrayList<String>
//    new String[n]        ==>   new ArrayList<String>()
//    String s = arr[i];   ==>   String s = list.get(i);
//    arr[i] = s;          ==>   list.set(i, s);
//    arr.length           ==>   list.size()   
// new operations:
//    list.add(s)    - adds a new element to the end of the list
//    list.add(i, s) - adds a new element at index i, 
//                       shifting later elements "right"
//    list.remove(i) - removes and returns the element at index i, 
//                       shifting later elements "left"
//    list.clear()   - removes all elements from the list
public class ArrayListExamples {
   public static void main(String[] args) {
      // create a list of words
      ArrayList<String> words = new ArrayList<String>();
      words.add("may");
      words.add("the");
      words.add("odds");
      words.add("ever");
      words.add("in");
      words.add("my");
      words.add("uh....");
      words.add("favor");
      System.out.println(words);
      
      // fit it!
      words.add(3, "be");
      words.set(6, "your");
      words.remove(7);
      System.out.println(words);
      
      // change it!
      maxLengthToFront(words);
      System.out.println(words);
      System.out.println();
      
      // create a list of numbers
      ArrayList<Integer> nums = new ArrayList<Integer>();
      nums.add(4);
      nums.add(8);
      nums.add(15);
      nums.add(16);
      nums.add(23);
      nums.add(42);
      System.out.println(nums);
      
      // expand it!
      duplicate(nums);
      System.out.println(nums);
   }
   
   // Modifies the given ArrayList by moving the longest string
   //   in the list to the front (index 0) position.
   //
   // ArrayList<String> words - the list to modify   
   public static void maxLengthToFront(ArrayList<String> words) {
      if (words.size() > 0) {
         int longest = 0;
         for (int i = 1; i < words.size(); i++) {
            if (words.get(i).length() > words.get(longest).length()) {
               longest = i;
            }
         }
         
         String longWord = words.get(longest);
         words.remove(longest);
         words.add(0, longWord);
      }
   }
      
   // Modifies the given ArrayList to include two copies of each value
   //   currently in the list.
   // e.g. [3, 1, 4, 1, 5] -> [3, 3, 1, 1, 4, 4, 1, 1, 5, 5]
   //
   // ArrayList<Integer> numbers - the list to modify 
   //
   // Notice the modified traversal. With a standard traversal, this method
   //   would cause an infinite loop, since we are adding an element to the
   //   list on each iteration. This can be fixed by either incrementing i
   //   by two each time (skipping the newly added element) or by traversing
   //   the list in reverse (ensuring new elements are added after all elements
   //   yet to be visited).
   public static void duplicate(ArrayList<Integer> numbers) {
      // for (int i = 0; i < numbers.size(); i++) {      // <-- BAD: CAUSES INFINITE LOOP

      // for (int i = 0; i < numbers.size(); i += 2) {
      for (int i = numbers.size() - 1; i >= 0; i--) {
         int num = numbers.get(i);
         numbers.add(i + 1, num);
      }
   }
}