// Erika Wolfe, CSE 143
// Some ArrayList examples

import java.util.ArrayList;

public class ArrayListClient {
    // Translation from array to ArrayList:
    //  String[]             ArrayList<String>
    //  new String[n]        new ArrayList<String>()
    //  list[i]              list.get(i)
    //  list[i] = val        list.set(i, val);
    //  list.length          list.size()
    // New operations:
    //  list.add(val)        appends val to list
    //  list.add(i, val)     inserts val at index i shifting subsequent values to the right
    //  list.remove(i)       removes and returns the value at i
    //  list.clear()         clears the entire ArrayList
    
    public static void main(String[] args) {
        //String[] array = new String[10];
        ArrayList<String> list = new ArrayList<String>();
        
        list.add("welcome");
        list.add("to");
        list.add("143!");
        System.out.println(list);
        
        // Shifts over all values
        list.add(0, "hi");
        System.out.println(list);
        
        // Shifts over "143!"
        list.add(3, "cse");
        System.out.println(list);
        
        // Shifts everything after index 1
        list.remove(2);
        System.out.println(list);
        
        // We made a ArrayList of integers using the Integer wrapper class
        // Doesn't work: ArrayList<int> intList = new ArrayList<int>();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(5);
        intList.add(1234);
        intList.add(666);
        System.out.println(intList);
    }
}
