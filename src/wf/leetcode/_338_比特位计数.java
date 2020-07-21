package wf.leetcode;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/21 12:24
 */
/*
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class _338_比特位计数 {

    public static void main(String[] args) {
        int[] ints = countBits(8);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] countBits(int num) {
        int[] list = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            list[i] = list[i & (i - 1)] + 1;
        }
        return list;
    }
}
