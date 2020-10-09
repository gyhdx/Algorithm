package test;

public class StringTest {

    public static void main(String[] args) {
//        String a = "123";
//        String b = "132";
//        System.out.println(a.compareTo(b));
        String s = "  ";
        String[] s1 = s.split(" ");
        System.out.println(s1.length);
        for (String s2 : s1) {
            System.out.println("-"+s2+"-");
        }
    }
}
