package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Main {
    private static int[][] cache;
    private static int[] nums;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = Arrays.stream(nums).sum();
        if(target % 2 == 1){
            System.out.println(false);
            return;
        }
        cache = new int[nums.length][target / 2 + 1];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        int ans = dfs(nums.length - 1, target / 2);
        if(ans == 1) System.out.println(true);
        else System.out.println(false);
    }
    private static int dfs(int i, int target){
        if(i < 0) return target == 0 ? 1 : 0;
        if(cache[i][target] != -1) return cache[i][target];
        if(target >= nums[i]) return cache[i][target] = Math.max(dfs(i - 1, target - nums[i]), dfs(i - 1, target));
        return dfs(i - 1, target) ;
    }
}
