public class Point {
   int x;
   int y;
   
   public double distanceFromOrigin() {
      return Math.sqrt(x * x + y * y);
   }
   
   public double distanceTo(Point other) {
      return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
   }
   
   public void translate(int dx, int dy) {
      x += dx;
      y += dy;
   }   
}