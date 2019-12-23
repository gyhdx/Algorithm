package wf.jianzhi_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 ，
 * 5 6 7 8 ，
 * 9 10 11 12 ，
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class 顺时针打印矩阵 {

    public static void main(String[] args) {
//        Integer[][] arr = {{1, 2 ,3, 4},{5 ,6 ,7 ,8},{9 ,10 ,11, 12},{13 ,14, 15 ,16}};
        Integer[][] arr = {{1},{2},{3},{4},{5}};
        ArrayList<Integer> list = printMatrix(arr);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }

    }

    public static ArrayList<Integer> printMatrix(Integer[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length==0)return list;
        int col = matrix[0].length;
        int row = matrix.length;
        int start=0;
        while (col>start*2&&row>start*2){
            int x=col-start-1;
            int y=row-start-1;
            for (int i = start; i <= x; i++) {
                list.add(matrix[start][i]);
            }
            if (start<y){
                for (int i = start+1; i <= y; i++) {
                    list.add(matrix[i][x]);
                }
            }
            if (start<y&&start<x){
                for (int i = x-1; i >= start; i--) {
                    list.add(matrix[y][i]);
                }
            }
            if (start<x&&start<y-1){
                for (int i = y-1; i >= start+1; i--) {
                    list.add(matrix[i][start]);
                }
            }
            ++start;
        }
        return list;
    }
}
