package com.class56;

import java.io.*;

public class TestOne {
    public  static int MAXN = 100001;

    public  static  int[] arr = new int[MAXN];

    public  static  int n;

    public static  int[][]stack = new int[MAXN][2];

    public static int r ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            for (int i = 0;i<n ;i++){
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(turns());
        }
        out.flush();
        out.close();
        br.close();
    }

    //arr[0...n - 1 ] 鱼的体重
    // stack[...]随便用
    public  static  int turns(){
        r = 0 ;
        int ans = 0 ;
        for (int i = n -1,curTurns; i>=0;i--){
            //i号鱼 arr[i]
            // 0轮是初始
            curTurns = 0 ;
                            //栈顶小就弹出
            while (r > 0 && stack[r - 1][0] <arr[i]){
                curTurns = Math.max(curTurns + 1 , stack[--r][1]);  // 当前轮数加1和栈顶轮数求最大值
            }
            stack[r][0] = arr[i];  // 放入体重
            stack[r++][1] = curTurns; // 放入轮数
            ans = Math.max(ans,curTurns);
        }
        return ans ;
    }


}
