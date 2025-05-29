package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int i = nums.length - 2;
        while(i >=0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1 , nums.length - 1);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void reverse(int[] nums, int start, int end) {
        if(start >= end || start >= nums.length) return;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
