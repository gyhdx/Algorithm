package wf.jianzhi_offer;

/*
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class 跳台阶 {

    public static void main(String[] args) {
        Solution7 s = new Solution7();
        System.out.println(s.JumpFloor1(3));
    }
}

class Solution7 {
    public int JumpFloor(int x) {
        int m = 1;
        int n = 1;
        for (int i = 0; i < x; i++) {
            m = m + n;
            n = m - n;
        }
        return n;
    }

    public int JumpFloor1(int x) {
        if (x == 1) return 1;
        else if (x == 2) return 2;
        else return JumpFloor1(x - 1) + JumpFloor1(x - 2);
    }
}