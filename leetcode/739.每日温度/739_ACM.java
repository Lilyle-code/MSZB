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
        int[] temperatures  = new int[len];
        for(int i = 0; i < len; i++){
            temperatures [i] = in.nextInt();
        }
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }
        for(int r: res){
            System.out.print(r + " ");
        }
    }
}
