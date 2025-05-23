package com.nowcoder;

import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        LinkedList<Integer> cur_num = new LinkedList<>();
        LinkedList<String> cur_list = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '['){
                cur_num.add(num);
                cur_list.add(res.toString());
                num = 0;
                res = new StringBuilder();
            }else if(s.charAt(i) == ']'){
                StringBuilder tmp = new StringBuilder();
                int cnt = cur_num.removeLast();
                for(int j = 0; j < cnt; j++){
                    tmp.append(res);
                }
                res = new StringBuilder(cur_list.removeLast() + tmp);
            }else if(s.charAt(i) <= '9' && s.charAt(i) >= '0') num = num*10 + Integer.parseInt(s.charAt(i) + "");
            else res.append(s.charAt(i));
        }
        System.out.println(res.toString());
    }
}
