// Erika Wolfe, CSE 143
// This class shows an example of how to work with Stacks and Queues

import java.util.*;

public class StackQueueSum {
    public static void main(String[] args) {
        Stack<Integer> s = makeStack(10);
        Queue<Integer> q = makeQueue(10);
        
        System.out.println("initial q: " + q);
        System.out.println("sum of q: " + sumQueue(q));
        System.out.println("after q: " + q);
        
        System.out.println();

        System.out.println("initial s: " + s);
        System.out.println("sum of s: " + sumStack(s));
        System.out.println("after s: " + s);
    }
    
    // return sum all values in the given stack
    public static int sumStack(Stack<Integer> s) {
        // We decided to use an auxiliary data structure 
        // because otherwise we would need to remove all 
        // values from the Stack
        // Note a Stack would be an easier auxiliary 
        // structure to use, but Erika is mean and 
        // forced you to use a Queue :) 
        Queue<Integer> q = new LinkedList<Integer>();
        int sum = 0;
        while (!s.isEmpty()) {
            int num = s.pop();
            sum += num;
            q.add(num);
        }
        
        // All elements are in the queue - need to move
        // to the Stack to maintain the parameter state
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        
        // All elements are in the stack, but backwards
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        
        // All elements in the queue
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        
        // All elements in the Stack in the correct order! 
        return sum;
    }
    
    // returns sum of all values in the given Queue
    public static int sumQueue(Queue<Integer> q) {
        // like a cumulative sum from 142
        int sum = 0;
        for (int i = 0; i < q.size(); i++) {
            int num = q.remove();
            sum += num;
            // need to add the element back to maintain
            // the state of the given Queue
            q.add(num);
        }
        
        return sum;
    }
    
    // Returns a Queue with the numbers 1 to max (inclusive) 
    // with 1 at the front and max at the back.
    public static Queue<Integer> makeQueue(int max) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= max; i++) {
            q.add(i);
        }
        return q;
    }
    
    // Returns a Stack with the numbers 1 to max (inclusive) 
    // with 1 at the bottom and max at the top.
    public static Stack<Integer> makeStack(int max) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 1; i <= max; i++) {
            s.push(i);
        }
        return s;
    }
}