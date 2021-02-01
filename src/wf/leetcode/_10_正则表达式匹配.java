package wf.leetcode;

/*
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class _10_正则表达式匹配 {

    public static void main(String[] args) {

    }

    public static boolean isMatch(String s, String p) {
        if (s.length() == 0)return true;
        if (s.length() != 0 && p.length() == 0)return false;
        int i = 0;
        while (i+1<p.length()){
            if (p.charAt(i)=='.'&& p.charAt(i+1)=='*'){
                return true;
            }
        }

        return true;
    }
}
