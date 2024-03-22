package com.class61;

// Kruskal算法模版（洛谷）
// 静态空间实现
// 测试链接 : https://www.luogu.com.cn/problem/P3366
// 这是输入输出处理效率很高的写法
// 提交以下所有代码，把主类名改成Main，可以直接通过

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// 时间复杂度O(m * log m) + O(n + m)
public class Code01_Kruskal {
    //点
    public static int MAXN = 5001;

    //边
    public static int MAXM = 200001;

    public static int[] father = new int[MAXN];

    // u ,v ,w
    public static int[][] edges = new int[MAXM][3];

    public static int n , m ;

    //并查集清空
    public static void build (){
        for (int i = 1 ; i <= n ; i++) {
            father[i] = i ;
        }
    }

    //扁平化
    public static int find(int i ) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    //  如果x和y本来就是一个集合,返回false
    //  如果x和y不是一个集合的话,返回true
    public static  boolean union(int x , int y ) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy ;
            return true;
        }else{
            return false ;
        }
    }

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            build();
            for (int i = 0; i < m; i++) {
                in.nextToken();
                edges[i][0] = (int) in.nval;
                in.nextToken();
                edges[i][1] = (int) in.nval;
                in.nextToken();
                edges[i][2] = (int) in.nval;
            }
            Arrays.sort(edges,0,m,(a,b) ->a[2] - b[2]);
            int ans = 0 ;
            int edgeCnt = 0 ;
            for (int[] edge: edges
                 ) {
                if (union(edge[0] , edge[1])) {
                    edgeCnt++;
                    ans += edge[2];
                }
            }
            out.println(edgeCnt == n - 1 ? ans : "orz");
            }
        out.flush();
        out.close();
        br.close();
    }
}