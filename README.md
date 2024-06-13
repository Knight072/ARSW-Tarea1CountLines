# Count Lines of Code

A command-line program to count the lines of code in Java source files. This program can count physical lines or logical lines, excluding comments and empty lines.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Development](#development)
- [Testing](#testing)
- [Productivity](#productivity)
- [Class Diagram](#classDiagram)

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/CountLines.git
    cd CountLines
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Usage

To count lines of code, run the following command:

```bash
java -cp target/CountLines-1.0-SNAPSHOT.jar edu.escuelaing.arsw.countlines.Main <phy|loc> <file or directory>
```

## Testing

Run the tests using Maven:
```bash
mvn test
```

## Productivity

    The development of this project took approximately 2 hours, with a total of 246 LOC, resulting in a productivity of 123 LOC/h.

## Title

LOC Counting

## Author

Daniel Felipe Rojas Hernández

## Date

2024-06-12

## Class Diagram

```plaintext
+------------------+
|    Main          |
+------------------+
| - main(args: String[]) |
+------------------+

+------------------------+
|   LineCounter          |
+------------------------+
| - fileProcessor: FileProcessor     |
| - directoryProcessor: DirectoryProcessor  |
+------------------------+
| + LineCounter(fileProcessor: FileProcessor, directoryProcessor: DirectoryProcessor) |
| + countLines(fileOrDir: File, mode: String): int |
+------------------------+

+------------------------+
|   FileProcessor        |
+------------------------+
| + countPhysicalLines(file: File): int |
| + countLogicalLines(file: File): int  |
+------------------------+

+------------------------+
|  DirectoryProcessor    |
+------------------------+
| + findJavaFiles(root: File): List<File> |
+------------------------+
| - findJavaFilesRecursively(file: File, javaFiles: List<File>): void |
+------------------------+

Description of Class Diagram
    1. Main: The entry point of the program. It contains the main method, which parses command-line arguments and initializes the necessary components.
    2. LineCounter: Coordinates the counting of lines. Uses instances of FileProcessor and DirectoryProcessor to perform its tasks.
        - fileProcessor: An instance of FileProcessor used to count lines in a single file.
        - directoryProcessor: An instance of DirectoryProcessor used to find all .java files in a directory.
        - countLines(fileOrDir: File, mode: String): This method takes a file or directory and a mode (phy or loc) and returns the total number of lines based on the mode.
    3. FileProcessor: Handles the logic for counting lines in individual files.
        - countPhysicalLines(file: File): Counts the total number of lines in a file.
        - countLogicalLines(file: File): Counts the number of logical lines (ignoring comments and empty lines).
    4. DirectoryProcessor: Handles the logic for finding .java files within directories.
        - findJavaFiles(root: File): Finds all .java files starting from the root directory.
        - findJavaFilesRecursively(file: File, javaFiles: List<File>): A recursive helper method to find .java files.
