package wf.jianzhi_offer;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 *
 * 解题思路：
 *  通过最大堆，把k个数放入堆中，然后每次取堆中最大元素与数组剩余元素比较遍历完数组即可；
 */

public class 最小的K个数 {

    public static void main(String[] args) {

        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(arr, 4);
        for (Integer integer : list) {
            System.out.print(integer + "  ");
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        if (input == null || k<=0 || k > input.length)return output;

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (heap.size() < k){
                heap.add(input[i]);
            }else {
                if (input[i] < heap.peek()){
                    heap.remove();
                    heap.add(input[i]);
                }
            }
        }
        while (!heap.isEmpty()){
            Integer a = heap.remove();
            output.add(a);
        }
        return output;
    }
}
