package 秋招.瑛太莱;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        getList(list, n,m,"");
        System.out.println(list.size());
    }

    private static void getList(ArrayList<String> list, int n, int m,String s) {
        if (m==0 && n==0)return;
        if (s.length()>0 && !list.contains(s)){
            list.add(s);
        }
        if (n>0){
            getList(list,n-1,m,s+"a");
        }
        if (m>0){
            getList(list,n,m-1,s+"b");
        }
    }
}
