package edu.escuelaing.arsw.countlines;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main <phy|loc> <file or directory>");
            return;
        }

        String mode = args[0];
        File fileOrDir = new File(args[1]);

        FileProcessor fileProcessor = new FileProcessor();
        DirectoryProcessor directoryProcessor = new DirectoryProcessor();
        LineCounter lineCounter = new LineCounter(fileProcessor, directoryProcessor);

        try {
            int totalLines = lineCounter.countLines(fileOrDir, mode);
            if ("phy".equalsIgnoreCase(mode)) {
                System.out.println("Total Physical lines: " + totalLines);
            } else if ("loc".equalsIgnoreCase(mode)) {
                System.out.println("Total Lines of Code: " + totalLines);
            } else {
                System.out.println("Unknown mode: " + mode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


