package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static java.lang.Math.scalb;

public class Main {
    private static int[][] cache;
    private static char[] ch1;
    private static char[] ch2;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String text1 = in.nextLine();
        String text2 = in.nextLine();
        ch1 = text1.toCharArray();
        ch2 = text2.toCharArray();
        cache = new int[text1.length()][text2.length()];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        System.out.println(dfs(text1.length() - 1, text2.length() - 1));
    }
    private static int dfs(int i, int j){
        if(i < 0 || j < 0) return 0;
        if(cache[i][j] != -1) return cache[i][j];
        if(ch1[i] == ch2[j]) return cache[i][j] = dfs(i - 1, j - 1) + 1;
        return cache[i][j] = cache[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
    }
}
