package wf.jianzhi_offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class 数值的整数次方 {

    public static void main(String[] args) {
        System.out.println(Power(3, 3));

    }

    public static double Power(double base, int exponent) {
        double result=1,res=base;
        int exp;
        if (exponent>0){
            exp = exponent;
        }else if (exponent<0){
            if (base==0){
                throw new RuntimeException("分母不能为0");
            }
            exp = -exponent;
        }else {
            return 1;
        }

        while (exp!=0){
            if ((exp&1)==1){
                result*=res;
            }
            res*=base;
            exp>>=1;
        }

        return exponent>0?result:(1/result);
    }
}
