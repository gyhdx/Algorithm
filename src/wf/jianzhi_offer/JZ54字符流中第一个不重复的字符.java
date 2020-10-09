package wf.jianzhi_offer;

import java.util.ArrayList;

/*
题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，
第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，
第一个只出现一次的字符是"l"。

 */
public class JZ54字符流中第一个不重复的字符 {
    public static void main(String[] args) {
        JZ54字符流中第一个不重复的字符 m = new JZ54字符流中第一个不重复的字符();
        String s = "google";
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println(m.FirstAppearingOnce());
            m.Insert(aChar);
        }
    }
    private ArrayList<Character> ens = new ArrayList<>();

    public void Insert(char ch) {
        if (ens.contains(ch)){
            ens.remove((Character) ch);
        }else
            ens.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (ens.isEmpty()){
            return '#';
        }else
            return ens.get(0);
    }
}
