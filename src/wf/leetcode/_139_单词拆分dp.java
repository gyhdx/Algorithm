package wf.leetcode;

import java.util.List;

/*
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

 */
public class _139_单词拆分dp {

    public static void main(String[] args) {
        wordBreak("dwf", null);
        System.out.println("ac".substring(1,1));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] ens = new boolean[length+1];
        ens[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i ; j++) {
                if (ens[j]&&wordDict.contains(s.substring(j,i))){
                    ens[i] = true;
                    break;
                }
            }
        }
        return ens[length];
    }
}
