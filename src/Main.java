import readmeUpdater.MarkdownGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        MarkdownGenerator generator = new MarkdownGenerator();

        generator.getPackageAndUpdateReadme();

        System.out.println();
        System.out.println("Press \"Enter\" to exit...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();  // Wait for the user to press Enter
    }
}
