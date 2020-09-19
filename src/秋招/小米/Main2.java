package 秋招.小米;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (!list.contains(str.charAt(i))){
                list.add(str.charAt(i));
            }
        }
        String ens = "";
        for (Character character : list) {
            ens+=character;
        }
        System.out.println(ens);
    }
}
