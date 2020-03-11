package wf.leetcode;

import java.util.HashMap;
import java.util.Stack;

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
