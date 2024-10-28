package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratePermutation {
    public static void main(String[] args) {
        // Create a scanner to receive user input
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = userInputScanner.nextLine();
        userInputScanner.close(); // Close the scanner to avoid resource leakage

        // Check if the input is empty and handle accordingly
        if (userInput.isEmpty()) {
            System.out.println("Input string is empty.");
        } else {
            // Generate all permutations of the input string
            List<String> allPermutations = computeAllPermutations(userInput);

            // If no permutations are generated, display a message
            if (allPermutations.isEmpty()) {
                System.out.println("No permutations found for the input string.");
            } else {
                System.out.println("Permutations of the input string:");
                // Iterate through the list and print each permutation
                for (String singlePermutation : allPermutations) {
                    System.out.println(singlePermutation);
                }
            }
        }
    }

    /**
     * Computes all possible permutations of the given string.
     *
     * @param originalString The input string whose permutations need to be generated.
     * @return A list containing all the permutations of the input string.
     */
    public static List<String> computeAllPermutations(String originalString) {
        // List to hold all generated permutations
        List<String> permutationList = new ArrayList<>();

        // Start the recursive permutation generation with an empty prefix
        generatePermutationsRecursive("", originalString, permutationList);

        return permutationList;
    }

    /**
     * Recursively generates all permutations of a given string.
     *
     * @param currentPrefix  The current prefix that forms part of a permutation.
     * @param remainingChars The characters that still need to be used in generating permutations.
     * @param resultStorage  The list where generated permutations are stored.
     */
    private static void generatePermutationsRecursive(String currentPrefix, String remainingChars, List<String> resultStorage) {
        int remainingLength = remainingChars.length();

        // Base case: when no characters remain, add the current prefix to the list of permutations
        if (remainingLength == 0) {
            resultStorage.add(currentPrefix);
        } else {
            // Iterate over the remaining characters
            for (int index = 0; index < remainingLength; index++) {
                // Select the current character and generate new remaining characters by excluding the selected one
                String newPrefix = currentPrefix + remainingChars.charAt(index);
                String newRemainingChars = remainingChars.substring(0, index) + remainingChars.substring(index + 1);

                // Recursive call with updated prefix and remaining characters
                generatePermutationsRecursive(newPrefix, newRemainingChars, resultStorage);
            }
        }
    }
}
