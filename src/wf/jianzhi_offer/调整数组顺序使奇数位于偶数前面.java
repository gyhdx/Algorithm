package wf.jianzhi_offer;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        int a[] = {2,4,6,1,3,5,7};
//        int a[] = {0,1,2,3,4,5};
        reOrderArray(a);
        for (int i : a) {
            System.out.print(i+" ,");
        }
    }

    public static void reOrderArray(int [] array) {
        if (array.length==0)return;
        int i=0,j=0;

        while (j<array.length&&i<array.length){
            while (array.length>j&&(array[j]&1)!=0){
                j++;
            }
            i=j;
            while (array.length>i&&(array[i]&1)!=1){
                i++;
            }
            if (j<array.length&&i<array.length){
                int x=array[i];
                for (int i1 = i; i1 > j; i1--) {
                    array[i1]=array[i1-1];
                }
                array[j]=x;
            }
        }
    }
}
