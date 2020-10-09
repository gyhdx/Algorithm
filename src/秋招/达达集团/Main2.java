package 秋招.达达集团;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        int day = sc.nextInt();
        String[] split = list.split(",");
        int[] mid = new int[split.length];
        for (int i = 0; i < mid.length; i++) {
            mid[i] = Integer.valueOf(split[i]);
        }
        if (mid.length<day){
            System.out.println(-1);
            return;
        }
        int[] task = new int[day];


        int max = findMax(mid,0,mid.length-1);
        int count = mid[max];
        task[0] = mid[max];
        int j = 1;
        int i = max+1;

        for (;max!=0 && max!=mid.length-1 && i < mid.length; ) {
            if (j>=day){
                break;
            }
            max = findMax(mid,i,mid.length-1);
            if (max==mid.length-1 || max == i){
                break;
            }
            i=max+1;
            task[j++] = mid[max];
            count+=mid[max];
        }
        if (j==day&&(max!=i||max!=mid.length-1)){
            System.out.println(-1);
            return;
        }
        i=1;
        while (j < day){
            count+=mid[mid.length-i];
            i++;
            j++;
        }
        System.out.println(count);

    }

    private static int findMax(int[] mid, int i, int i1) {
        int ens = i;
        for (int j = i+1; j <= i1 ; j++) {
            if (mid[j]>mid[ens]){
                ens = j;
            }
        }
        return ens;
    }
}
