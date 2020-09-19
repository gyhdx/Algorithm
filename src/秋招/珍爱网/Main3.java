package 秋招.珍爱网;

import java.util.Stack;

public class Main3 {

    public static void main(String[] args) {
        String s = "8+1/2-5";
        System.out.println(calByBackwardNotation(s));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算表达式结果
     * @param express string字符串 计算表达式
     * @return int整型
     */
    public static int calByBackwardNotation (String express) {
        Stack<Character> stack = new Stack<>();
        // write code here
        String midStr = getMidStr(express, stack);
        Stack<Float> stack1 = new Stack<>();
        char[] chars = midStr.toCharArray();
        for (int i = 0; i < midStr.length(); i++) {
            Character ch = chars[i];
            if (ch >= '0' && ch <= '9'){
                stack1.push(Float.valueOf(ch - '0'));
            }else {
                stack1.push(getFloat(ch,stack1.pop(),stack1.pop()));
            }
        }
        float pop = stack1.pop();
        return (int)pop;

    }

    private static Float getFloat(Character ch, Float pop, Float pop1) {
        if (ch == '+')return pop1 + pop;
        else if (ch == '-')return pop1 - pop;
        else if (ch == '*')return pop1 * pop;
        else if (ch == '/')return pop1 / pop;
        else return Float.valueOf(-0);
    }

    private static String getMidStr(String express, Stack<Character> stack) {
        char[] chars = express.toCharArray();
        String ens = "";

        for (int i = 0; i < express.length(); i++) {
            char mid = chars[i];
            if (mid == ' ')continue;
            if (mid >= '0' && mid <= '9'){
                ens += mid;
                continue;
            }
            if (mid == '(')stack.push(mid);

            if (mid == '+' || mid == '-'){
                while (!stack.empty() && (stack.peek() != '(')){
                    ens += stack.pop();
                }
                stack.push(mid);
                continue;
            }

            if (mid == '*' || mid == '/'){
                while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')){
                    ens += stack.pop();
                }
                stack.push(mid);
                continue;
            }

            if (mid == ')'){
                while (!stack.empty() && stack.peek() != '('){
                    ens += stack.pop();
                }
                stack.pop();
                continue;
            }
        }
        while (!stack.empty())ens += stack.pop();
        return ens;
    }


}
