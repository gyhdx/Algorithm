package 秋招.神策;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        if (a.length() != b.length()){
            System.out.println(false);
            return;
        }


        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            if (!set.contains(b.charAt(i))){
                System.out.println(false);
                return;
            }
        }

        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            if (achar[i] != bchar[i]){
                char c = bchar[i];
                bchar[i] = bchar[i + 1];
                bchar[i + 1] = c;
                break;
            }

            if (i == a.length()-1 && set.size()>1){
                System.out.println(false);
                return;
            }
        }

        for (int i = 0; i < a.length(); i++) {
            if (achar[i] != bchar[i]){
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
