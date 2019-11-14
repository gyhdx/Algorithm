package wf.jianzhi_offer;

import java.util.Scanner;

public class 二进制中1的个数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要操作的数字");
        int n= sc.nextInt();
        int z = NumberOf1(n);
        System.out.println(z);
    }

    public static int NumberOf1(int n) {
        int count=0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
