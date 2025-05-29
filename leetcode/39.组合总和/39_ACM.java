package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().trim().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(in.nextLine().trim());
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, target, path, res);
        for(List<Integer> list : res){
            System.out.print(list + " ");
        }
    }
    private static void dfs(int[] nums, int index, int target, List<Integer> path, List<List<Integer>> res) {
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i< nums.length; i++){
            if(target - nums[i] < 0) break;
            path.add(nums[i]);
            dfs(nums, i, target - nums[i], path, res);
            path.remove(path.size()-1);
        }
    }
}



