package com.archihalder;

import com.archihalder.solver.year2024.Day02Solver;
import com.archihalder.util.InputReader;

import java.util.List;

public class Main {
    static void main(String[] args) {
        Day02Solver solver = new Day02Solver();
        List<String> input = InputReader.readLines(2024, 2, false);
        String part1 = solver.solvePart1(input);
        String part2 = solver.solvePart2(input);
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}
