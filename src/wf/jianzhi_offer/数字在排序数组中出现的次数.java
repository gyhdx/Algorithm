package wf.jianzhi_offer;

/**
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 *
 * 解题思路：
 *  要查找一个数在数组中的位置，最好的是二分搜索，而查询一个数在排序数组中出现的次数就要查找他在数组中
 *  的位置，故先用二分搜索查找其开始与结束的位置，相减就行
 */
public class 数字在排序数组中出现的次数 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,3,4,5};
//        int[] arr = {};
        System.out.println(GetNumberOfK(arr,3));
    }

    public static int GetNumberOfK(int [] array , int k) {
        return biSearch(array,k + 0.5) - biSearch(array,k - 0.5);
    }

    public static int biSearch(int[] array , double num){
        int b = 0,e = array.length - 1;
        while (b <= e){
            int mid = (b + e)/2;
            if (array[mid] < num){
                b = mid + 1;
            }else if (array[mid] > num){
                e = mid - 1;
            }
        }
        return b;
    }
}
