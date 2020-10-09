package wf.jianzhi_offer;

/*
给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */

public class 剪绳子 {

    public static void main(String[] args) {
        System.out.println(cutRope2(15));
    }
/*
题解：
 f(n) = max(f(i)*f(n-i))
 */
    public static int cutRope(int target) {
        if (target < 2)return 0;
        if (target ==2)return 1;
        if (target ==3)return 2;
        int[] ens = new int[target+1];
        ens[0] = 0;
        ens[1] = 1;
        ens[2] = 2;
        ens[3] = 3;
        for (int i = 4; i <= target ; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                max = Math.max(max,ens[j]*ens[i-j]);
            }
            ens[i] = max;
        }
        return ens[target];
    }

    public static int cutRope2(int target) {
        if (target < 2)return 0;
        if (target ==2)return 1;
        if (target ==3)return 2;
        int time_3 = target/3;
        if ((target-(time_3*3+1)) == 0){
            time_3--;
        }
        int time_2 = (target - time_3*3)/2;
        int ens = (int) (Math.pow(3,time_3) + time_2==0?0:Math.pow(2,time_2));
        return ens;
    }
}
