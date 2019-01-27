// Kairsten Fay
// 5/20/2018
// CSE142
// TA: Rachel Imhof
// Assignment #7
//
// Prints a report about characteristics of nucleotide sequencess from an input file. 
// It computes mass percentages occupied by each nucleotide, reports the codons (trios of 
// NUCLEOTIDES) present in each sequence, and predicts whether or not the sequence is a 
// protein-coding gene.

import java.io.*;
import java.util.*; 

public class DNA { 
   public static final int MIN_CODONS = 5;
   public static final int PERCENT_C_G = 30;
   public static final int UNIQUE_NUCLEOTIDES = 4;
   public static final int NUCLEOTIDES_PER_CODON = 3;
   public static final String START_CODON = "ATG";
   public static final String[] STOP_CODONS = {"TAA", "TAG", "TGA"};
   public static final char[] NUCLEOTIDES = {'A', 'C', 'G', 'T'};
   public static final double[] MASSES = {135.128, 111.103, 151.128, 125.107};
   public static final char JUNK_CHAR = '-';
   public static final double JUNK_MASS = 100.0;

   public static void main(String[] args) throws FileNotFoundException { 
      Scanner console = new Scanner(System.in);
      String[] fileNames = greetAndPromptUser(console);
      Scanner input = new Scanner(new File(fileNames[0])); 
      PrintStream output = new PrintStream(new File(fileNames[1]));

      while (input.hasNextLine()) {  
         String[] sequenceIDs = getIDs(input);
         int[] counts = new int[UNIQUE_NUCLEOTIDES];
         int junkCount = countNucleotidesAndJunk(sequenceIDs[1], counts);
         double[] percentOfMass = new double[UNIQUE_NUCLEOTIDES];
         double totalMass = getMass(counts, junkCount, percentOfMass);
         String[] codons = findCodons(sequenceIDs[1]);
         String isProtein = checkIfProteinCodingGene(codons, percentOfMass);
         
         printReport(output, sequenceIDs, counts, codons, totalMass, isProtein, percentOfMass);
      }
   }
   
   
   // Takes the generated output from the previous methods and prints them in a formatted way to 
   //   the PrintStream object.
   //
   // PrintStream output - the object that designates a destination file for output printed to it
   // String[] sequenceIDs - the array of identifying information for the nucleotide sequence
   // int[] counts - the array of the count of times each unique nucleotide appears in the sequence
   // String[] codons - the array of the codons in the nucleotide sequence
   // double totalMass - the total mass of the nucleotide sequence
   // String isProtein - a string telling whether the sequence is or isn't a protein encoding 
   //   sequence
   // double[] percentOfMass - the array of the percent of mass each unique nucleotide comprises of
   //   the total mass
   public static void printReport(PrintStream output, String[] sequenceIDs, int[] counts, 
                                  String[] codons, double totalMass, String isProtein, 
                                  double[] percentOfMass) { 
      output.println("Region Name: " + sequenceIDs[0]);
      output.println("Nucleotides: " + sequenceIDs[1]);
      output.println("Nuc. Counts: " + Arrays.toString(counts));
      output.println("Total Mass%: " + Arrays.toString(percentOfMass) + " of " + 
                     Math.round(totalMass * 10.0) / 10.0);
      output.println("Codons List: " + Arrays.toString(codons));
      output.println("Is Protein?: " + isProtein);
      output.println();
   } 
   
   
   // Takes the outputs of previous functions and runs tests on them. 
   // Returns a string telling whether the sequence is or isn't a protein encoding 
   //   sequence
   //
   // String[] codons - the array of the codons in the nucleotide sequence
   // double[] percentOfMass - the array of the percent of mass each unique nucleotide comprises of
   //   the total mass
   public static String checkIfProteinCodingGene(String[] codons, double[] percentOfMass) { 
      boolean isProtein = true;
      
      // Check if the first codon is the start codon 
      if (!codons[0].equals(START_CODON)) { 
         isProtein = false;
      }
      
      // Check if the last codon is in the array of stop codons provided 
      boolean endsWithStopCodon = false;
      for (int i=0; i < STOP_CODONS.length; i++) { 
         if (codons[codons.length-1].equals(STOP_CODONS[i])) { 
            endsWithStopCodon = true;
         }
      }
      if (!endsWithStopCodon) { 
         isProtein = false;
      }

      
      // Check if the number of codons is greater than the minimum codons specified
      if (codons.length < MIN_CODONS) { 
         isProtein = false;
      }
      
      // Check if Cytosine (C) and Guanine (G) combined account for at least 30% of its total mass
      if (percentOfMass[1] + percentOfMass[2] < PERCENT_C_G) {
         isProtein = false; 
      }
      
      // Check if all conditions were met
      if (isProtein) { 
         return "YES";
      } else { 
         return "NO";
      }
   }
   
   
   // Takes a nucelotide sequence and returns an array of codons.
   //
   // String nucleotideSequence - a nucleotide sequence from the given input file
   public static String[] findCodons(String nucleotideSequence) { 
      nucleotideSequence = nucleotideSequence.replace("" + JUNK_CHAR, "");
      String[] codons = new String[nucleotideSequence.length() / NUCLEOTIDES_PER_CODON];
      for (int i=0; 3 * i < nucleotideSequence.length(); i++) { 
         codons[i] = nucleotideSequence.substring(3 * i, 3 * i + 3);
      }
      return codons;
   }
   
   
   // Updates the array of percents of mass of each nucleotide by calculating the total mass of
   //   the nucelotide sequence. Returns the total mass of the sequence.
   //
   // int[] counts - the array of the count of times each unique nucleotide appears in the sequence
   // int junkCount - TODO
   // double[] percentOfMass - the array of the percent of mass each unique nucleotide comprises of
   //   the total mass
   public static double getMass(int[] counts, int junkCount, double[] percentOfMass) { 
      double totalMass = 0;
      for (int i=0; i < counts.length; i++) { 
         totalMass += MASSES[i] * counts[i];
      }
      
      totalMass += junkCount * JUNK_MASS;
      
      // Update percent of mass array. 
      for (int i=0; i < counts.length; i++) { 
         percentOfMass[i] = Math.round((MASSES[i] * counts[i]) / totalMass * 1000.0) / 10.0;
      }
      return totalMass;
   }
   
   
   // Reads lines from the given input file and assigns them into an array of identifying
   //   information. Returns the ID array.
   //
   // Scanner input - the input file to read 
   public static String[] getIDs(Scanner input) { 
      String[] ids = {input.nextLine(), input.nextLine().toUpperCase()};
      return ids;
   }
   

