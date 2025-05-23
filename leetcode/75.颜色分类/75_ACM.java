package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int slow = 0, fast = 0;
        for(int i = 0; i< nums.length; i++){
            int cur_num = nums[i];
            nums[i] = 2;
            if(cur_num <= 1){
                nums[fast++] = 1;
            }
            if(cur_num == 0){
                nums[slow++] = 0;
            }
        }
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
