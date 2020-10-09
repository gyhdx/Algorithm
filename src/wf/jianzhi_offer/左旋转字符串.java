package wf.jianzhi_offer;

public class 左旋转字符串 {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef",3));
    }

    public static String LeftRotateString(String str,int n) {
        if (str == null||str.length() == 0)return "";
        n = n%str.length();
        String left = str.substring(0,n);
        String right = str.substring(n,str.length());
        return right+left;
    }
}
