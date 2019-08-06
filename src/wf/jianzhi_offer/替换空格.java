package wf.jianzhi_offer;


/*
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

解题思路：
对于c++来说这道题有些麻烦，因为要考虑数组的长度问题。不过对于Java而言
这道题就很简单了，因为Java字符串支持拼接操作，所以解决该问题的思路就是
申请一个空的字符串，然后遍历目标串，判断其是否为空格，不是就把字符拼接到
String字符串的尾部，是空格就拼接一个“%20”
 */
public class 替换空格 {

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("We Are Happy");
        System.out.println("替换后字符串为" + replaceSpace(s));
    }

    public static String replaceSpace(StringBuffer str) {
        String res = "";
        for (int i = 0; i < str.length() ; i++) {
            if (str.charAt(i) != ' '){
                res += str.charAt(i);
            }else {
                res += "%20";
            }
        }
        return res;
    }
}
