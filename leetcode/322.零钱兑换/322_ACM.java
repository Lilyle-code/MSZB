package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Main {
    private static int[] coins;
    private static int[][] cache;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        coins = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int amount = in.nextInt();
        cache = new int[coins.length][amount + 1];
        for(int[] c: cache){
            Arrays.fill(c,-1);
        }
        int ans = dfs(coins.length - 1, amount);
        if(ans < Integer.MAX_VALUE / 2) System.out.println(ans);
        else System.out.println(-1);
    }
    private static int dfs(int i, int amount){
        if (i < 0) {
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE / 2;
        }
        if(cache[i][amount] != -1) return cache[i][amount];
        if(amount < coins[i]) return cache[i][amount] = dfs(i - 1, amount);
        return cache[i][amount] = Math.min(dfs(i - 1, amount), dfs(i, amount - coins[i]) + 1);
    }
}
