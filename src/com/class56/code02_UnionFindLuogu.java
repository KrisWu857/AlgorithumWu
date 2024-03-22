package com.class56;


// 并查集模版(洛谷)
// 本实现用递归函数实现路径压缩，而且省掉了小挂大的优化，一般情况下可以省略
// 测试链接 : https://www.luogu.com.cn/problem/P3367
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过


public class code02_UnionFindLuogu {
    public  static  int MAXN = 10001;

    public  static  int[] father  = new int[MAXN];

    public  static  int n  ;

    public  static  void built(){
        for (int i = 0 ; i<= n ; i++) {
            father[i] = i ;
        }
    }

    public  static  int find(int i ) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public  static  boolean isSameSet(int x , int y) {
        return  find(x) == find(y) ;
    }

    public  static void union(int x , int y ) {
        father[find(x)] = find(y);
    }
}
