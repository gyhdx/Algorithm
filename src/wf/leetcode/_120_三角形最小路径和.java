package wf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/7/22 15:24
 */
/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 */
public class _120_三角形最小路径和 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add(i + j);
            }
            triangle.add(list);
        }
//        for (List<Integer> list : triangle) {
//            for (Integer integer : list) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }

        System.out.println(minimumTotal(triangle));
        System.out.println(minimumTotal2(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int deep = triangle.size();
        int[][] end = new int[deep][deep];
        for (int i = 0; i < deep; i++) {
            end[deep - 1][i] = triangle.get(deep - 1).get(i);
        }
        for (int i = deep - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                end[i][j] = Math.min(end[i + 1][j], end[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return end[0][0];
    }

    // 老师的代码
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int deep = triangle.size();
        int[] end = new int[deep];

        for (int i = 0; i < deep; i++) {
            end[i] = triangle.get(deep - 1).get(i);
        }
        for (int i = deep - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                end[j] = Math.min(end[j], end[j + 1]) + triangle.get(i).get(j);
            }
        }
        return end[0];
    }

    private static void print(int[][] mg) {
        for (int i = 0; i < mg.length; i++) {
            for (int j = 0; j < mg[0].length; j++) {
                System.out.print(mg[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("输出结束！————————1");
    }
}
