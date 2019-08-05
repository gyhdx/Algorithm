package wf.jianzhi_offer;

import java.util.Scanner;

/*
题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
个整数，判断数组中是否含有该整数。
解题思路：
    因为数组每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    （{1,3,5,12,14（右上角的数），16，19，21}
    所以可以把右上角的数看作其所在行和所在列组成的递增数组的中位数，然后把当目标值与右上角的
    值进行比较，若目标值大于右上角的数，那么就把行值增加（i++；相当于查询递增数组的右边的值。）；
    若目标值小于右上角的数就减小列值（length--；相当于索引中位数的左值）；如果相等在返回true，
    否则返回false；
 */
public class 二维数组中查找 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查找的数：");
        int a  = scanner.nextInt();
        int[][] arrs = {{1,3,5,12,14},{2,4,7,13,16},{3,6,9,15,19},{6,8,10,19,21}};
        System.out.println("要查找的数存在？" + Find(a,arrs));
    }

    public static boolean Find(int target, int [][] array) {
        int length = array[0].length - 1;//记录数组的列值
        int i=0;//记录数组的行数
        while(length >= 0 && (i < array.length)){
            if (array[i][length] == target)
                return true;
            else if (array[i][length] > target) length--;
            else if(array[i][length] < target) i++;
        }
        return false;
    }
}
