package com.class59;

import java.util.ArrayList;

public class Code02_1_TopoSortDynamicLeetcode {
    // https://leetcode.cn/problems/course-schedule-ii/description/
    //      拓扑排序
    public static int[] findOrder(int numCourses , int[][] prerequisites ) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 入度表
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            //    from          to
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++ ;
        }
        // 用数组方式实现队列
        int[] queue = new int[numCourses];
        int l = 0;
        int r = 0;
        for (int i =  0 ; i < numCourses ; i++) {
            if (indegree[i] == 0 ){
                queue[r++] = i ;
            }
        }

        int cnt = 0 ;
        while ( l < r ) {
            int cur = queue[l++];
            cnt++;
            for (int next :graph.get(cur)){  // 遍历cur的邻居
                if (--indegree[next] == 0 ){  // --完之后的入度是0
                    queue[r++] = next ;
                }
            }
        }
        //                                  有环
        return cnt == numCourses ? queue : new int[0];
    }

}



