package com.class58;

public class Code01_NumberOfIslands {
    public static void dfs(char[][] board, int i , int j ) {
        if (i <0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != '1'){
            return ;
        }
        //board[i][j] = '1'
        board[i][j] = 0 ;
        dfs(board,i - 1 , j);
        dfs(board,i + 1 , j);
        dfs(board,i  ,j - 1 );
        dfs(board,i , j + 1 );
    }


    //洪水填充的做法
    // board : n * m
    //0(n*m)
    public static int numIslands(char[][]  board) {
        int islands = 0  ;
        for ( int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length ; j++) {
                if (board[i][j] == '1'){
                    islands++;
                    dfs(board,i,j);
                }
            }
        }
        return islands ;
    }

}
