package wf.jianzhi_offer;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 解题思路：
 *  一个数与0异或是它本身，与它本身异或是0.所以把数组中所有元素异或，因为其他的数字都出现了两次
 *  所以，最后的结果是数组中两个只出现一次的数异或的结果，故只要找到异或结果出现的末尾的1（出现1说明两个数在对应二进制位置不相同）
 *  就可以把数组区分成两组，一个唯一的数位一组，在异或得到的就是我们要的值。
 */
public class 数组中只出现一次的数字 {

    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,4,4,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0] + "  " + num2[0]);
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2)return;
        int index = 0,sum = 0;
        for (int i : array) {
            sum ^= i;
        }
        for (int i = 1; i <= 32; i*=2) {
            if ((sum & 1) == 1){
                index = i;
                break;
            }
            sum = sum>>1;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & index) != 0){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }
}
