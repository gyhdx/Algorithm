package wf.leetcode.面试题;

/*
三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，
小孩一次可以上1阶、2阶或3阶。实现一种方法，
计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。


 */
public class _08_01_三步问题 {

    public static void main(String[] args) {
        System.out.println(waysToStep(61));
    }


    public static int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        long x = 1;
        long y = 2;
        long z = 4;
        while (n - 3 > 0) {
            long mid = (x + y + z)% 1000000007;
            x = y;
            y = z;
            z = mid;
            n--;
        }
        return (int) z % 1000000007;
    }
}
