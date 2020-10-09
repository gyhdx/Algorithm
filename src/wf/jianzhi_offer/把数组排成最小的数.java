package wf.jianzhi_offer;

import java.util.Arrays;

/*
题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class 把数组排成最小的数 {

    public static void main(String[] args) {
        int[] a = {1,3,4,2,5};
//        int[] a = {3,32,321};
        System.out.println(PrintMinNumber(a));
    }
/*
解题思路：
    基于有序数组进行比较
 */
    public static String PrintMinNumber(int [] numbers) {
        String ens = "";
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            String mid1 = ens+numbers[i];
            String mid2 = numbers[i]+ens;
            int i1 = mid1.compareTo(mid2);
            if (i1>=0){
                ens=mid2;
            }else {
                ens=mid1;
            }
        }
        return ens;
    }
}
