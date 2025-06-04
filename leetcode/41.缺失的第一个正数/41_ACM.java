package com.nowcoder;

import javax.sound.sampled.EnumControl;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int position = nums[i] - 1;
            if(position >= 0  && position < nums.length){
                int tmp = nums[i];
                nums[i] = nums[position];
                nums[position] = tmp;
            }
        }
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                res = i + 1;
                break;
            }
        }
        if(res == -1){
            System.out.println(nums.length + 1);
        }else{
            System.out.println(res);
        }
    }
}
