// Erika Wolfe
// Simple program that creates a linked list and writes it out.

public class ListExample {
    public static void main(String[] args) {
        // we started with this version of the code, but it was
        // annoying to have to set next and data right after node
        // construction
        
        // if you want to visualize this in the debugger, use this 
        // version
        
        // ListNode list = new ListNode();
        // list.data = 3;
        // list.next = new ListNode();
        // list.next.data = 7;
        // list.next.next = new ListNode();
        // list.next.next.data = 2;
        // list.next.next.next = null;
        
        // after writing the constructor ListNode(int data)
        // we could write this version
        // we also noted that setting to null was unnecessary
        
        // ListNode list = new ListNode(3);
        // list.next = new ListNode(7);
        // list.next.next = new ListNode(2);
        
        // after writing the constructor ListNode(int data, ListNode next)
        // we could write this version
        
        ListNode list = new ListNode(3, new ListNode(7, new ListNode(2)));
        
        System.out.println(list.data + " " + list.next.data + " "
                           + list.next.next.data);
    }
}