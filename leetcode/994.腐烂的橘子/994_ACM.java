package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        Deque<int[]> queue = new LinkedList<>();
        int [][] grid = new int[row][col];
        int freshornge = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int cur = in.nextInt();
                grid[i][j] = cur;
                if(cur == 2){ queue.offer(new int[]{i, j});}
                if(cur == 1) freshornge++;
            }
        }
        int res = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            int flag = 0;
            for(int i = 0; i < len; i++){
                int[] cur = queue.poll();
                if((cur[0]- 1) >= 0 && grid[cur[0]-1][cur[1]] == 1){
                    queue.offer(new int[]{cur[0] - 1, cur[1]});
                    grid[cur[0]-1][cur[1]] = 2;
                    freshornge--;
                    flag = 1;
                }
                if((cur[1] - 1) >= 0 && grid[cur[0]][cur[1] - 1] == 1){
                    queue.offer(new int[]{cur[0], cur[1] - 1});
                    grid[cur[0]][cur[1] - 1] = 2;
                    freshornge--;
                    flag = 1;
                }
                if((cur[0] + 1) < grid.length && grid[cur[0] + 1][cur[1]] == 1){
                    queue.offer(new int[]{cur[0] + 1, cur[1]});
                    grid[cur[0] + 1][cur[1]] = 2;
                    freshornge--;
                    flag = 1;
                }
                if((cur[1] + 1) < grid[0].length && grid[cur[0]][cur[1] + 1] == 1){
                    queue.offer(new int[]{cur[0], cur[1] + 1});
                    grid[cur[0]][cur[1] + 1] = 2;
                    freshornge--;
                    flag = 1;
                }
            }
            if(flag == 1) res++;
        }
        if(freshornge > 0){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }
}
