package 秋招._58同城;

public class Main2 {

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.question(100,200));
//        System.out.println(Math.sqrt(576));
    }

    public int question (int a, int b) {
        // write code here
        for (int i = 0; i < 501; i++) {
            boolean flag = true;
            if (isSqrt(i, a) && isSqrt(i, b)){
                return i;
            }
        }
        return -1;
    }

    public boolean isSqrt(int i, int value){
        int a = i + value;

        if ((int)Math.sqrt(a) * (int)Math.sqrt(a) == a){
            return true;
        }else {
            return false;
        }
    }
}
