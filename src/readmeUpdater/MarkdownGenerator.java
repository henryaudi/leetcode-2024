package readmeUpdater;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        int numProblem = 1;

        while (doContinue) {
            try {
                System.out.println("[Problem " + numProblem++ + "]--------------------");
                this.addProblem(scanner);

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
    private void addProblem(Scanner scanner) throws IOException {

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
        this.appendToReadme(newProblem);

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
    public void appendToReadme(Problem problem) throws IOException {
        String newProblemRow = problem.toMarkdownRow();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(README_FILE, true))) {
            writer.write(newProblemRow);
        }

        // Print system notice
        System.out.println("Append problem #" + problem.getProblemId() + " successfully!");
    }
}
