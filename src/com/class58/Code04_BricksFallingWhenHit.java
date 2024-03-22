package com.class58;

public class Code04_BricksFallingWhenHit {
    //https://leetcode.cn/problems/bricks-falling-when-hit/description/
    public static int n , m ;

    public static int[][] grid ;
    // 从(i,j)格子出发,遇到1就感染成2
    // 统计新增了几个2!
    public static  int   dfs( int i ,int j ) {
        if ( i < 0 || i == n  || j < 0 || j == m || grid[i][j] != 1) {
            return 0 ;
        }
        grid[i][j] = 2;
         return 1 + dfs(i + 1 , j ) + dfs(i , j + 1 ) + dfs(i - 1  , j  ) + dfs(i, j -  1 );
    }

    public  static boolean worth(int i, int j ) {
        return grid[i][j] == 1   // 自己得是1
                &&
                (i == 0   // 自己得在天花板
                        // 上下左右四个方向必须得有2
                || (i > 0 && grid[ i - 1 ][j] == 2 )
                || (i < n - 1 && grid[i + 1 ][j] == 2 )
                || (j > 0 && grid[i][j - 1 ] == 2 )
                || (j < m - 1 && grid[i][j + 1 ] == 2 ));
    }

    public static int[] hitBricks(int[][] g ,int[][] h ) {
        grid = g ;
        n = g.length;
        m = g[0].length;
        int[] ans = new int[h.length];
        if (n == 1 ) {  // 如果只有一行,就不会掉落
            return  ans ;
        }
        for (int[] hit : h ){   // 所有炮弹的值减个1
            grid[hit[0]][hit[1]]-- ;
        }
        for (int i = 0 ; i < m ; i++) { // 天花板洪水填充
            dfs(0,i);
        }
        // 时光倒流,处理炮弹
        for (int i = h.length - 1 , row , col ;  i >= 0 ; i--) {
            row = h[i][0]; // 炮弹的行
            col = h[i][1]; // 炮弹的列
            grid[row][col]++;
            if (worth(row, col)) { // 看看是否值得去遍历
                ans[i] = dfs(row, col) - 1; // 自己打的是碎掉了,不能算上去
            }
        }
        return ans ;
    }
}
