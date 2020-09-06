package wf.jianzhi_offer;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class 滑动窗口的最大值 {

    public static void main(String[] args) {
        int[] list = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(list, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        AtomicInteger l;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] end = new int[nums.length - k+1];
        ArrayList<Integer> queue = new ArrayList<>();
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.get(0) <= i-k)queue.remove(0);
            while (!queue.isEmpty() && queue.get(queue.size() - 1) < nums[i])queue.remove(queue.size() - 1);
            queue.add(i);
            if (i >= k-1)end[j++] = nums[queue.get(0)];
        }
        return end;
    }
}
