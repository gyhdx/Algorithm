package wf.leetcode;

/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class _7_整数反转 {

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        long ens = 0;

        while (x !=0){
            int n = x % 10;
            x /=10;
            ens = ens*10 + n;
            if (ens > Integer.MAX_VALUE || ens < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)ens;
    }
}
