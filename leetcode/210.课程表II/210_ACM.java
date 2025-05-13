package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numCourses = in.nextInt();
        int prerequisitnum = in.nextInt();
        int[][] prerequisites = new int[prerequisitnum][2];
        for(int i = 0; i < prerequisitnum; i++){
            prerequisites[i][0] = in.nextInt();
            prerequisites[i][1] = in.nextInt();
        }
        int[] entry = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            int cur = arr[0];
            int pre = arr[1];
            entry[cur]++;
            adjacency.get(pre).add(cur);
        }
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(entry[i] == 0) queue.add(i);
        }
        int cnt = 0;
        int[] res = new int[numCourses];
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[cnt++] = cur;
//            cnt++;
            List<Integer> list = adjacency.get(cur);
            for(Integer i : list){
                entry[i]--;
                if(entry[i] == 0) queue.add(i);
            }
        }
        if(cnt == numCourses){
            for(int i : res){
                System.out.print(i + " ");
            }
        }
        else System.out.println((new int[0]).toString());
    }
}
