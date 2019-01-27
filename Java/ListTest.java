// Erika Wolfe
// This class contains the second before/after example from 
// lecture.  Use with the jGRASP debugger and drag the "dummy" 
// variable out to view list and temp.

public class ListTest {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(1);
        
        // problem setup
        ListNode list = new ListNode(2, new ListNode(4));
        ListNode temp = new ListNode(3, new ListNode(9));
        
        // code to solve the problem!
        list.next.next = temp;
        temp = temp.next;
        list.next.next.next = null;
    }
}