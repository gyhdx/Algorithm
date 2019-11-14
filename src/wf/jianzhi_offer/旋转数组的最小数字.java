package wf.jianzhi_offer;

/*
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转数组的最小数字 {

    public static void main(String[] args) {
//        int[] arr = {3,4,5,1,2};
//        int[] arr = {1,2,2,2,5};
//        int[] arr = {2,2,2,2,2};
//        int[] arr = {2,2,2,5,1};
//        int[] arr = {2,3,4,5,1};
        int[] arr = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
//        int[] arr = {1,2,3,4,5};
        Solution5 s = new Solution5();
        long time1 = System.currentTimeMillis();
        System.out.println(time1);
        int min = s.minNumberInRotateArray(arr);
        long time2 = System.currentTimeMillis();
        System.out.println(time2);
        System.out.println(time2-time1);
        System.out.println(min);
    }
}

class Solution5 {
   /* public int minNumberInRotateArray(int [] array) {
        if (array != null && array.length > 0) {
            int low = 0;
            int high = array.length - 1;
            int mid = low ;
            while (true){
                mid = (low + high +1 )/2;
                //说明该数组与原数组相同，即是一个非递减数组，那么该数组最小值为0号位置的值
                if (array[low] <= array[high]) break;
                //该数组为被旋转的数组，判断中间位值的数是否大于low位置的数，若大于说明
                //搬到数组的末尾的最开始的元素少，最小值在数组mid左边则把low移到mid位置
                //减小搜索范围；若mid位置的数小于mid位置的数说明，最小值在mid左边，则把
                //high移到mid位置减小搜索范围；
                if (array[mid] > array[low]) low = mid;
                else if (array[mid] == array[low]) low++;
                else high = mid;
                //重新定位mid的位置，由mid的计算公式可知如果mid == low说明low和high在相邻位置，
                //之前的if条件排除了所有元素都参与移位的情况，说明现在只有若干元素移到末位，而
                //low和high在相邻位置，则high位置即low+1位置就是数组中最小值位置；

                if (low == high){
                    break;
                }
            }
            return array[low];//返回low的值
        }
        return 0;
    }*/
    public int minNumberInRotateArray(int [] array) {
        if (array != null && array.length > 0) {
            int low = 0;
            int high = array.length - 1;
            int mid = low ;
            while (array[low] >= array[high]){
                if (high - low ==1){
                    mid = high;
                    break;
                }
                mid = (low + high)/2;
                if (array[low] == array[mid] && array[mid] == array[high]) return minNumber(array,low,high);
                if (array[mid] >= array[low]) low = mid;
                else if (array[mid] <= array[high]) high = mid;
                }
            return array[mid];//返回low的值
        }
        return 0;
    }
    private int minNumber(int[] array, int low, int high){
        int num = low;
        for (int i=low+1;i<= high;i++){
            if (num > array[i]){
                num = array[i];
            }
        }
        return num;
    }
}