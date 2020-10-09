package wf.jianzhi_offer;

import java.util.ArrayList;

/*
题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

 */
public class JZ41和为S的连续正数序列 {

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        int left = 1;

        int right = 2;
        int count = left + right;
        while (left < right) {
            if (count == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = left; j <=right; j++) {
                    list.add(j);
                }
                lists.add(list);
                count += ++right;
            } else if (count > sum) {
                count -= left++;
            } else {
                count += ++right;
            }
        }
        return lists;
    }
}
