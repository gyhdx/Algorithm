package wf.jianzhi_offer;

public class 不用加减乘除做加法 {
    public static void main(String[] args) {

    }

    public int Add(int num1,int num2) {
        while (num2 != 0){
            int mid = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = mid;
        }
        return num1;
    }
}
