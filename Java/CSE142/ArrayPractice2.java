// Program showing some additional array practice problems, similar to
//  those that might appear on the final exam. Each problem is a method,
//  and main contains sample calls to those methods to demonstrate
//  their behavior.
import java.util.*;

public class ArrayPractice2 {
   public static void main(String[] args) {
      int[] list1 = {1, 3, 4, 5, 5, 8, 10, 12};
      int[] list2 = {102, 103, 105, 104, 108, 109};
      
      System.out.println(Arrays.toString(list1) + " -> " + isSorted(list1));     // true
      System.out.println(Arrays.toString(list2) + " -> " + isSorted(list2));     // false
      System.out.println();
      
      System.out.print(Arrays.toString(list1) + " -> ");
      rotateLeft(list1);
      System.out.println(Arrays.toString(list1));
      System.out.print(Arrays.toString(list2) + " -> ");
      rotateLeft(list2);
      System.out.println(Arrays.toString(list2));      
      System.out.println();
      
      System.out.println(Arrays.toString(list1) + " + " + Arrays.toString(list2) + " -> " + 
                         Arrays.toString(interleave(list1, list2)));
      System.out.println(Arrays.toString(list1) + " + " + Arrays.toString(list2) + " -> " + 
                         Arrays.toString(altInterleave(list1, list2)));                         
   }
   
   // Write a static method called isSorted that takes an array of
   // integers as a parameter and that returns true if the integers
   // appear in nondecreasing sorted order.
   //
   // Notice the use of the "innocent until proven guilty" approach
   //  where a value can be returned early in some cases. Also notice
   //  the modified traversal bounds.
   public static boolean isSorted(int[] nums) {
      for (int i = 0; i < nums.length - 1; i++) {
         if (nums[i] > nums[i + 1]) {
            return false;
         }
      }
      
      return true;
   }
   
   // Write a static method called rotateLeft that takes an array
   // of integers as a parameter and that rotates all values to the
   // left by one position, rotating the first value to the back of
   // the array.  For example, given the list {1, 2, 3, 4}, a call
   // on rotateLeft should yield {2, 3, 4, 1}.
   //
   // Notice the modified traversal bounds and the "shifting" of
   //  elements to earlier indices in the array.
   public static void rotateLeft(int[] arr) {
      if (arr.length > 0) {
         int first = arr[0];
         for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
         }
         arr[arr.length - 1] = first;
      }
   }
   
   // Write a static method called interleave that takes two arrays
   // of integers as parameters and that returns a new array that
   // contains the result of interleaving the elements of the two
   // arrays.  Two arrays are interleaved by taking elements in an
   // alternating fashion from the two lists (first value of first
   // list, first value of second list, second value of first list,
   // second value of second list, etc). If one list is longer
   // than the other, ignore the extra values.   
   //
   // Notice the creation of a result array whose length is based on
   //  on the lengths of the parameter arrays. Also notice how the
   //  loop variable (i) needs to be modified to access the parameters
   //  vs. the result.
   public static int[] interleave(int[] arr1, int[] arr2) {
      int min = Math.min(arr1.length, arr2.length);
      int[] result = new int[2 * min];
      for (int i = 0; i < result.length; i++) {
         if (i % 2 == 0) {
            // result[0] = arr1[0]
            // result[2] = arr1[1]
            // result[4] = arr1[2]
            // ...
            
            result[i] = arr1[i / 2];
         } else {
            // result[1] = arr2[0]
            // result[3] = arr2[1]
            // result[5] = arr2[2]
            // ...
            
            result[i] = arr2[i / 2];
         }
      }
      return result;
   }
   
   // Alternate implementation of interleave that traverses a
   //  parameter array rather than the result array. Again, notice 
   //  the computations involving i to find the correct index into
   //  each array.
   public static int[] altInterleave(int[] arr1, int[] arr2) {
      int min = Math.min(arr1.length, arr2.length);
      int[] result = new int[2 * min];
      for (int i = 0; i < min; i++) {
         // result[0] = arr1[0]
         // result[1] = arr2[0]
         // result[2] = arr1[1]
         // result[3] = arr2[1]
         // ...
         
         result[2 * i] = arr1[i];
         result[2 * i + 1] = arr2[i];
      }
      return result;   
   }
}