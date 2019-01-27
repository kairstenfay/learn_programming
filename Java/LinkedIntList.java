// Erika Wolfe
// Simple version of LinkedIntList with the appending add method

public class LinkedIntList {
    private ListNode front;

    // post: appends the value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }
    
    // This implementation did not modify the list! 
    // current goes off the end of the list, so at the end
    // of the while loop current is null.  Then current is set
    // to a new ListNode object separate from the list.
    // public void add(int value) {
    //     ListNode current = front;
    //     while (current != null) {
    //         current = current.next;
    //     }
    //     current = new ListNode(value);
    // }
}
