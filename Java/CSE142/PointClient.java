public class PointClient {
   public static void main(String[] args) {
      // old approach
      int x1 = 2;
      int y1 = 6;
      int x2 = 4;
      int y2 = 9;
      System.out.println("Point 1 from origin: " + distanceFromOrigin(x1, y1));
      System.out.println("Point 2 from origin: " + distanceFromOrigin(x2, y2));
      System.out.println("Distance between points: " + distanceBetween(x1, y1, x2, y2));
      System.out.println();
      
      // encapsulated approach
      Point p1 = new Point();
      p1.x = 2;
      p1.y = 6;
      Point p2 = new Point();
      p2.x = 4;
      p2.y = 9;
      System.out.println("Point 1 from origin: " + distanceFromOrigin(p1));
      System.out.println("Point 2 from origin: " + distanceFromOrigin(p2));
      System.out.println("Distance between points: " + distanceBetween(p1, p2));
      System.out.println();
      
      translate(p1, 5, -7);
      System.out.println("Point 1 from origin: " + distanceFromOrigin(p1));
      System.out.println("Point 2 from origin: " + distanceFromOrigin(p2));
      System.out.println("Distance between points: " + distanceBetween(p1, p2));
      System.out.println();
      
      // object-oriented approach
      Point p3 = new Point();
      p3.x = 2;
      p3.y = 6;
      Point p4 = new Point();
      p4.x = 4;
      p4.y = 9;      
      System.out.println("Point 3 from origin: " + p3.distanceFromOrigin());
      System.out.println("Point 4 from origin: " + p4.distanceFromOrigin());
      System.out.println("Distance between points: " + p3.distanceTo(p4));
      System.out.println();
      
      p3.translate(5, -7);
      System.out.println("Point 3 from origin: " + p3.distanceFromOrigin());
      System.out.println("Point 4 from origin: " + p4.distanceFromOrigin());
      System.out.println("Distance between points: " + p3.distanceTo(p4));
      System.out.println();
   }
   
   public static double distanceFromOrigin(int x, int y) {
      return Math.sqrt(x * x + y * y);
   }
   
   public static double distanceBetween(int x1, int y1, int x2, int y2) {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
   
   public static double distanceFromOrigin(Point p) {
      return Math.sqrt(p.x * p.x + p.y * p.y);
   }
   
   public static double distanceBetween(Point p1, Point p2) {
      return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
   }
   
   public static void translate(Point p, int dx, int dy) {
      p.x += dx;
      p.y += dy;
   }
}