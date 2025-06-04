package com.nowcoder;

import javax.sound.sampled.EnumControl;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Main {
    private static int[][] cache;
    private static char[] ch;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = in.nextInt();
        if(nums.length == 0 || k == 0){
            System.out.println(new int[0]);
            return;
        }
        Deque<Integer> slide = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        //构建窗口
        for(int i = 0; i < k; i++){
            while(!slide.isEmpty() && slide.getLast() < nums[i]){
                slide.removeLast();
            }
            slide.addLast(nums[i]);
        }
        res[0] = slide.getFirst();
        for(int i = k; i < nums.length; i++){
            if(slide.getFirst() == nums[i - k]){
                slide.removeFirst();
            }
            while(!slide.isEmpty() && nums[i] > slide.getLast()){
                slide.pollLast();
            }
            slide.addLast(nums[i]);
            res[i - k + 1] = slide.getFirst();
        }
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
