package com.class62;

import java.util.PriorityQueue;


// 二维接雨水
// 给你一个 m * n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度
// 请计算图中形状最多能接多少体积的雨水。
// 测试链接 : https://leetcode.cn/problems/trapping-rain-water-ii/

public class Code05_TrappingRainWaterII {
    //    way :宽度优先遍历 与优先级队列的结合

    //                矩阵  *     堆
    // 时间复杂度为 O(n * m *log(n*m))
    public static int trapRainWater (int[][] height) {
        int[] move = new  int[] { -1 , 0 ,1 , 0, -1};
        int n = height.length;
        int m = height[0].length;
        // 0 : 行
        // 1 : 列
        // 2 : 水线(小根堆)
        PriorityQueue<int[] > heap = new PriorityQueue<>((a , b )-> a[2] - b[2] );  // 比较器: 根据 2的位置,谁小谁弹出
        boolean[][] visited = new boolean[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j <m ;j++) {
                // 处在边界处的格子直接进堆
                if (i == 0 || i == n - 1 || j ==0 || j == m - 1 ) {
                    heap.add(new int[] { i , j , height[i][j]});
                    visited[i][j] = true;
                    // 不在边界处的格子,  初始化
                }else{
                    visited[i][j] = false ;
                }
            }
        }
        int ans = 0 ;
        while (!heap.isEmpty()) {
            int[] record = heap.poll();  // 每次都弹出薄弱点
            int r = record[0];
            int c = record[1];
            int w = record[2];
            ans += w - height[r][c];
            for (int i = 0  ,nr ,nc ;i < 4 ;i++){
                // 找上下左右四个方向的格子
                nr = r +move[i];
                nc = c +move[i + 1];
                if ( nr >=0 && nr < n && nc >=0 && nc < m &&  !visited[nr][nc] ){  // 格子不能越界, 且没有进入过优先级队列
                    //                              谁触发我的水线和我自身的最大高度PK
                    heap.add(new int[] { nr , nc , Math.max(height[nr][nc] , w)});
                    visited[nr][nc] = true;
                }
            }
        }
        return ans  ;
    }
}
