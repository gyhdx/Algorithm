package wf.test;

import java.util.HashMap;
import java.util.Map;

public class T4 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,14};
        int tar = 9;
        int[] max = max(arr, tar);
        for (int i : max) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static int[] max(int[] nums, int targer){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = targer - nums[i];
            if (map.containsKey(x)&&(x != nums[i]))
                return new int[]{i,map.get(x)};
            map.put(nums[i],i);
        }

        return new int[0];
    }
}
