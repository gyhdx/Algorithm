package 秋招.爱奇艺;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] chars = list.toCharArray();

        for (char aChar : chars) {
            if (aChar == '[' || aChar == '{' || aChar == '('){
                stack.push(aChar);
            }else if (aChar == ']' || aChar == '}' || aChar == ')'){
                if (! (map.get(stack.peek()) == aChar)){
                    System.out.println("False");
                    return;
                }
                stack.pop();
            }else if (aChar  == ' '){

            }else {
                System.out.println("False");
            }
        }
        if (stack.empty()){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
