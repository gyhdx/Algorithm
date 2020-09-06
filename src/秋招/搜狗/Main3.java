package 秋招.搜狗;

import java.util.HashSet;

public class Main3 {

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        System.out.println(main3.getPasswordCount("123"));
    }

    public long getPasswordCount(String password) {
        // write code here
        if (password.length() == 0) return 0;
        if (password.length() == 1) return 9;
        long count = 0;

        for (int i = 0; i < 10; i++) {
            String s = "" + i;
            int c = getcouunt(password, s, 1);
            count+=c;
        }

        HashSet<String> set = new HashSet<>();

        return count;
    }

    private int getcouunt(String password, String s, int i) {
        if (i == password.length()) {
            if (password.equals(s)) {
                return 0;
            } else {
                return 1;
            }
        }

        int n = Integer.valueOf( s.charAt(i - 1)-'0') + Integer.valueOf( password.charAt(i) - '0');
        if ((n % 2) == 0) {
            return getcouunt(password, s + (n / 2), i+1);
        } else {
            return getcouunt(password, s + (n / 2), i+1) + getcouunt(password, s + (n / 2 + 1), i+1);
        }
    }
}
