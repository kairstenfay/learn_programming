public class Them extends Me {
   public void method1() {
      System.out.println("them.method1()");
      method3();
   }
   
   public void method2() {
      method1();
      System.out.println("them.method2()");
   }
}