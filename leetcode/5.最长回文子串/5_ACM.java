package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Main {
    private static int[][] cache;
    private static char[] ch;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        cache = new int[s.length()][s.length()];
        int maxLen = 1, start = 0, end = 0;
        for(int i = 1; i < s.length(); i++){
            for(int j = 0; j < i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || cache[i - 1][j + 1] == 1)){
                    cache[i][j] = 1;
                }
                if(cache[i][j] == 1 && maxLen < i - j + 1){
                    maxLen = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        System.out.println(s.substring(start, end + 1));
    }
}
