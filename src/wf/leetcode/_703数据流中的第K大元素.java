package wf.leetcode;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 解题思路：
 *  要求第k大的数，可以把前k大的元素放入以最小堆实现的优先队列，以后进来数据就与队列头部元素比较，如果大于队头元素，就把
 *  已经存在的堆头元素取出，把进来的数据加入。
 */
public class _703数据流中的第K大元素 {

    public static void main(String[] args) {
        int k = 3;
        int[] arr ={4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, arr);
        int add = kthLargest.add(3);// returns 4
        System.out.println(add);
        add = kthLargest.add(5);// returns 5
        System.out.println(add);
        add = kthLargest.add(10);// returns 5
        System.out.println(add);
        add = kthLargest.add(9);// returns 8
        System.out.println(add);
        add = kthLargest.add(4);// returns 8
        System.out.println(add);

    }

}
class KthLargest{
    private PriorityQueue<Integer> queue;
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        queue = new PriorityQueue(k);
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < size){
            queue.add(val);
        }else if (queue.peek() < val){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }


}