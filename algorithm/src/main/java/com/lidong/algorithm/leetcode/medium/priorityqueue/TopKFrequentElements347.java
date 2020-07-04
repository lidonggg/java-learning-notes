package com.lidong.algorithm.leetcode.medium.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素（中等-347）
 * 中文链接：https://leetcode-cn.com/problems/top-k-frequent-elements/
 * <p>
 * 问题描述：
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * - 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * - 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * - 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * - 你可以按任意顺序返回答案。
 *
 * @author Ls J
 * @date 2020/7/4 3:00 PM
 */
public class TopKFrequentElements347 {

    /**
     * 利用大顶堆
     * <p>
     * 执行用时：17 ms，在所有 Java 提交中击败了 70.37% 的用户
     * 内存消耗：42 MB，在所有 Java 提交中击败了 10.00% 的用户
     * <p>
     * 时间复杂度：O(nlog(k))
     * 空间复杂度：O(n)
     *
     * @param nums nums
     * @param k    k
     * @return top ks
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (i1, i2) -> countMap.get(i2) - countMap.get(i1)
        );

        maxHeap.addAll(countMap.keySet());

        int[] res = new int[k];

        for (int i = 0; i < k; ++i) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
