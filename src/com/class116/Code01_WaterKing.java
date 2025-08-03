package com.class116;
// 出现次数大于n/2的数
// 给定一个大小为n的数组nums
// 水王数是指在数组中出现次数大于n/2的数
// 返回其中的水王数，如果数组不存在水王数返回-1
// 测试链接 : https://leetcode.cn/problems/majority-element/
public class Code01_WaterKing {
    // 时间复杂度0（N）
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int hp = 0;
        for(int num : nums) {
            // 如果无候选，当前的数成为候选，然后血量加1
            if (hp == 0 ) {
                candidate = num;
                hp = 1;
            } else if (num != candidate) {    //  如果有候选， a. 当前数 不= 候选， 血量就减1
                hp--;                         //             b. 当前数 = 候选 ， 血量就加一
            }else {
                hp++;
            }
        }
        if (hp == 0 ) {
            return -1; // 即数组中没有找到水王数
        }
        // 复用hp, 统计真实出现过的次数
        hp = 0 ;
        for (int num : nums) {
            if (num == candidate) {
                hp++;
            }
        }
        return hp > nums.length / 2 ? candidate : -1;
    }
}
