package com.nowcoder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        int ans = findCircleNum(matrix);
        System.out.println(ans);
    }
    private static int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        boolean[] visited = new boolean[row];
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < row; i++){
            if(!visited[i]){
                visited[i] = true;
                cnt++;
                queue.offer(i);
                while(!queue.isEmpty()){
                    int v = queue.poll();
                    for(int j = 0; j < row; j++){
                        if(isConnected[v][j] == 1 && !visited[j]){
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}