// Erika Wolfe
// Sample client code that manipulates two ArrayIntList objects

public class ArrayIntListClient {
    public static void main(String[] args) {
        // create two ArrayIntLists
        ArrayIntList list1 = new ArrayIntList();
        ArrayIntList list2 = new ArrayIntList();
        
        // add 20, 27, 43 to list1
        
        // First we added by modifying elementData directly
        // This is clunky and not nice for the client to use.
        
        // list1.elementData[0] = 20;
        // list1.elementData[1] = 27; 
        // list1.elementData[2] = 43;
        // list1.size = 3;
        
        // Instead, we should have an add method 
        list1.add(20);
        list1.add(27);
        list1.add(43);
        
        // We realized the client could modify size to break 
        // our implementation.  To avoid this we made the fields private.
        
        // list1.size = -1;
        // list2.size = 10;
        
        // Once the fields were made private the client would be unable
        // to print size using the field access.  We added a size method.
        System.out.println(list1.size());
        
        // print both lists
        System.out.println(list1);
        System.out.println(list2);
        
        
        ArrayIntList list3 = new ArrayIntList();
        list3.add(20);
        list3.add(27);
        list3.add(27);
        list3.add(27);
        list3.add(27);
        list3.add(101);
        
        System.out.println(list3.maxCount());
        System.out.println(list3);
    }
}