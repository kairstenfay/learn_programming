import java.util.*;

public class ArrayPractice {
   public static void main(String[] args) {
      int a = 5;
      int b = 7;
      System.out.println(a + " " + b);
      swap(a, b);
      System.out.println(a + " " + b);
      
      int[] nums = {1, 2, 3, 4, 5};
      System.out.println(Arrays.toString(nums));
      modify(nums);
      System.out.println(Arrays.toString(nums));
      
      double[] vals = {-10.2, 3.5, 9.7, 12.5, 1.3, -0.4, 11.1, 10.0};
      System.out.println(Arrays.toString(vals));
      cap(vals, 0, 10);
      System.out.println(Arrays.toString(vals));
      
      mystery();
   }
   
   // we saw that this is correct code for swapping two int values, but it
   // only swaps the local copies of these values and has no effect on any
   // variables that are used in calling the method
   public static void swap(int x, int y) {
      int temp = x;
      x = y;
      y = temp;
   }

   // we saw that this method was able to change the array contents because
   // of reference semantics
   public static void modify(int[] list) {
      list[0] = -924;
      list[1] = -42;
   }
   
   // a method to limit all values in an array to within a given range
   public static void cap(double[] nums, double min, double max) {
      for (int i = 0; i < nums.length; i++) {
         nums[i] = Math.min(max, nums[i]);
         nums[i] = Math.max(min, nums[i]);
      }
   }      
   
   // an example of an array mystery problem--there will a problem like this
   // on the final.
   public static void mystery() {
      int[] a = {1, 7, 5, 6, 4, 14, 11};
      for (int i = 0; i < a.length - 1; i++) {
         if (a[i] > a[i + 1]) {
            a[i + 1] = a[i + 1] * 2;
         }
      }
      System.out.println("mystery array = " + Arrays.toString(a));
   }   

   // this method reverses the sequence of values in an array
   public static void reverse(int[] list) {
      // we only want to do the swapping for half of the
      //   length of the list (otherwise we unreverse it)
	   // this works for both odd and even length lists (try it!)
      for (int i = 0; i < list.length / 2; i++) {
         // compute the index for the other value to swap
         int j = list.length - 1 - i;
         // swap two values
         int temp = list[i];
         list[i] = list[j];
         list[j] = temp;
      }
   }
   
   // a method to reverse a String and return the result of the reversal
   public static String reverse(String str) {
      String result = "";
      for (int i = str.length() - 1; i >= 0; i--) {
         result += str.charAt(i);
      }
      return result;
   }
}