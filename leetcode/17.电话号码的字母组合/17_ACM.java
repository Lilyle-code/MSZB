package com.nowcoder;

import java.awt.*;
import java.util.*;
import java.util.List;

import com.nowcoder.TreeNode;

import com.nowcoder.ListNode;

public class Main {
    private static String[] telephone = new String[]{"", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String digits = in.nextLine();
//        System.out.println(digits);
        for(int i = 0; i < digits.length(); i++){
            dfs(digits, 0, "");
        }
        System.out.println(res);
    }
    public static void dfs(String digits,int curposition, String sub){
        if(digits.length() == curposition){
            res.add(sub);
            return;
        }
        String character = telephone[digits.charAt(curposition) - '0'];
        for(int j = 0; j < character.length(); j++){
            dfs(digits,curposition + 1,
                    sub + character.charAt(j));
        }
    }
}
