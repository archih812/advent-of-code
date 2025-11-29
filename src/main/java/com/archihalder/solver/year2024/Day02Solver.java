package com.archihalder.solver.year2024;

import com.archihalder.solver.Solver;

import java.util.Arrays;
import java.util.List;

public class Day02Solver implements Solver {
    boolean isLevelSafe(int[] levels) {
        boolean isIncreasing = levels[0] < levels[levels.length - 1];
        boolean isSafe = true;

        if(isIncreasing) {
            for(int i = 1; i < levels.length; i++) {
                int diff = levels[i] - levels[i - 1];
                if(!(diff >= 1 && diff <= 3)) {
                    isSafe = false;
                    break;
                }
            }
        } else {
            for (int i = levels.length - 2; i >= 0; i--) {
                int diff = levels[i] - levels[i + 1];
                if (!(diff >= 1 && diff <= 3)) {
                    isSafe = false;
                    break;
                }
            }
        }
        return isSafe;
    }

    @Override
    public String solvePart1(List<String> lines) {
        int count = 0;
        for(String line: lines) {
            int[] levels = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            count += isLevelSafe(levels) ? 1 : 0;
        }
        return Integer.toString(count);
    }

    @Override
    public String solvePart2(List<String> lines) {
        int count = 0;
        for(String line: lines) {
            int[] levels = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = levels.length;
            boolean isSafe = false;

            if(isLevelSafe(levels)) {
                isSafe = true;
            } else {
                for(int i = 0; i < n; i++) {
                    int[] x = new int[n - 1];
                    System.arraycopy(levels, 0, x, 0, i);
                    System.arraycopy(levels, i + 1, x, i, n - i - 1);

//                    for(int k: x) {
//                        System.out.print(k + " ");
//                    }
                    if(isLevelSafe(x)) {
//                        System.out.println(" -> Safe");
                        isSafe = true;
                        break;
                    } else {
//                        System.out.println(" -> Unsafe");
                    }
                }
            }

//            System.out.println("\n");
            count += isSafe ? 1 : 0;
        }
        return Integer.toString(count);
    }
}
