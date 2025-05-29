package com.nowcoder;

import java.awt.*;
import java.util.*;
import java.util.List;

import com.nowcoder.TreeNode;

import com.nowcoder.ListNode;

public class Main {
    private static Set<Integer> visited = new HashSet<>();
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        permuteHelper(nums);
        System.out.print(res);
    }
    public static void permuteHelper(int[] nums) {
        if(nums.length == path.size()){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited.contains(nums[i])) continue;
            visited.add(nums[i]);
            path.add(nums[i]);
            permuteHelper(nums);
            visited.remove(nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
