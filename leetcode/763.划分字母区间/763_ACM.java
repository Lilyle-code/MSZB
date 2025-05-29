package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] lastposition = new int[26];
        for(int i = 0; i < s.length(); i++){
            lastposition[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, lastposition[s.charAt(i) - 'a']);
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        System.out.println(res);
    }
}
