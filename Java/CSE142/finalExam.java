import java.io.*;
import java.util.*; 

public class finalExam { 
   public static void main (String[] args) throws FileNotFoundException {
   
   Scanner input = new Scanner(new File("finalExam.txt"));
   
    
//    //int[] list = new int[] {0, 3, -1, 22, 44, 1};
//    //switchPairs(list);
//    //System.out.println(Arrays.toString(list));
//    ArrayList<Integer> list = new ArrayList<Integer>();
//    list.add(3);
//    list.add(5);
//    list.add(-1);
//    list.add(7);
//    list.add(-10);
//    list.add(-1);
//    list.add(0);
//    list.add(3);
//    
//    //negativesToFront(list);
//    //System.out.println(list);
//    
//    ArrayList<String> arr = new ArrayList<String>();
//    arr.add("octopus");
//    arr.add("clam");
//    arr.add("squid");
//    arr.add("clam");
//    arr.add("seaweed");
//    arr.add("octopus");
//    arr.add("octopus");
//    arr.add("starfish");
//    
//    compress(arr);
//    System.out.print(arr);
   
   // int result = analyzeParagraphs(input);
  //  System.out.println(result);
  
//    String seq = "GA-CAAC-G--C";
//    double[] vals = {1.0, 2.1, 1.3, 0.7, 3.4, 2.0, 1.0, 0.6}; 
//    
//    double[] res6 = getTotalValues(seq, vals);
//    System.out.println(Arrays.toString(res6));

   //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(18, 7, 4, 24, 11));
   //split(arr);
   //System.out.println(arr);
   
   String a = "abccccccba";
   String b = "xyzzzzzzyx";
   
   System.out.println(samePattern(a, b));
   
   }
   
   public static boolean samePattern(String a, String b) { 
      int uniqueB = 0;
      int uniqueA = 0;
      
      String dummyA = "" + uniqueA;
      String dummyB = "" + uniqueB;
      
      if (a.length() != b.length()) { 
         return false;
      }
      
      for (int i=1; i < a.length(); i++) { 
         if (!a.substring(0,i).contains(a.substring(i,i+1))) { 
            uniqueA++;
         }
         
         dummyA += uniqueA;
         
         if (!b.substring(0, i).contains(b.substring(i, i+1))) { 
            uniqueB++;
         }
         
         dummyB += uniqueB;
         
      }
      
      if (dummyA.equals(dummyB)) { 
         return true;
      } else { 
         return false;
      }
    }
    
   public static void split(ArrayList<Integer> arr) { 
      int size = arr.size();
      for (int i=0; i < size * 2; i+=2) { 
         int val = arr.get(i);
         if (val % 2 == 0) { 
            arr.set(i, val/2);
            arr.add(i + 1, val / 2);
         } else { 
            arr.set(i, val/2 + 1);
            arr.add(i + 1, val / 2);
         }
      }
   }
   
   public static double[] getTotalValues(String seq, double[] arr) { 
      double[] total = new double[4];
      char[] nucs = new char[]{'A','C','G','T'};
      seq = seq.replace("-","");
      
      for (int i =0; i < seq.length(); i++) { 
         for (int j=0; j < nucs.length; j++) { 
            if (seq.charAt(i) == nucs[j]) { 
               total[j] += arr[i];
            }
         }
      }
      
      return total;
      
   }
   
   public static int analyzeParagraphs(Scanner input) { 
      int maxLines = 0;
      while (input.hasNextLine()) { 
         int numLines = 0;
         while (!input.nextLine().equals("<p>")) { 
            numLines ++ ;
         }
         
         System.out.println(numLines + "-line paragraph");
         maxLines = Math.max(maxLines, numLines);
         
      }
      return maxLines;
   }
   
   
   public static void redact (Scanner input)  {
      
      while (input.hasNext()) { 
         String word = input.next();
         if (!word.equals("CLASSIFIED")) { 
            System.out.println(word);
         } else { 
            int numRedacted = input.nextInt();
            while (numRedacted > 0) { 
               input.next();
               System.out.println("[redacted]");
               numRedacted--;
            }
         }
     }
  }
  
  public static void compress (ArrayList<String> arr) { 
   for (int i=0; i < arr.size(); i++) { 
      int numReps = 1;
      for (int j = 1; j < arr.size() - i; j++) { 
         if (arr.get(i).equals(arr.get(i + j))) { 
            numReps ++;
            arr.remove(i + j);
            j--;
         }
      }
      
      if (numReps > 1) { 
         arr.set(i, "" + numReps + "*" + arr.get(i));
      }
    }
  
  }
  
  public static void negativesToFront(ArrayList<Integer> list) { 
   int length = list.size();
   for (int i=0; i < length; i++) { 
      System.out.println(i);
      System.out.println(list);
      if (list.get(i) >= 0) { 
         int hold = list.get(i);
         list.remove(i);
         list.add(hold);
         length--;
         i--;
      }
   }
   
  } 
  
  public static void switchPairs(int[] arr) { 
   for (int i = 0; i < arr.length/2; i ++ ) { 
      int hold = arr[i * 2];
      arr[i * 2] = arr[i * 2 + 1];
      arr[i * 2 + 1] = hold;
   }
  }
  
}
         