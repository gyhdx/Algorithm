package test;

public class Test3 {

    public static void main(String[] args) {
        int a = 1,b = 1;
        while (a + b < 100){
            int mid = b;
            b +=a;
            a = mid;
            System.out.println(b);
        }
        System.out.println(b);
    }
}
