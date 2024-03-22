package com.class60;

import java.util.ArrayList;

public class Code03_ParallelCourseIII {

    public static int minimumTime(int n , int[][] relations , int[] time ) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];
        for (int[] edge : relations) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        int[] queue = new int[n];
        int l = 0;
        int r = 0;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue[r++] = i;
            }
        }
        int[] cost = new int[n + 1];
        int ans = 0;
        while ( l < r ){
        int cur = queue[l++];
        // 1 : time[0]
        // x : time[x - 1 ]
        cost[cur] += time[cur - 1];
        ans = Math.max(ans, cost[cur]);
        for (int next : graph.get(cur)) {
            cost[next] = Math.max(cost[next], cost[cur]);
            if (--indegree[next] == 0) {
                queue[r++] = next;
            }
        }
    }
        return ans ;
    }
}
