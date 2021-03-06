package com.lidong.algorithm.leetcode.medium.binarysearch;

/**
 * 爱吃香蕉的珂珂（中等-875）
 * 中文链接：https://leetcode-cn.com/problems/koko-eating-bananas/
 * <p>
 * 问题描述：
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * <p>
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * <p>
 * 示例 3：
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *  
 * 提示：
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * @author ls J
 * @date 2020/7/1 13:56
 */
public class KokoEatingBananas875 {

    /**
     * 二分搜索
     * <p>
     * 执行用时：10 ms，在所有 Java 提交中击败了 92.92% 的用户
     * 内存消耗：40.8 MB，在所有 Java 提交中击败了 100.00% 的用户
     * <p>
     * 时间复杂度：O(NlogW)
     * 空间复杂度：O(1)
     *
     * @param piles piles
     * @param h     h
     * @return min k
     */
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1000000000;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] piles, int h, int k) {
        int times = 0;
        for (int p : piles) {
            // 注意这里的处理技巧
            times += (p - 1) / k + 1;
        }
        return times <= h;
    }
}
