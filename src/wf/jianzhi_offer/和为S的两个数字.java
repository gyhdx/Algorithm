package wf.jianzhi_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class 和为S的两个数字 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        ArrayList<Integer> list = FindNumbersWithSum(array, 12);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array.length <= 1)return list;
        int frist = 0,end = array.length - 1;
        while (frist < end){
            if (array[frist] + array[end] == sum){
                list.add(array[frist]);
                list.add(array[end]);
                break;
            }else if (array[frist] + array[end] > sum){
                end--;
            }else if (array[frist] + array[end] < sum){
                frist++;
            }
        }
        return list;
    }
}
