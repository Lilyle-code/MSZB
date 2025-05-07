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
        com.nowcoder.Unionfind uf = new com.nowcoder.Unionfind(row);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < row; j++){
                if(isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.size;
    }
}

class Unionfind{
    int[] root; //用于存储当前节点的父节点
    int size;
    public Unionfind(int n) {
        root = new int[n];
        //初始时，并查集的父节点是它们自己
        for(int i = 0; i < n; i++){
            root[i] = i;
        }
        size = n;
    }
    public int find(int x) {
        if(root[x] == x) return x;
        return root[x] = find(root[x]);
    }
    public void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        if(root_x != root_y){
            root[root_x] = root_y;
            size--;
        }
    }
}


