package wf.jianzhi_offer;

/**
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class 求和 {

    public static void main(String[] args) {
        求和 a = new 求和();
        int i = a.Sum_Solution(-1);
        System.out.println(i);
    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
