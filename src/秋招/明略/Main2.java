package 秋招.明略;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static Map<Character, String> map = new HashMap<>();
    public static String[] danw = {"","拾","佰","千"};
    public static String[] d2 = {"元","万","亿"};

    static {
        map.put('0',"零");
        map.put('1',"壹");
        map.put('2',"贰");
        map.put('3',"叁");
        map.put('4',"肆");
        map.put('5',"伍");
        map.put('6',"陆");
        map.put('7',"柒");
        map.put('8',"捌");
        map.put('9',"玖");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        String s = String.valueOf(a);
        String[] split = s.split(".");
        char[] chars = split[0].toCharArray();
        String ens = "";
        int k = chars[chars.length-1];
        for (int i = 0; i < d2.length; i++) {
            ens = ens+d2[i];
            boolean flag = true;
            for (int j = 0; j < danw.length; j++) {
                if (chars[k] != '0'){
                    flag = false;
                }
                if (j ==1 && k == 0){
                    ens = danw[i] + ens;
                }else {
                    ens = map.get(chars[k--])+ danw[i] + ens;
                }
            }
        }

    }
}
