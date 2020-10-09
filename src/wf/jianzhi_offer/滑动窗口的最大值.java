package wf.jianzhi_offer;

import java.util.ArrayList;

public class 滑动窗口的最大值 {

    public static void main(String[] args) {
        int[] list = {1,3,-1,-3,5,3,6,7};
        ArrayList<Integer> ints = maxSlidingWindow(list, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
//        int[] end = new int[nums.length - k+1];

        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> ens = new ArrayList<>();
        if (k==0)return ens;
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.get(0) <= i-k)queue.remove(0);
            while (!queue.isEmpty() && nums[queue.get(queue.size() - 1)] < nums[i])queue.remove(queue.size() - 1);
            queue.add(i);
            if (i >= k-1)ens.add(nums[queue.get(0)]);
        }
        return ens;
    }
}
