package com.class58;

public class Code03_MakingLargeIsLand {
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int id = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, n, m, i, j, id++);
                }
            }
        }

        int[] size = new int[id];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 1) {
                    ans = Math.max(ans, ++size[grid[i][j]]); // 先把ans设置成最多1的岛,然后看看能否变的更大
                }
            }
        }
        // 讨论所有的0 ,变成1 , 能带来的最大岛的大小
        boolean[] visited = new boolean[id];
        int up, down, left, right, merge;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    //把四个方向岛的编号拿过来
                    up = i > 0 ? grid[i - 1][j] : 0;
                    down = i + 1 < n ? grid[i + 1][j] : 0;
                    left = j > 0 ? grid[i][j - 1] : 0;
                    right = j + 1 < m ? grid[i][j + 1] : 0;

                    visited[up] = true;
                    merge = 1 + size[up];
                    // 去重
                    if (!visited[down]) {
                        merge += size[down];
                        visited[down] = true;
                    }
                    if (!visited[left]) {
                        merge += size[left];
                        visited[left] = true;
                    }
                    if (!visited[right]) {
                        merge += size[right];
                        visited[right] = true;
                    }
                    ans = Math.max(ans, merge);
                    visited[up] = false;
                    visited[down] = false;
                    visited[left] = false;
                    visited[right] = false;

                }
            }
        }
        return ans ;
    }

    public static void dfs(int[][]grid  , int n , int m ,int i , int j , int id){
        if ( i < 0 || i == n || j < 0 || j == n || grid[i][j] != 1){ // 越界或者来的位置不是1
            return;
        }
        // grid[i][j] == 1
        grid[i][j] = id;
        dfs(grid, n ,m, i - 1 , j, id);
        dfs(grid, n , m, i + 1 , j, id);
        dfs(grid, n , m, i , j - 1, id);
        dfs(grid, n , m, i , j + 1, id);
    }
}
