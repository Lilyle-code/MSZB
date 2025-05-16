package com.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        int round, len;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer token = new StreamTokenizer(br);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        while(token.nextToken() != StreamTokenizer.TT_EOF){
            round = (int) token.nval;
            for(int i = 0; i<round; i++){
                token.nextToken();
                len = (int) token.nval;
                TreeMap<Integer, Integer> nums = new TreeMap<>();
                int positive = 0, negative = 0;
                for(int j = 0; j<len; j++){
                    token.nextToken();
                    nums.put((int)token.nval, j);
                }
                List<Integer> path = new ArrayList<Integer>();
                for(int value : nums.values()){
                    path.add(value);
                }
                for(int j = 1; j < len; j++){
                    if(path.get(j - 1) > path.get(j)){
                        negative++;
                    }else{
                        positive++;
                    }
                }
                pw.println(positive + " " + negative);
            }
        }
        pw.flush();
        pw.close();
    }
}
