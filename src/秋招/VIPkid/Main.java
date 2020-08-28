package 秋招.VIPkid;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        String[] s = list.split(" ");
        int[] sr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            sr[i] = Integer.valueOf(s[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(sr[0]);

        for (int i = 1; i < sr.length; i++) {
            if (stack.peek() > sr[i]){
                stack.pop();
                stack.push(sr[i]);
            }else {
                stack.push(sr[i]);
            }
        }
        System.out.println(stack.size());
    }
}
