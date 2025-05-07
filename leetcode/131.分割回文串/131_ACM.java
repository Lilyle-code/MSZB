package com.nowcoder;

import java.awt.*;
import java.util.*;
import java.util.List;

import com.nowcoder.TreeNode;

import com.nowcoder.ListNode;

public class Main {
    private static List<List<String>> res = new ArrayList<>();
    private static List<String> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(s);
        partitionHelper(s, 0);
        System.out.println(res);
    }
    public static void partitionHelper(String str, int curposition){
        if(curposition == str.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = curposition; i < str.length(); i++){
            String sub = str.substring(curposition, i + 1);
            if(isPalindrome(sub)){
                path.add(sub);
                partitionHelper(str, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String str){
        int left = 0, right= str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
