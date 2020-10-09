package 秋招.奇安信;

import java.util.*;

//[1,1,1,2,3,3,3],2
public class Solution {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,3,3,3};
        System.out.println(leastWorkTime(a,2));
    }
    /**
     *
     * @param tasks int整型一维数组 待加工的零件
     * @param n int整型 n的值
     * @return int整型
     */
    public static int leastWorkTime (int[] tasks, int n) {
        // write code here
        Map<Integer,int[]> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])){
                map.get(tasks[i])[0]++;
            }else {
                int[] mid = new int[2];
                mid[0] = 1;
                map.put(tasks[i],mid);
            }
            set.add(tasks[i]);
        }
        List<Integer> list = new ArrayList<>();
        while (!map.isEmpty()){
            boolean flag = true;
            for (Integer integer : set) {
                if (map.containsKey(integer)&&map.get(integer)[1] == 0){
                    list.add(integer);
                    map.get(integer)[0]--;
                    map.get(integer)[1]=1;
                    flag = false;
                    break;
                }
            }
            if (flag)list.add(-1);
            for (Integer integer : set) {
                if (map.containsKey(integer)&&map.get(integer)[1] > 0 && map.get(integer)[1] <n+2){
                    map.get(integer)[1]++;
                }
            }
            for (Integer integer : set) {

                if (map.containsKey(integer)&&map.get(integer)[1] ==n+2){
                    map.get(integer)[1]=0;
                }
            }
            flag =true;
            for (Integer integer : set) {
                if (map.containsKey(integer)&&map.get(integer)[0] == 0){
                    map.remove(integer);
                    flag=false;
                }
            }
            if (!flag){
                for (Integer integer : set) {
                    if (map.containsKey(integer)){
                        map.get(integer)[1]=0;

                    }
                }
            }
        }
        return list.size();
    }
}
