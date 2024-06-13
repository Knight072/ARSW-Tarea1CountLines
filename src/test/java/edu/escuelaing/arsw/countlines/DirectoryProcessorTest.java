package edu.escuelaing.arsw.countlines;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DirectoryProcessorTest {

    @Test
    public void testFindJavaFiles() throws IOException {
        File tempDir = createTestDirectory();
        FileProcessor fileProcessor = new FileProcessor();
        DirectoryProcessor directoryProcessor = new DirectoryProcessor();
        List<File> javaFiles = directoryProcessor.findJavaFiles(tempDir);
        assertEquals(2, javaFiles.size());
    }

    private File createTestDirectory() throws IOException {
        File tempDir = File.createTempFile("tempDir", "");
        tempDir.delete();
        tempDir.mkdir();

        File file1 = new File(tempDir, "Test1.java");
        try (FileWriter writer = new FileWriter(file1)) {
            writer.write("public class Test1 {}");
        }

        File file2 = new File(tempDir, "Test2.java");
        try (FileWriter writer = new FileWriter(file2)) {
            writer.write("public class Test2 {}");
        }

        File file3 = new File(tempDir, "NotAJavaFile.txt");
        try (FileWriter writer = new FileWriter(file3)) {
            writer.write("This is not a Java file.");
        }

        return tempDir;
    }
}

