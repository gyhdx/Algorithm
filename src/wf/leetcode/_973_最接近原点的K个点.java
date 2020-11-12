package wf.leetcode;


import java.util.Arrays;
import java.util.Comparator;

/*
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

 */
public class _973_最接近原点的K个点 {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt((array) -> array[0] * array[0] + array[1] * array[1]));
        return Arrays.copyOf(points, K);
    }
}
