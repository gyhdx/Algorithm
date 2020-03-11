package wf.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 解题思路：
 *  把字符串转化成字符数组，然后把左括号入栈，有右括号时弹出栈顶的括号，与右括号进行匹配。匹配成功，说明这对括号
 *  合法，继续判断下一个括号，如果匹配失败说明字符串无效直接返回false。把所有字符数组判断完成，在判断栈是否为空
 *  为空说明都匹配true，栈不为空说明无效返回false
 */
public class _20有效的括号 {

    public static void main(String[] args) {
        String a = "()]()(){}[]";
//        String a = "";
        System.out.println(a.length());
        System.out.println(isValid(a));
        System.out.println(isValid2(a));
    }

    public static boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)){
                stack.push(aChar);
            }else if (stack.empty() ||(stack.pop() != map.get(aChar))){
                return false;
            }
        }
        return stack.empty();
    }

    public static boolean isValid2(String s) {
        int length=0;
        do{
            length = s.length();
            s = s.replace("()","").replace("[]","").replace("{}","");

        }while (length != s.length());
        return s.length() == 0;
    }
}
