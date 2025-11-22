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

    public static List<String> readLines(int year, int day, boolean useSampleInput) {
        String typeOfInput = useSampleInput ? "sample-inputs/" : "inputs/";
        String filePath = String.format("src/main/resources/%s/%d/day%02d-input.txt", typeOfInput, year, day);
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read: " + filePath, e);
        }
    }
}
