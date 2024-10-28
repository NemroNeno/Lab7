package lab7;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GeneratePermutationTest {
    private GeneratePermutation generatePermutationInstance;

    @Before
    public void setUp() {
        // Initialize an instance of the GeneratePermutation class before each test
        generatePermutationInstance = new GeneratePermutation();
    }

    @Test
    public void testPermutationsForNonEmptyString() {
        // Test input: A string with distinct characters
        String testInput = "nab";
        
        // Generate permutations using the class method
        List<String> generatedPermutations = generatePermutationInstance.computeAllPermutations(testInput);

        // Define the expected number of permutations (n!)
        int expectedPermutationCount = 6; // 3! = 6 for "abc"
        
        // Verify that the generated permutations have the correct size
        assertEquals(expectedPermutationCount, generatedPermutations.size());
        
        // Verify some expected permutations are present in the result
        assertTrue(generatedPermutations.contains("ban"));
        assertTrue(generatedPermutations.contains("abn"));
        assertTrue(generatedPermutations.contains("bna"));
        assertTrue(generatedPermutations.contains("nba"));
    }

    @Test
    public void testPermutationsForEmptyString() {
        // Test input: An empty string
        String emptyInput = "";

        // Generate permutations using the class method
        List<String> generatedPermutations = generatePermutationInstance.computeAllPermutations(emptyInput);

        // An empty string has only one permutation: the empty string itself
        assertEquals(1, generatedPermutations.size());
        assertTrue(generatedPermutations.contains(""));
    }

    @Test
    public void testPermutationsForSingleCharacter() {
        // Test input: A string with a single character
        String singleCharInput = "a";

        // Generate permutations using the class method
        List<String> generatedPermutations = generatePermutationInstance.computeAllPermutations(singleCharInput);

        // A single character has only one permutation: itself
        assertEquals(1, generatedPermutations.size());
        assertTrue(generatedPermutations.contains("a"));
    }

    @Test
    public void testPermutationsForDuplicateCharacters() {
        // Test input: A string with duplicate characters
        String duplicateCharInput = "aa";

        // Generate permutations using the class method
        List<String> generatedPermutations = generatePermutationInstance.computeAllPermutations(duplicateCharInput);

        // For input "aa", the permutations should be ["aa", "aa"].
        // Even though they are the same, they are considered separate due to positional variance.
        assertEquals(2, generatedPermutations.size());
        assertTrue(generatedPermutations.contains("aa"));
    }
}
