package 秋招.小米;

import java.util.*;

public class Main1_1 {
    private static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Scanner sc = new Scanner(System.in);
        String str;
        while (sc.hasNextLine()){
            str = sc.nextLine();
            System.out.println(strIsRight(str));
        }
    }

    private static Boolean strIsRight(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char mid = s.charAt(i);
            if (mid == '(' || mid == '['||mid=='{'){
                stack.push(mid);
            }else if (!stack.empty() &&(mid == '}'||mid == ')' || mid==']')){
                if (mid == map.get(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
