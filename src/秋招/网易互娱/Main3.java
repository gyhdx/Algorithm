package 秋招.网易互娱;

import java.util.ArrayList;
import java.util.List;

//5,[[0, 3], [2, 3], [1, 4]]
public class Main3 {
    public static void main(String[] args) {
        int[][] a = {{0,1},{1,0}};
//        int[][] a = {{0,3},{2,3},{1,4}};
        int[] process = process(5, a);
        for (int i : process) {
            System.out.println(i);
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 找出报到流程的正确顺序
     * @param n int整型 流程数量
     * @param preprocesses int整型二维数组 前置流程
     * @return int整型一维数组
     */
    public static int[] process (int n, int[][] preprocesses) {
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < preprocesses.length; i++) {
            boolean a = insertList(list,preprocesses[i][0],preprocesses[i][1]);
            if (!a){
                return new int[]{};
            }
        }
        int[] ens = new int[list.size()];
        for (int i = 0; i < ens.length; i++) {
            ens[i] = list.get(i);
        }
        return ens;
    }

    private static boolean insertList(List<Integer> list, int end, int head) {
        if (end == head)return false;
        if (list.isEmpty()){
            list.add(head);
            list.add(end);
            return true;
        }
        if ((!list.contains(end))&&(!list.contains(head))){
            list.add(head);
            list.add(end);
            return true;
        }
        if (list.contains(head)&&list.contains(end)){
            if (list.indexOf(head) > list.indexOf(end)){
                return false;
            }
        }
        if (list.contains(head)&&(!list.contains(end))){
            int index = list.indexOf(head);
            while (true){
                if (index+1 == list.size()){
                    list.add(end);
                    return true;
                }
                if (list.get(index+1) > end){
                    list.add(index+1,end);
                    return true;
                }
                index++;
            }
        }
        if (list.contains(end)&&(!list.contains(head))){
            int index = list.indexOf(head);
            while (true){
                if ((index-1)==0){
                    list.add(0,head);
                    return true;
                }
                if (list.get(index-1) < head ){
                    list.add(index-1,end);
                    return true;
                }
                index--;
            }
        }
        return false;
    }


}
