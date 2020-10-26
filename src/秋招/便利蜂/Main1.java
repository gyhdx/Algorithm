package 秋招.便利蜂;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String template = sc.nextLine();
        int count = Integer.valueOf(sc.nextLine());
        Map<String, String> dict = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String d = sc.nextLine();
            String[] split = d.split("->");
            dict.put(split[0], split[1]);
        }
        String parse = parse(template, count, dict);
        System.out.println(parse);

    }

    public static String parse(String template,int count, Map<String, String> dict){
        if (count == 0){
            return parse(template);
        }

        return "";
    }

    private static String parse(String template) {
        if (template.length() == 0)return template;
//        char[] chars = template.toCharArray();
        String left = template.substring(0,template.indexOf("{{"));
        String mid = template.substring(template.indexOf("{{")+2,template.indexOf("}}"));
        String right = template.substring(template.indexOf("}}")+2, template.length());
        if (mid.length() == 0)return left +"{{}}"+right;
        else if (mid.length() >0)return left+mid+right;
        return null;
    }
}
