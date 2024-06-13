package edu.escuelaing.arsw.countlines;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineCounter {

    private FileProcessor fileProcessor;
    private DirectoryProcessor directoryProcessor;

    public LineCounter(FileProcessor fileProcessor, DirectoryProcessor directoryProcessor) {
        this.fileProcessor = fileProcessor;
        this.directoryProcessor = directoryProcessor;
    }

    public int countLines(File fileOrDir, String mode) throws IOException {
        int totalLines = 0;
        List<File> files;
        if (fileOrDir.isDirectory()) {
            files = directoryProcessor.findJavaFiles(fileOrDir);
        } else {
            files = new ArrayList<>();
            files.add(fileOrDir);
        }

        for (File file : files) {
            if ("phy".equalsIgnoreCase(mode)) {
                totalLines += fileProcessor.countPhysicalLines(file);
            } else if ("loc".equalsIgnoreCase(mode)) {
                totalLines += fileProcessor.countLogicalLines(file);
            }
        }
        return totalLines;
    }
}

