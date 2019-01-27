// Erika Wolfe
// CSE 143, Section ZZ
// TA: Stuart Reges
// This program reads in a file and prints out the lines in reverse order

import java.io.*;
import java.util.*;

public class ReverseFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("words.txt"));
        
        // The array method is a little bit clunky
        // String[] allLines = new String[1000];
        // int count = 0;
        // while (input.hasNextLine()) {
        //     String line = input.nextLine();
        //     allLines[count] = line;
        //     count++;
        // }
        
        // for (int i = count - 1; i >= 0; i--) {
        //     System.out.println(allLines[i]);
        // }
        
        // First read in lines
        ArrayList<String> allLines = new ArrayList<String>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            allLines.add(line);
        }
        
        // Print in reverse
        for (int i = allLines.size() - 1; i >= 0; i--) {
            System.out.println(allLines.get(i));
        }
        
        // Array:        .length
        // String:       .length()
        // Collections:  .size()
    }
}
