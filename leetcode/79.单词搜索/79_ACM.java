package com.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static char[][] board;
    private static String word;
    private static int[][] record;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] size = Arrays.stream(in.nextLine().trim().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int row = size[0];
        int col = size[1];
        board = new char[row][col];
        record =new int[row][col];
        for(int i = 0; i < row; i++){
            String line = in.nextLine().replace(" ","");
            for(int j = 0; j < col; j++){
                board[i][j] = line.charAt(j);
//                System.out.print(board[i][j] + " ");
            }
        }
        word = in.nextLine();
        System.out.println(word.length());
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(i,j,0)){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
    public static boolean dfs(int row, int col, int pos){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || pos >= word.length() || board[row][col] != word.charAt(pos) || record[row][col] == 1) return false;
        if(pos == word.length() - 1) return true;
        record[row][col] = 1;
        if(dfs(row - 1, col, pos + 1) ||dfs(row, col - 1, pos + 1) ||
                dfs(row + 1, col, pos + 1) || dfs(row, col + 1, pos + 1)){
            return true;
        }
        record[row][col] = 0;
        return false;
    }
}

