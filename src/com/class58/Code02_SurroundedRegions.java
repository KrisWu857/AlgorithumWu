package com.class58;

public class Code02_SurroundedRegions {
    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int j = 0; j < m; j++) {
            //0行和n -1 行的遇到0就去感染

            if (board[0][j] == '0') {
                dfs(board, n, m, 0, j);
            }
            if (board[n - 1][j] == '0') {
                dfs(board, n, m, n - 1, j);
            }
        }
        // 1 ~ n - 2 行的去感染
        for (int i = 1; i < n - 1; i++) { // 从行上来说
            if (board[i][0] == '0') {
                dfs(board, n, m, i, 0);
            }
            if (board[i][m - 1] == '0') {
                dfs(board, n, m, i, m - 1);
            }
        }

        for (int i = 0; i < n; i++) { // 遍历一遍整个矩阵
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '0') { // 被X完全围绕的O 全部换成X
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'F') { //感染过程中,边界处的O
                    board[i][j] = '0';
                }
            }
        }
    }

    public static void dfs(char[][] board, int n, int m, int i, int j) {
        if (i < 0 || i == n || j < 0  || j == m || board[i][j] != '0') {  // 越界就退出,或者不是O也退出
            return;
        }
        board[i][j] = 'F';  // 是O, 把他改成F
        dfs(board, n, m, i + 1, j);
        dfs(board, n, m, i - 1, j);
        dfs(board, n, m, i, j + 1);
        dfs(board, n, m, i, j - 1);
    }
}


