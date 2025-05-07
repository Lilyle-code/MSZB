package com.nowcoder;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] grid = new int[row][col];
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(numIsland(grid));
    }
    public static int numIsland(int[][] grid){
        int num = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i , j);
                    num++;
                }
            }
        }
        return num;
    }
    public static void dfs(int[][] grid, int row, int col){
        if(row <0 || row >= grid.length || col < 0 ||col >= grid[0].length || grid[row][col] == 0) return;
        grid[row][col] = 0;
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
