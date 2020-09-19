package 秋招.京东;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wz = "";
        String next ;
        while (!(next = sc.nextLine()).equals("")){
            wz+=next;
        }
//        while (sc.hasNextLine()){
//            wz+=sc.nextLine();
//        }
        List<String> list = getYears(wz);
        String ens = "";
        for (String s : list) {
            ens+=(s+" ");
        }
        System.out.println(ens.substring(0,ens.length()-1));
    }

    private static List<String> getYears(String wz) {
        List<String> ens = new ArrayList<>();
        String[] split = wz.split(" ");
        for (String s : split) {
           if(pd(s)){
               ens.add(s.substring(0,4));
           }
        }
        return ens;
    }

    private static boolean pd(String s) {
        if (s.length()<4)return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                s = s.substring(i,s.length());
                break;
            }
        }
        if (s.charAt(0)>'3'||s.charAt(0)<'0')return false;
        try{
            String num = s.substring(0, 4);
            if (Integer.valueOf(num) >=1000 || Integer.valueOf(num)<=3999){
                if (s.length() == 4 ||!(s.charAt(4)>'9' && s.charAt(4)<'0'&&s.charAt(4)>'z'&&s.charAt(4)<'a'&&s.charAt(4)<'A'&&s.charAt(4)>'Z')){
                    return true;
                }
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
}
