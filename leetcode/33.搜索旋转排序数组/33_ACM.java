package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = in.nextInt();
        }
        int target = in.nextInt();
        int left = 0, right = len - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                System.out.println(mid);
                return;
            }
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]) right = mid - 1;
                else left = mid + 1;
            }else{
                if(target >= nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        System.out.println(-1);
    }
}
