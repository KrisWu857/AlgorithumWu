package com.class63;

import java.util.Arrays;
//
//// 最接近目标值的子序列和
//// 给你一个整数数组 nums 和一个目标值 goal
//// 你需要从 nums 中选出一个子序列，使子序列元素总和最接近 goal
//// 也就是说，如果子序列元素和为 sum ，你需要 最小化绝对差 abs(sum - goal)
//// 返回 abs(sum - goal) 可能的 最小值
//// 注意，数组的子序列是通过移除原始数组中的某些元素（可能全部或无）而形成的数组。
//// 数据量描述:
//// 1 <= nums.length <= 40
//// -10^7 <= nums[i] <= 10^7
//// -10^9 <= goal <= 10^9
//// 测试链接 : https://leetcode.cn/problems/closest-subsequence-sum/
//
//public class Code03_ClosestSubsequenceSum {
//
//
//    public static int MAXN = 1 << 20;
//
//    public static int[] lsum = new int[MAXN];
//
//    public static int[] rsum = new int[MAXN];
//
//    public static int fill;
//
//    public static int minAbsDifference(int[] nums, int goal) {
//        int n = nums.length;
//        long min = 0;
//        long max = 0;
//            // 常数级优化
//            // 把所有的正数放一起,所有的负数都放一起.
//        for (int i = 0 ; i < n ;i++) {
//            if (nums[i] >= 0 ) {
//                max += nums[i];
//            }else {
//                min += nums[i];
//            }
//        }
//        if (max < goal) {
//            return (int)Math.abs(max - goal);
//        }else {
//            return (int)Math.abs(min - goal);
//        }
//
//        // 原始数组排序,为了方便后面递归的时候方便剪枝
//        // 常数优化
//        Arrays.sort(nums);
//        fill = 0;
//        collect(nums, 0, n >> 1, 0, lsum);
//        int lsize = fill;
//        fill = 0;
//        collect(nums, n >> 1, n, 0, rsum);
//        int rsize = fill;
//        Arrays.sort(lsum, 0, lsize);
//        Arrays.sort(rsum, 0, rsize);
//        int ans = Math.abs(goal);
//        for (int i = 0, j = rsize - 1; i < lsize; i++) {
//            while (j > 0 && Math.abs(goal - lsum[i] - rsum[j - 1]) <= Math.abs(goal - lsum[i] - rsum[j])) {
//                j--;
//            }
//            ans = Math.min(ans, Math.abs(goal - lsum[i] - rsum[j]));
//        }
//        return ans;
//    }
//
//
//    // 通过递归的方式,收集nums[]中指定范围内的元素,生成所有可能的和的组合,并把这些和存储在sum中
//
//    //                     待处理的数组   当前处理的位置    结尾  已经生成的和
//    public static void collect(int[] nums, int i, int e, int s, int[] sum) {
//        if (i == e) {
//            sum[fill++] = s;
//        } else {
//            // nums[i.....]这一组，相同的数字有几个
//            int j = i + 1;
//            while (j < e && nums[j] == nums[i]) {
//                j++;
//            }
//            // nums[ 1 1 1 1 1 2....
//            //       i         j
//            for (int k = 0; k <= j - i; k++) {
//                // k = 0个
//                // k = 1个
//                // k = 2个
//                collect(nums, j, e, s + k * nums[i], sum);
//            }
//        }
//    }
//}
