package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Main {
    private static int[] nums;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = in.nextInt();
        System.out.println(findTargetSumWays(nums,target));
    }
    private static int findTargetSumWays(int[] nums, int target) {
        target = abs(target) + Arrays.stream(nums).sum();
        if(target % 2 == 1) return 0;
        return dfs(nums.length - 1, target / 2);
    }
    private static int dfs(int i, int target) {
        if(i < 0) {
            if(target == 0) return 1;
            else return 0;
        }
        if(target < nums[i]) return dfs(i - 1, target);
        return dfs(i - 1, target) + dfs(i - 1, target - nums[i]);
    }
}
