package wf.jianzhi_offer;

/*
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class Solution {
    public int JumpFloorII(int target) {

    }
}
 */
public class 变态跳台阶 {

    public static void main(String[] args) {
        Solution8 s = new Solution8();
        System.out.println(s.JumpFloorII(3));
    }
}

class Solution8 {
    public int JumpFloorII(int target) {
//        return (int) Math.pow(2,target - 1);
        int a = 1;
        return a<<(target -1);
    }
}