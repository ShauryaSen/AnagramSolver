package com.shauryasen.anagramsolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class AnagramSolver {

    public static void main(String[] args) {

        // Ask the user for string
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String of letters: ");
        String string = (scanner.nextLine()).toLowerCase().trim();

        ArrayList<String> words = new ArrayList<>();
        int totalWords = 0;


        // Open up the dictionary
        File file = new File("dictionary.txt");

        try ( BufferedReader br = new BufferedReader(new FileReader(file)) ) {

            // Temporary pointer string
            String line;

            // Loops through all the lines in the text.
            while ( (line = br.readLine()) != null ) {
                line = line.toLowerCase();

                // compare the current line with the string
                // converts the strings into char arrays
                char[] stringChars = string.toCharArray();
                char[] lineChars = line.toCharArray();

                // sort the two char arrays
                Arrays.sort(stringChars);
                Arrays.sort(lineChars);

                // compare the two char arrays
                if (Arrays.equals(stringChars, lineChars)) {
                    words.add(line);
                    totalWords++;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file " + file.toString());
        } catch (IOException e) {
            System.out.println("Unable to read file.");
        }

        // Display the words
        System.out.println("\nNumber of words possible to make: " + totalWords);
        System.out.println("All possible words:");

        for (String word : words) {
            System.out.println(word);
        }

    }

}
