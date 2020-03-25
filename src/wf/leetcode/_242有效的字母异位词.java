package wf.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 题目描述：
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class _242有效的字母异位词 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())return false;
        int[] list = new int[26];
        for (int i = 0; i < s.length(); i++) {
            list[s.charAt(i) - 'a']++;
            list[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != 0)return false;
        }
        return true;
    }
}
