package com.archihalder.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// utility class
public final class InputReader {
    private InputReader() {
    }

    public static List<String> readLines(String year, String day, boolean useSampleInput) {
        String rootInputFilePath = "src/main/resources/";
        String typeOfInput = useSampleInput ? "sample-inputs/" : "inputs/";
        String filePath = rootInputFilePath + typeOfInput + year + "/day" + day + "-input.txt";
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read: " + filePath, e);
        }
    }
}
