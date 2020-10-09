package 秋招.度小满;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] mid = new char[m][n];
            sc.nextLine();
            int x = 0;
            int y = 0;
            for (int j = 0; j < m; j++) {
                String s = sc.nextLine();
                for (int k = 0; k < s.length(); k++) {
                    char c = s.charAt(k);
                    if (c == '@') {
                        x = j;
                        y = k;
                    }
                    mid[j][k] = c;
                }
            }
            int ens = findWay(mid, x, y, m, n);
            System.out.println(ens);

        }
    }

    private static int findWay(char[][] mid, int x, int y, int m, int n) {
        int ens = 0;
        List<Character> list = new ArrayList<>();
        int n1 = findRightWay(mid, x - 1, y, m, n, 0, 'n');
        int s = findRightWay(mid, x + 1, y, m, n, 0, 's');
        int w = findRightWay(mid, x, y - 1, m, n, 0, 'w');
        int e = findRightWay(mid, x, y + 1, m, n, 0, 'e');
        int res = s+e+n1+w;
        if (res == -4){
            return -1;
        }else {
            return list.size();
        }

    }

    private static int findRightWay(char[][] mid, int x, int y, int m, int n,int num, char way) {
        if (mid[x][y] == '#'){
            return -1;
        }
        if (mid[x][y] == '*'){
            num++;
        }
        if (x<=0 || x >= m-1){
            return num;
        }
        if (y>=0 || y>= n-1){
            return num;
        }


        int w = 0;
        int n1 = 0;
        int e = 0;
        int s = 0;
        if (way != 'n'){
            n1 = findRightWay(mid, x - 1, y, m, n, num, 'n');
        }
        if (way != 's'){
            s = findRightWay(mid, x + 1, y, m, n, num, 's');
        }
        if (way != 'w'){
            w = findRightWay(mid, x , y-1, m, n, num, 'w');
        }
        if (way != 'e'){
            e = findRightWay(mid, x , y+1, m, n, num, 'e');
        }

        return x;
    }
}
