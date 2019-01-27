// Erika Wolfe
// Simple example showing how reference semantics work
import java.util.*;

public class ReferenceSemantics {
    public static void main(String[] args) {
        // int values are stored as values, which means
        // assignment gives you an independent copy
        // (changing y does not change x)
        int x = 18;
        System.out.println("initial x = " + x);
        int y = x;
        y++;
        System.out.println("x now     = " + x);
        System.out.println("y         = " + y);
        System.out.println();

        // objects such as strings, queues, lists, are
        // stored as references, which means assignment
        // gives you a copy of the reference to the object
        // (not a copy of the actual object)
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(18);
        System.out.println("initial q = " + q);
        Queue<Integer> copy = q;
        copy.add(42);
        System.out.println("q now     = " + q);
        System.out.println("copy      = " + copy);
    }
}