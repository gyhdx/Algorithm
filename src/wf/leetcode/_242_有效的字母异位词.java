package wf.leetcode;

import java.util.Arrays;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class _242_有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return String.valueOf(chars).equals(String.valueOf(chart));
    }
}
