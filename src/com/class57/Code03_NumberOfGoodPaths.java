package com.class57;

import java.util.Arrays;

public class Code03_NumberOfGoodPaths {

    public  static  int MAXN = 30001;

    // 需要保证集合中,代表节点的值,一定是集合当中最大的值
    public  static  int[] father = new int[MAXN];

    // 集合中最大值的次数  也就是 集合中的代表节点的值有几个
    public  static  int[] maxcnt = new int[MAXN];

    public  static  void build(int n ) {
        for (int i =  0 ; i < n ; i++) {
            father[i] = i ;
            maxcnt[i] = 1 ;
        }
    }
    // 这个并查集的优化只来自于扁平化
    public  static  int find(int i) {
        if (i != father[i]){
            father[i] = find(father[i]);
        }
        return father[i];
    }

    //核心
    //注意写法!
    //谁的值大,谁做代表节点
    // 同时注意, maxcnt的更新
    public  static  int union(int x , int y , int[] vals) {
        // fx:  x所在集团的代表节点,同时也是x所在集团的最大值下标
        int fx = find(x);
        // fy:  y所在集团的代表节点,同时也是y所在集团的最大值下标
        int fy = find(y);
        int path = 0;
        if (vals[fx] > vals[fy]) { //不会有好路径
            father[fy] = fx;
        } else if (vals[fx] < vals[fy]) { //也不会产生好路径
            father[fx] = fy;
        } else {
            // 两个集团的最大值一样
            path = maxcnt[fx] * maxcnt[fy];
            father[fy] = fx;  // 相等了,无所谓谁挂谁
            maxcnt[fx] += maxcnt[fy]; // x就成为最大的集团. 更新集团最大值的个数!
        }
        return path;
    }


    public  static  int numberOfGoodPaths(int[] vals , int[][] edges) {
        int n = vals.length;
        build(n);
        int ans = n ;
        //核心就是排序
        // 处理边的时候,依从从小节点往大节点处理
        Arrays.sort(edges,(e1,e2) -> (Math.max(vals[e1[0]], vals[e1[1]]) - Math.max(vals[e2[0]], vals[e2[1]]))); //两头端点的最大值,谁小,谁先处理
        for (int[] edge : edges){
            ans += union(edge[0] , edge[1] ,vals);
        }
        return  ans;
    }
}


