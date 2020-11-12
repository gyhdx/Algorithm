package wf.leetcode;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class _5_最长回文子串dp {

    public static void main(String[] args) {
        String s = "aavfa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String ens = "";
        if (s.length() <= 1)return s;
        int length = s.length();
        boolean[][] mid = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            mid[i][i] = true;
        }
        ens = s.substring(0,1);
        for (int i = 1; i < length; i++) {
            for (int j =0 ; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j<3 || mid[j+1][i-1])){
                    mid[j][i] = true;
                }
                if (mid[j][i] && ens.length() < (i-j+1)){
                    ens = s.substring(j,i+1);
                }
            }
        }
        return ens;
    }

    public static String longestPalindrome2(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
