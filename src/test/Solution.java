package test;

import java.util.HashMap;
import java.util.Scanner;

class Solution {

    private static HashMap<Character,Integer> memo = new HashMap<>();
    private static char[] post;

    public static String buildTree(char[] inorder, char[] postorder) {
        for(int i = 0;i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        String root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public static String buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return "";

        char root = post[pe];
        int ri = memo.get(root);

        String ens = ""+root;
        ens += buildTree(is, ri - 1, ps, ps + ri - is - 1);
        ens += buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return ens;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inOrder = sc.nextLine();
        String postOrder = sc.nextLine();
        System.out.println(buildTree(inOrder.toCharArray(), postOrder.toCharArray()));
    }
}
