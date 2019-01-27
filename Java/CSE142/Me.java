public class Me extends You {
   public void method2() {
      System.out.println("me.method2()");
      method3();
   }
   
   public void method3() {
      System.out.println("me.method3()");
      super.method2();
   }
   
}