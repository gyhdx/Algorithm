package test;

public class Test4 {

    public static void main(String[] args) {
        int[] arr = {2,2,2,1,3};
        int[] arr2 = {2,2,2,2};
        int[] arr3 = {};


//        int num = getNum(arr3);
        System.out.println(-12%-5);
    }

    public static int getNum(int[] arr){
        
        int num = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (num == arr[i]){
                count++;
            }else {
                count--;
                if (count == 0){
                    num = arr[i];
                    count++;
                }
            }
        }
        return num;
    }
}
