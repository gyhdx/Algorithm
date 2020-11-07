package wf.leetcode;

/*
编写一个程序，找出第 n 个丑数。

丑数就是质因数只包含 2, 3, 5 的正整数。
 */
public class _264_丑数2dp {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        if (n<=0)return 0;
        int[] mid = new int[n];

        int x = 0,y=0,z=0;
        mid[0] = 1;
        for (int i = 1; i < n; i++) {
            mid[i] = Math.min(mid[x]*2,Math.min(mid[y]*3,mid[z]*5));
            if (mid[i] == mid[x]*2){
                x++;
            }
            if (mid[i] == mid[y]*3){
                y++;
            }
            if (mid[i] == mid[z]*5){
                z++;
            }
        }
        return mid[n-1];
    }
}

