package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Main {
    private static int[][] cache;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        cache = new int[m][n];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        System.out.println(dfs(m - 1, n - 1));
    }
    private static int dfs(int i, int j){
        if(i < 0 || i >= cache.length || j < 0 || j >= cache[0].length) return 0;
        if(cache[i][j] != -1) return cache[i][j];
        if(i == 0 && j == 0) return cache[i][j] = 1;
        return cache[i][j] = dfs(i - 1, j) + dfs(i, j - 1);
    }
}
