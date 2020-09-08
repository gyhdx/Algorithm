package wf.leetcode;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */

import java.util.*;

public class _347_前K个高频元素 {

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3};
        for (int i : topKFrequent(a, 1)) {
            System.out.println(i);
        }
    }

    /*
    解法：
        使用最小堆，重点是如何构建最小堆
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        /*
        最小堆的构建
         */
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k){
                if (queue.peek()[1] < count){
                    queue.poll();
                    queue.add(new int[]{num, count});
                }
            }else {
                queue.add(new int[]{num, count});
            }
        }

        int[] ens = new int[k];

        for (int i = 0; i < k; i++) {
            ens[i] = queue.poll()[0];
        }

        return ens;
    }
}
