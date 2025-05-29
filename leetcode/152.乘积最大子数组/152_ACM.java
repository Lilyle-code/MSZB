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
        int[] nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] max_nums = new int[nums.length];
        int[] min_nums = new int[nums.length];
        max_nums[0] = min_nums[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            max_nums[i] = Math.max(Math.max(max_nums[i - 1] * nums[i], min_nums[i - 1] * nums[i]), nums[i]);
            min_nums[i] = Math.min(Math.min(max_nums[i - 1] * nums[i], min_nums[i - 1] * nums[i]), nums[i]);
        }
        System.out.println(Arrays.stream(max_nums).max().getAsInt());
    }
}
