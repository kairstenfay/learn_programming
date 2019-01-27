// Erika Wolfe
// Simple example of an array of objects

import java.awt.*;  // to import Point class

public class PointArray {
    public static void main(String[] args) {
        // the following constructs the array, but no Point objects
        Point[] points = new Point[5];

        // this loop fills up the array with Point objects
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(i, i);
        }

        // this loop prints the Point objects
        for (int i = 0; i < points.length; i++) {
            System.out.println(p);
        }
    }
}
