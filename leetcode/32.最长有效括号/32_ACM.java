package com.nowcoder;

import javax.sound.sampled.EnumControl;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Main {
    private static String s;
    private static int[] cache;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        cache = new int[s.length()];
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    cache[i] = (i - 2 >= 0 ? cache[i - 2] : 0) + 2;
                }else if(i - cache[i - 1] - 1 >= 0 && s.charAt(i - cache[i - 1] - 1) == '('){
                    cache[i] = cache[i - 1] + (i - cache[i - 1] >= 2 ? cache[i - cache[i - 1] - 2] : 0) + 2;
                }
            }
            res = Math.max(res, cache[i]);
        }
        System.out.println(res);
    }
}
