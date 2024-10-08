# LeetCode Tracker

[![Author](https://img.shields.io/badge/Author-Shangjie%20Zheng-blue)](mailto:shangjiehz@gmail.com)

This repository contains a **dynamic tracker tool** that I built to automatically update this `README.md` file with new problems . The tool simplifies the process of logging and documenting problems, solutions, and related metadata, such as difficulty and topics covered.

In addition to the tracker tool, this repository includes solutions to [LeetCode problems](#table-of-contents) and algorithm studies that I work on during my free time. 

Each problem is organized into its own folder under the `problems` package, and test cases are stored in the `tests` package. Below is a summary of the problems solved so far.



## Features
- **Automatic Problem Parsing**: Version 2 `ReadmeUpdater.exe` allows you to enter the package name and the program will automatically extract, parse, append-to-readme all in one step (Make sure docstrings are created as specified below).
- **Dynamic Problem Addition**: You can use the `Leetcode2024.exe` (Older version) program to add problems directly to the README table. Each time you run the executable, it prompts you for problem details and appends them to the table automatically.
- **Easy-to-Use Command Line Interface (CLI)**: The program is run from the command line or by double-clicking the `.exe` file, allowing you to enter problem details interactively.

## Usage Instructions

### Updated version 2.0 `ReadmeUpdater.exe`
Simply double click and enter the package name 🚀
1. **Download the `ReadmeUpdater.exe` file**:
   - You can find the `ReadmeUpdater.exe` in the [Releases section](#) of this repository.
2. **Ensure the `README.md` file is in the same directory**:
   - **Important Note**: The `README.md` file must be located in the same directory as the `Leetcode2024.exe` file for the program to update the table properly.
3. **Run the executable**:
   - You can run the program by either:
      - **Double-clicking** the `Leetcode2024.exe` file, or
      - Running it from the command line:
        ```bash
        ./ReadmeUpdater.exe
        ```
4. **Input problem details**:
   - After starting the program, you’ll be prompted to enter the following problem details, simply type in the package name that contains the problems you want to add and hit "Enter":
     ```bash
     Enter package name >> oct_02_24
     ```
5. **‼️IMPORTANT** To make this code work, ensure that your file contains proper docstring, see [Example Docstring for LeetCode Problem](#example-docstring-for-leetcode-problem)
   
### Running the `Leetcode2024.exe` File (Older version)
To dynamically add new Leetcode problems to the table:
1. **Download the `Leetcode2024.exe` file**:
   - You can find the `Leetcode2024.exe` in the [Releases section](#) of this repository.

2. **Ensure the `README.md` file is in the same directory**:
   - **Important Note**: The `README.md` file must be located in the same directory as the `Leetcode2024.exe` file for the program to update the table properly.

3. **Run the executable**:
   - You can run the program by either:
      - **Double-clicking** the `Leetcode2024.exe` file, or
      - Running it from the command line:
        ```bash
        ./Leetcode2024.exe
        ```

4. **Input problem details**:
   - After starting the program, you’ll be prompted to enter the following problem details:
      - Problem ID (from Leetcode)
      - Problem Name
      - Difficulty (Easy, Medium, Hard)
      - Topics (comma-separated list)
      - Date (MM/DD/YYYY)
      - Notes

5. **Automatic Table Update**:
   - After entering the details, the problem will be automatically appended to the existing table in the `README.md` file.
   - You can then view the updated README with the new problem listed.


### Example Docstring for LeetCode Problem

When adding a new LeetCode problem solution, ensure that your Java file contains a properly formatted docstring to help the program extract the necessary metadata. Below is an example of how the docstring should look:

```java
/**
 * LeetCode Problem 409: Longest Palindrome
 * 
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 * Letters are case-sensitive, for example, "Aa" is not considered a palindrome.
 * 
 * @problemId 409
 * @problemName Longest Palindrome
 * @difficulty Easy
 * @topics String, Hash Map, Greedy
 * @date 10/06/2024
 * @Notes Optimized by using an array instead of HashMap to track letter frequencies.
 */
public class Problem409 {
    // Your code implementation here
}
```


## Table of Contents
| No. | LeetCode ID | Problem Name       | Difficulty | Topics                     | Date       | Notes                       |
|-----|-------------|--------------------|------------|----------------------------|------------|-----------------------------|
| 1   | 001         | Two Sum             | Easy      | Hash Map, Array            | 10/02/2024 | 😛                         |
| 2 | 121 | Best Time to Buy and Sell Stock | Easy | Array, Dynamic Programming | 10/02/2024 |  |
| 3 | 714 | Best Time to Buy and Sell Stock with Transaction Fee | Medium | Dynamic Programming        | 10/02/2024 | Used 2 arrays to represent the buy-hold states |
| 4 | 409 | Longest Palindrome | Easy | Character, Array           | 10/05/2024 | Used an array to represent the number of appearance rather than HashMap to enhance time and space complexity. Notice that in ASCII code, A-Z is 65 - 90, and a-z is 97 - 122 || 5 | 409 | Longest Palindrome | Easy | BFS, DFS, Dynamic Programming | 10/05/2024 | Used an array to represent the number of appearance rather than HashMap to enhance time and space complexity. Notice that in ASCII code, A-Z is 65 - 90, and a-z is 97 - 122 |
