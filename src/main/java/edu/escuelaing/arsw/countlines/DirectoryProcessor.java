package edu.escuelaing.arsw.countlines;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryProcessor {

    public List<File> findJavaFiles(File root) {
        List<File> javaFiles = new ArrayList<>();
        findJavaFilesRecursively(root, javaFiles);
        return javaFiles;
    }

    private void findJavaFilesRecursively(File file, List<File> javaFiles) {
        if (file.isFile() && file.getName().endsWith(".java")) {
            javaFiles.add(file);
        } else if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                findJavaFilesRecursively(child, javaFiles);
            }
        }
    }
}
