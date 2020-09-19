package 秋招.小米;

import java.util.*;

public class Main1 {
    private static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String str;
        while (sc.hasNext()){
//            list.add(sc.nextLine());
            str = sc.nextLine();
            System.out.println(strIsRight(str));
        }
    }

    private static List<Boolean> pd(List<String> list) {
        List<Boolean> ens = new ArrayList<>();
        for (String s : list) {
            System.out.println(strIsRight(s));
//            ens.add(strIsRight(s));
        }
        return ens;
    }

    private static Boolean strIsRight(String s) {
        if (s == null)return false;
        if (s.length()==0)return true;

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
