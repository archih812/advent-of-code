package com.archihalder.year2025.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static void main(String[] args) {
        String inputFilePath = "src/main/resources/year2025/day01/main-input.txt";
        List<int[]> inputLines = parseInput(inputFilePath);
        System.out.println("Part 1: " + part1(inputLines));
        System.out.println("Part 2: " + part2(inputLines));
    }

    public static List<int[]> parseInput(String filePath) {
        List<int[]> lines = new ArrayList<>();
        String line = null;
        int direction = 0, rotation = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                line = line.strip();
                direction = line.charAt(0) == 'L' ? -1 : 1;
                rotation = Integer.parseInt(line.substring(1));
                lines.add(new int[]{direction, rotation});
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
        }
        return lines;
    }

    public static int part1(List<int[]> lines) {
        int point = 50;
        int count = 0;
        for (int[] line : lines) {
            point = (point + (line[0] * line[1]) + 100) % 100;
            if (point == 0) count++;
        }
        return count;
    }

    public static int part2(List<int[]> lines) {
        int point = 50;
        int value = 0, zeroPassed = 0;
        int direction = 0, rotation = 0;
        for (int[] line : lines) {
            direction = line[0];
            rotation = line[1];
            zeroPassed += rotation / 100;
            rotation %= 100;
            value = point + (direction * rotation);
            if (point != 0 && (value <= 0 || value >= 100)) zeroPassed++;
            point = (point + (direction * rotation) + 100) % 100;
        }
        return zeroPassed;
    }
}
