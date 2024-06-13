package edu.escuelaing.arsw.countlines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    public int countPhysicalLines(File file) throws IOException {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                lines++;
            }
        }
        return lines;
    }

    public int countLogicalLines(File file) throws IOException {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("/*") && !line.endsWith("*/")) {
                    lines++;
                }
            }
        }
        return lines;
    }
}
