package wf.jianzhi_offer;

/*
题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 数值为0或者字符串不是一个合法的数值则返回0
 */
public class JZ49把字符串转换成整数 {
    public static void main(String[] args) {
        System.out.println(StrToInt(" 2147483649"));
    }

    public static int StrToInt(String str) {
        String mid = str.replace(" ", "");
        if (str == null || str.length() == 0)return 0;
        char[] chars = mid.toCharArray();
        int signal = 0;
        int i = 0;
        if (chars[0]=='-'||chars[0]=='+'){
            i=1;
            if (chars[0] == '+')
                signal = 1;
            else
                signal = -1;
        }else if (chars[0] >= '0' && chars[0]<='9'){
            i=0;
            signal = 1;
        }else
            return 0;
        int ens = 0;
        for (; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i]<='9') {
                if (ens > Integer.MAX_VALUE / 10 && i + 1 < chars.length) {
                    return 0;
                }
                ens = ens * 10 + (chars[i] - '0');
            }else {
                return 0;
            }
        }
        if (signal > 0)
                return ens <= 0?0:ens*signal;
        else
            return ens == Integer.MIN_VALUE?ens:ens*signal;
    }
}
