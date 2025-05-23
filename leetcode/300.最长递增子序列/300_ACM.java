package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Main {
    private static int[] cache;
    private static int[] nums;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        cache = new int[nums.length];
//        Arrays.fill(cache, -1);
        System.out.println(dfs(nums.length - 1));
    }
    private static int dfs(int i){
        if(cache[i] != 0) return cache[i];
        for(int j = 0; j < i; j++){
            if(nums[j] < nums[i]) cache[i] = Math.max(cache[i], dfs(j));
        }
        return ++cache[i];
    }
}
