package com.nowcoder;

import java.awt.*;
import java.util.*;
import java.util.List;

import com.nowcoder.TreeNode;

import com.nowcoder.ListNode;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = in.nextInt();
        }
        int k = (in.nextInt()) % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
