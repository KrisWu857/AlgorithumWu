package com.class56;

import java.io.*;
import java.util.Arrays;

public class TestTwo {
    public  static  int MAXN = 1000005;

    public  static int[][] arr = new int[MAXN][2];

    public  static  int n,d;

    public  static int[] MaxDeque = new int[MAXN];

    public  static int[] MinDeque = new int[MAXN];

    public  static int maxh,maxt,minh,mint;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            d = (int) in.nval;
            for (int i  = 0 ;i<n;i++){
                in.nextToken();
                arr[i][0] = (int) in.nval;
                in.nextToken();
                arr[i][1] = (int) in.nval;
            }
            int ans = computer();
            out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
        out.flush();
        out.close();
        br.close();
    }

    public  static  int computer() {
        // arr[0...n-1][2]:  x(0),高度(1)
        // 所有水滴根据x排序,谁小谁在前面
        Arrays.sort(arr, 0, n, (a, b) -> a[0] - b[0]);
        maxh = maxt = minh = mint = 0;
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; l < n; l++) {
            //[l,r) : 水滴的编号
            // l : 当前花盘的左边界,arr[l][0]
            while (!ok() && r < n) {  // 最大值减最小值没有大于等于d 而且 还有下一滴水
                push(r++);  // 右窗口就扩
            }
            if (ok()) {   // 从while里面出来已经是达标的了
                ans = Math.min(ans, arr[r - 1][0] - arr[l][0]);  // (右边界 - 左边界)的长度
            }
            pop(l);  // 窗口里的l位置有没有过期,过期的话就滚
        }
        return ans ;
    }

    // 当前窗口 最大值 - 最小值 是不是>=d
    public  static  boolean ok(){
        int max = maxh < maxt ? arr[MaxDeque[maxh]][1] : 0 ;
        int min = minh < mint ? arr[MinDeque[minh]][1] : 0 ;
        return max  - min >= d;
    }

    public  static void  push(int r ){
        while (maxh < maxt && arr[MaxDeque[maxt - 1 ]][1] <= arr[r][1]){
            maxt--;
        }
        MaxDeque[maxt++] = r;
        while (minh < mint && arr[MinDeque[mint - 1 ]][1] >= arr[r][1]){
            mint--;
        }
        MinDeque[mint++] = r;
    }

    public  static  void pop(int l) {
        if (maxh < maxt && MaxDeque[maxh] == l){  // 如果是过期下表就从左边的窗口吐出去
            maxh++;
        }
        if (minh < mint && MinDeque[minh] == l) {
            minh--;
        }
    }
}
