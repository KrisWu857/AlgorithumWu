package com.class56;


// 情侣牵手
// n对情侣坐在连续排列的 2n 个座位上，想要牵到对方的手
// 人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的ID
// 情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2n-2, 2n-1)
// 返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起
// 每次交换可选择任意两人，让他们站起来交换座位
// 测试链接 : https://leetcode.cn/problems/couples-holding-hands/
public class code03_CoupleHoldingHand {
    public static int minSwapsCouples(int[] row ) {
        int n = row.length;
        build( n / 2 );
        for (int i = 0 ;i < n ; i += 2 ) {



            // ? ? ? ? ? ?   上面的人属于什么情侣编号?
            // 0 1 2 3 4 5
            union(row[i] / 2 ,row[i + 1 ] / 2 ); // i位置的人除2 是他的情侣编号
        }
        return  n / 2 - sets ; // 总的情侣数量 - 集合的数量
    }

    public static  int MAXN = 31 ;

    public  static  int[] father = new int[MAXN];

    public static  int sets;

    public  static  void build(int m ) {
        for (int i = 0; i < m; i++) {
            father[i] = i;  // 情侣对的编号
        }
        sets = m;
    }
    public  static int find(int i){
        if ( i != father[i] ) {
            father[i] = find(father[i]);
        }
        return  father[i];
    }

    public  static void union(int x,int y ) {
        int fx = find(x);  // 代表编号
        int fy = find(y);
        if (fx != fy) {  // 代表编号不一样,就合并
            father[fx]  =fy;
            sets--;  // 一合并,那么集合的数量少一个
        }
    }
}
