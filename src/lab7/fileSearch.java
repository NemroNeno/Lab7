package lab7;

import java.io.File;

public class fileSearch {
    // Flag indicating if the target file has been found
    private boolean isTargetFileFound;
    // Holds the absolute path of the found file, if any
    private String targetFileAbsolutePath;

    // Constructor initializes the state of the file search
    public fileSearch() {
        this.isTargetFileFound = false;
        this.targetFileAbsolutePath = null;
    }

    // Returns the status of whether the target file was found
    public boolean isTargetFileFound() {
        return isTargetFileFound;
    }

    // Returns the absolute path of the found file, or null if not found
    public String getTargetFileAbsolutePath() {
        return targetFileAbsolutePath;
    }

    /**
     * Main method to execute the program.
     *
     * @param args Command-line arguments: directory path and target filename.
     */
    public static void main(String[] args) {
        // Validate the input arguments
        if (args.length != 2) {
            System.out.println("Usage: java FileSearch <directory> <filename>");
            System.exit(1); // Exit if arguments are invalid
        }

        // Create an instance of the fileSearch class to perform the search
        fileSearch fileSearcher = new fileSearch();
        String rootDirectoryPath = args[0];
        String fileNameToSearch = args[1];

        // Create a File object representing the directory to be searched
        File rootDirectory = new File(rootDirectoryPath);

        // Check if the provided path is a valid directory
        if (!rootDirectory.exists() || !rootDirectory.isDirectory()) {
            System.out.println("Invalid directory path.");
            System.exit(1); // Exit if the directory path is invalid
        }

        // Initiate the file search starting from the specified root directory
        fileSearcher.searchForFile(rootDirectory, fileNameToSearch);
    }

    /**
     * Recursively searches for the specified file within the given directory and its subdirectories.
     *
     * @param currentDirectory The directory to start the search from.
     * @param targetFileName   The name of the file to search for.
     */
    public void searchForFile(File currentDirectory, String targetFileName) {
        // List all files and subdirectories in the current directory
        File[] directoryContents = currentDirectory.listFiles();

        // Check if the directory is not empty
        if (directoryContents != null) {
            // Iterate through each file or subdirectory in the current directory
            for (File item : directoryContents) {
                // If the item is a directory, search recursively inside it
                if (!item.isDirectory()) {
                	 if (item.getName().equals(targetFileName)) {
                         System.out.println("File found at: " + item.getAbsolutePath());
                         isTargetFileFound = true; // Set the flag to true when the file is found
                         targetFileAbsolutePath = item.getAbsolutePath(); // Store the found file path
                         return; // Stop searching further as the target file is found
                     }
                   
                } else {
                	 searchForFile(item, targetFileName);
                   
                }
            }
        }
    }
}
