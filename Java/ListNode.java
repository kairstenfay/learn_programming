// Erika Wolfe
// ListNode is a class for storing a single node of a linked list storing
// integer values. 
public class ListNode {
    public int data;       // data stored in this node
    public ListNode next;  // link to next node in the list

    // post: constructs a node with data 0 and no next link
    public ListNode() {
        this(0, null);
    }

    // post: constructs a node with given data and no next link
    public ListNode(int data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}