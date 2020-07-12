package wf.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/6/8 10:45
 */
/*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。


把数存入map中然后比较
 */
public class _169多数元素 {

    public int majorityElement(int[] nums) {
        int p = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            if (map.containsKey(n)){
                map.put(n,map.get(n)+ 1);
            }else {
                map.put(n,1);
            }
        }
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if ((map.get(integer))>(nums.length/2)){
                p = integer;
                break;
            }
        }
        return p;
    }
}
