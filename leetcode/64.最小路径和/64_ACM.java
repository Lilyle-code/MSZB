package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Main {
    private static int[][] cache;
    private static int[][] grid;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = in.nextInt();
            }
        }
        cache = new int[m][n];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        System.out.println(dfs(m - 1, n - 1));
    }
    private static int dfs(int i, int j){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(cache[i][j] != -1) return cache[i][j];
        if(i == 0 && j == 0) return cache[i][j] = grid[i][j];
        return cache[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - 1)) + grid[i][j];
    }
}
