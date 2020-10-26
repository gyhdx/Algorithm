package wf.leetcode;

public class _739_每日温度 {

    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(t);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] ens = new int[T.length];

        for (int i = 0; i < T.length-1; i++) {
            int mid = getEns(i,T);
            if (mid >0){
                ens[i] = mid;
            }else {
                ens[i] = 0;
            }
        }
        return ens;
    }

    private static int getEns(int i, int[] num) {
        for (int j = i+1; j < num.length; j++) {
            if (num[j] > num[i]){
                return j-i;
            }
        }
        return -1;
    }
}
