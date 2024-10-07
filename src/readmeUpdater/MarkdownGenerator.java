package readmeUpdater;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Shangjie (Henry) Zheng
 *
 */
public class MarkdownGenerator {

    private static final String README_FILE = "README.md";
    private static final String BASE_PACKAGE = "com.henry.leetcode.problems";

    public void getPackageAndUpdateReadme() throws IOException {
        int numProblem = 0;
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the package name (e.g., oct_05_24)
        System.out.print("Enter package name >> ");
        String packageName = scanner.nextLine();

        // Get the package path string.
        String packagePath = BASE_PACKAGE + "." + packageName;
        packagePath = packagePath.replace(".", "/");

        // Assuming the package contains one or more Java problem files
        File packageDir = new File("src/" + packagePath);

        // List all Java files in the package
        String[] listOfFiles = packageDir.list();

        if (listOfFiles != null) {
            for (String fileName : listOfFiles) {
                if (!fileName.endsWith(".java")) { continue; }
                File javaFile = new File(packageDir, fileName);

                // Extract the problem from the file.
                Problem problem = extractFromFile(javaFile);

                if (problem != null) {
                    int nextProbNo = getNextProblemNo();
                    appendToReadme(problem, nextProbNo);
                    numProblem++;
                }
            }
        } else {
            System.out.println("No files found in the package directory");
        }

        System.out.println("README.md updated successfully!");
        System.out.println("--------------------------------");
        System.out.println("Problems added today: " + numProblem);
        System.out.println("Total problems added: " + (getNextProblemNo() - 1));
    }

    private Problem extractFromFile(File javaFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(javaFile));
        String line;
        String problemId = null,
                problemName = null,
                difficulty = null,
                topics = null,
                date = null,
                notes = null;

        // Read the Java file and look for the tags in the docstring
        while ((line = reader.readLine()) != null) {
            if (line.contains("@problemId")) {
                problemId = line.split("@problemId")[1].trim();
            } else if (line.contains("@problemName")) {
                problemName = line.split("@problemName")[1].trim();
            } else if (line.contains("@difficulty")) {
                difficulty = line.split("@difficulty")[1].trim();
            } else if (line.contains("@topics")) {
                topics = line.split("@topics")[1].trim();
            } else if (line.contains("@date")) {
                date = line.split("@date")[1].trim();
            } else if (line.contains("@Notes")) {
                String[] lineTokens = line.split("@Notes");
                if (lineTokens.length > 1) {
                    notes = lineTokens[1].trim();
                }
            }
        }

        reader.close();

        // Check if all necessary details are extracted
        if (problemId == null
                || problemName == null
                || difficulty == null) {
            System.err.println("Error: Failed to extract problem metadata from " + javaFile.getName());
            return null;
        }

        // Split the topics string by commas and trim extra spaces.
        List<String> topicList = new ArrayList<>();
        if (topics != null) {
            topicList = Arrays.asList(topics.split("\\s*,\\s*"));
        }

        return new Problem(problemId, problemName, difficulty, date, notes, topicList);
    }

    /**
     * Prompt user to enter information related to the problem being
     * added to README.md
     *
     * @throws IOException if an error occurs during `addProblem()` or
     * its sub-steps
     *
     */
    public void promptUser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean doContinue = true;

        while (doContinue) {
            try {
                int problemNo = getNextProblemNo();
                System.out.println("[Problem " + problemNo + "]--------------------");
                this.addProblem(scanner, problemNo);

                System.out.print("Add more problem? (Y/N) >> ");
                String userInput = scanner.nextLine().trim();

                if (userInput.equalsIgnoreCase("N")) { doContinue = false; }
            } catch (IOException e) {
                System.err.println("Error appending to README.md: " + e.getMessage());
                doContinue = false;
            }
        }

        scanner.close();
        System.out.println("Exiting the program...");
    }

    /**
     * Prompts the user for problem details through the console,
     * creates a Problem object with the user's input, and appends
     * it to the README.md file.
     *
     * @param scanner scans system input
     *
     * @throws IOException if an error occurs while appending the problem to the README.md
     *
     */
    private void addProblem(Scanner scanner, int problemNo) throws IOException {

        // Prompt user for problem details
        System.out.print("Enter Problem ID: ");
        String problemId = scanner.nextLine();

        System.out.print("Enter Problem Name: ");
        String problemName = scanner.nextLine();

        System.out.print("Enter Difficulty [Easy, Medium, Hard]: ");
        String difficulty = scanner.nextLine();

        System.out.print("Enter Topics (comma separated): ");
        String topicsInput = scanner.nextLine();
        List<String> topics = Arrays.asList(topicsInput.split(","));

        System.out.print("Enter Date (MM/DD/YYYY): ");
        String date = scanner.nextLine();

        System.out.print("Enter Notes: ");
        String note = scanner.nextLine();

        // Create Problem object with user inputs
        Problem newProblem = new Problem(problemId,
                                            problemName,
                                            difficulty,
                                            date,
                                            note,
                                            topics);

        // Append the new problem to the README
        this.appendToReadme(newProblem, problemNo);

        System.out.println("Problem added successfully!");
    }

    /**
     * Append the problem markdown row to README.md
     *
     * @param problem the problem object contains required
     *                data fields and methods
     *
     * @throws IOException if capture I/O errors
     *
     */
    private void appendToReadme(Problem problem, int problemNo) throws IOException {

        String newProblemRow = String.format("| %d %s", problemNo, problem.toMarkdownRow());

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(README_FILE, true))) {
            writer.write(newProblemRow);
        }

        // Print system notice
        System.out.println("Append problem #" + problem.getProblemId() + " successfully!");
    }

    /**
     * Reads the last line of the README file to determine the last problem count.
     *
     * @return the next problem count (incremented by 1)
     *
     * @throws IOException if there's an error reading the file
     *
     */
    private int getNextProblemNo() throws IOException {

        int lastCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(README_FILE))) {
            String line;
            String lastLine = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("|")) { lastLine = line; }
            }

            if (lastLine != null) {
                String[] columns = lastLine.split("\\|");
                if (columns.length > 1) {
                    lastCount = Integer.parseInt(columns[1].trim());
                }
            }
        }

        return lastCount + 1;
    }
}
