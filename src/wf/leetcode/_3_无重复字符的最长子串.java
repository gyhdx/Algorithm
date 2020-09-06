package wf.leetcode;

import java.util.ArrayList;

public class _3_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /*
    滑动窗口解决，把元素放入集合中，无重复就放，出现重复就就开始滑动范围再判断
    每次记录窗口长度的最大值
     */
    public static int lengthOfLongestSubstring(String s) {
        ArrayList<Character> list = new ArrayList<>();
        int rk = -1,ans = 0;
        for (int i = 0; i < s.length(); i++) {
            while (rk + 1 < s.length() && !list.contains((Character)s.charAt(rk + 1))){
                list.add((Character)s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, list.size());
            if (list != null){
                list.remove((Character) s.charAt(i));
            }
        }
        return ans;
    }

}
