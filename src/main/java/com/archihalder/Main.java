package com.archihalder;

import com.archihalder.solver.year2024.Day01Solver;
import com.archihalder.util.InputReader;

public class Main {
    static void main(String[] args) {
        Day01Solver solver = new Day01Solver();
        String part1 = solver.solvePart1(InputReader.readLines("2024", "01", false));
        String part2 = solver.solvePart2(InputReader.readLines("2024", "01", false));
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}
