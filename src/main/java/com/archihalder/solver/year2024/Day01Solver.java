package com.archihalder.solver.year2024;

import com.archihalder.solver.Solver;

import java.util.*;

public class Day01Solver implements Solver {
    @Override
    public String solvePart1(List<String> lines) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (String line : lines) {
            String[] values = line.split(" {3}");
            left.add(Integer.parseInt(values[0]));
            right.add(Integer.parseInt(values[1]));
        }

        Collections.sort(left);
        Collections.sort(right);

        long res = 0;
        for (int i = 0; i < left.size(); i++) {
            res += Math.abs(left.get(i) - right.get(i));
        }
        return Long.toString(res);
    }

    @Override
    public String solvePart2(List<String> lines) {
        List<Integer> left = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (String line : lines) {
            String[] values = line.split(" {3}");
            left.add(Integer.parseInt(values[0]));
            int key = Integer.parseInt(values[1]);
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        }

        long res = 0;
        for (Integer val : left) {
            res += (long) val * frequency.getOrDefault(val, 0);
        }
        return Long.toString(res);
    }
}
