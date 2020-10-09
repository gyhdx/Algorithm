package 秋招.度小满;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        Map<Character,Integer> list = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (list.containsKey(c)){
                list.put(c,list.get(c)+1);
            }else {
                list.put(c,1);
            }
        }

        int ens = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (list.containsKey(c) && list.get(c)>0){
                ens++;
                list.put(c,list.get(c)-1);
            }
        }
        System.out.println(ens);
    }
}
