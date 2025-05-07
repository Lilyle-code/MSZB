package com.nowcoder;

import java.awt.*;
import java.util.*;
import java.util.List;

import com.nowcoder.TreeNode;

import com.nowcoder.ListNode;

public class Main {
    private static int[] nums;
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len  = in.nextInt();
        nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = in.nextInt();
        }
        dfs(0);
        System.out.println(res);
    }
    public static void dfs(int curposition){
        if(curposition == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(curposition + 1);
        path.add(nums[curposition]);
        dfs(curposition + 1);
        path.remove(path.size() - 1);
    }
}
