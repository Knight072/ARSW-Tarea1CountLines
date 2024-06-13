# Count Lines of Code

A command-line program to count the lines of code in Java source files. This program can count physical lines or logical lines, excluding comments and empty lines.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Development](#development)
- [Testing](#testing)
- [License](#license)

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
