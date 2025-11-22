package com.archihalder;

import com.archihalder.solver.year2024.Day01Solver;
import com.archihalder.util.InputReader;

import java.util.List;

public class Main {
    static void main(String[] args) {
        Day01Solver solver = new Day01Solver();
        List<String> input = InputReader.readLines(2024, 10, true);
        String part1 = solver.solvePart1(input);
        String part2 = solver.solvePart2(input);
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}
