package lab7;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class fileSearchTests {
    private fileSearch fileSearcher;

    @Before
    public void setUp() {
        // Initialize the fileSearch object before each test
        fileSearcher = new fileSearch();
    }

    @Test
    public void testFileFound() {
        // Provide the directory path and target file name
        String rootDirectoryPath = "C:\\Users";
        String fileNameToSearch = "weasyprint.pdf";

        // Call the searchForFile method
        fileSearcher.searchForFile(new File(rootDirectoryPath), fileNameToSearch);

        // Assert that the file is found
        assertTrue(fileSearcher.isTargetFileFound());
        assertNotNull(fileSearcher.getTargetFileAbsolutePath());
        // Additional check: Verify that the returned file path is correct
        assertTrue(fileSearcher.getTargetFileAbsolutePath().endsWith(fileNameToSearch));
    }

    @Test
    public void testFileNotFound() {
        // Provide the directory path and a non-existent target file name
        String rootDirectoryPath = "src/test/resources";
        String fileNameToSearch = "nonExistentFile.txt";

        // Call the searchForFile method
        fileSearcher.searchForFile(new File(rootDirectoryPath), fileNameToSearch);

        // Assert that the file is not found
        assertFalse(fileSearcher.isTargetFileFound());
        assertNull(fileSearcher.getTargetFileAbsolutePath());
    }
}
