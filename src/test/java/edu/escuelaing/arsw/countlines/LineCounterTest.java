package edu.escuelaing.arsw.countlines;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LineCounterTest {

    @Test
    public void testCountPhysicalLines() throws IOException {
        File testFile = createTestFile("Line 1\nLine 2\nLine 3\n");
        FileProcessor fileProcessor = new FileProcessor();
        DirectoryProcessor directoryProcessor = new DirectoryProcessor();
        LineCounter lineCounter = new LineCounter(fileProcessor, directoryProcessor);
        assertEquals(3, lineCounter.countLines(testFile, "phy"));
    }

    @Test
    public void testCountLogicalLines() throws IOException {
        File testFile = createTestFile("Line 1\n// Comment\n\nLine 2\n/* Comment */\nLine 3\n");
        FileProcessor fileProcessor = new FileProcessor();
        DirectoryProcessor directoryProcessor = new DirectoryProcessor();
        LineCounter lineCounter = new LineCounter(fileProcessor, directoryProcessor);
        assertEquals(3, lineCounter.countLines(testFile, "loc"));
    }

    private File createTestFile(String content) throws IOException {
        File testFile = File.createTempFile("testFile", ".java");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write(content);
        }
        return testFile;
    }
}

