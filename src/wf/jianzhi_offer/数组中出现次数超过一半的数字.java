package wf.jianzhi_offer;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        数组中出现次数超过一半的数字 a = new 数组中出现次数超过一半的数字();
        int[] array = {1,2,3,2,2,2,5,4,2};
//        int[] array = {1,2,5,2,2,2,2,6};
        int i = a.MoreThanHalfNum_Solution(array);
        System.out.println(i);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int num=0;
        sort(array,0,array.length-1);
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();;
        int i = array.length/2;

        int count = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[i] == array[j])count++;
        }
        if (count>i)num=array[i];
        return num;
    }

    private void sort(int[] array,int start,int end){
        if (start >= end)return;
        int num = (start+end)/2;
        swap(num,end,array);
        int mall = start - 1;
        for (int i = start; i < end; i++) {
            if (array[i]<array[end]){
                mall++;
                if (mall!=i){
                    swap(i,mall,array);
                }
            }
        }
        mall++;
        swap(mall,end,array);

        if (mall>start)
            sort(array,start,mall-1);
        if (mall<end)
            sort(array,mall+1,end);

    }

    private void swap(int i, int j, int[] chars) {
        int c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
