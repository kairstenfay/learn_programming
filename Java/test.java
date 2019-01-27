public class test { 
   public static void main (String[] args) { 
      LetterInventory test = new LetterInventory("hello");
      System.out.println(test);
      System.out.println(test.size());
      
      LetterInventory test2 = new LetterInventory("goodbye");
      String combined = "hellogoodbye";
      
      LetterInventory test3 = new LetterInventory(combined);
     
      System.out.println(test.add(test2));
      
      LetterInventory test4 = new LetterInventory("hell");
      
      LetterInventory res = test.subtract(test4);
      System.out.println(res);
      System.out.println(res.size());
      
      System.out.println(test.subtract(test2));
      
      LetterInventory me = new LetterInventory("Kai**?.rs ten ");
      LetterInventory res2 = res.add(me);
      System.out.println(res);
      System.out.println(res.size());
      
      System.out.println(res2);
      System.out.println(res2.size());
      
      LetterInventory test5 = new LetterInventory("abc");
      System.out.println(test5.size());
   }
   
}