   // Takes a nucleotide sequence and returns the number of occurences of each unique nucleotide.
   //   Updates the counts array and returns the number of times junk occurs in the sequence. 
   // 
   // String nucleotideSequence - the nucleotide sequence from the input file 
   // int[] counts - the initialized array of the count of times each unique nucleotide appears in
   //   the sequence
   public static int countNucleotidesAndJunk(String nucleotideSequence, int[] counts) { 
      int junkCount = 0;
      for (int i=0; i < nucleotideSequence.length(); i++) { 
         if (nucleotideSequence.charAt(i) == JUNK_CHAR) {
            junkCount++;
         } else {
            for (int j=0; j < NUCLEOTIDES.length; j++) { 
               if (nucleotideSequence.charAt(i) == NUCLEOTIDES[j]) { 
                  counts[j]++;
               } 
            }
         }
      }
      return junkCount;
   }
   
   
   // Introduces the program to the user and asks the user for an input and output file. Returns an
   //   array containing the strings of the user's desired file names.
   //
   // Scanner console - the given Scanner object 
   public static String[] greetAndPromptUser(Scanner console) { 
      String[] fileNames = new String[2];
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");
      System.out.print("Input file name? ");
      fileNames[0] = console.nextLine();
      System.out.print("Output file name? ");
      fileNames[1] = console.nextLine();
      
      return fileNames;
   }
}