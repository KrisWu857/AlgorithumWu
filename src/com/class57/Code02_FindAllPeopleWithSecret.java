package com.class57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code02_FindAllPeopleWithSecret {
    public static int MAXN = 100001;

    public static int[] father = new int[MAXN];

    // 集合的标签信息 : 设置集合的一些属性
    // 属性在哪？secret[代表元素] 代表集合的属性
    public static boolean[] secret = new boolean[MAXN];

    public static void build(int n, int first) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            secret[i] = false;
        }
        father[first] = 0;
        secret[0] = true;
    }

    // 扁平化的过程
    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }


    //小挂大的过程
    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            secret[fy] |= secret[fx]; //
        }
    }

    // 会议排序 : m * log m
    // 处理过程 : O(m)
    // 收集答案 : O(n)
    public static List<Integer> findAllPeople(int n, int[][] meetings, int first) {
        build(n, first);
        // {0 : 专家   1 : 专家编号   2 : 时刻}
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);  // 根据时刻由小到大排个序
        int m = meetings.length;
        for (int l = 0, r; l < m;) {
            r = l;
            while (r + 1 < m && meetings[l][2] == meetings[r + 1][2]) {
                r++;
            }
            // l....r这些会议，一定是一个时刻
            for (int i = l; i <= r; i++) {
                union(meetings[i][0], meetings[i][1]);
            }
            // 有小的撤销行为，但这不是可撤销并查集
            // 只是每一批没有知道秘密的专家重新建立集合而已
            for (int i = l, a, b; i <= r; i++) {
                a = meetings[i][0];
                b = meetings[i][1];
                if (!secret[find(a)]) {
                    father[a] = a;
                }
                if (!secret[find(b)]) {
                    father[b] = b;
                }
            }
            l = r + 1;
        }


        // 收集答案
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secret[find(i)]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
