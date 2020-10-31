package wf.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _215_数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(a,2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            }else {
                Integer peek = queue.peek();
                if (peek < num){
                    queue.add(num);
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
}
