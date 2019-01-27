// Erika Wolfe, CSE 143
// An example client of ListNodes
public class ListNodeClient {

    public static void main(String[] args) {
        // This is only to make the jGRASP debugger look nice 
        ListNode dummy = new ListNode(-1);
        // Building list 2 -> 4 -> 6
        ListNode list = new ListNode(2,
            new ListNode(4, new ListNode(6)));

        ListNode current = list;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        
        // Comparison to array traversal
        // for (int i = 0; i < data.length; i++)
        // 
        //    Array             Linked list
        //    int i = 0         ListNode current = list
        //    i < size          current != null
        //    elementData[i]    current
        //    i++               current = current.next
    }

}
