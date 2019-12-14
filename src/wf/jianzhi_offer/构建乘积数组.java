package wf.jianzhi_offer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class 构建乘积数组 {

    public static void main(String[] Args) {
        int[] A = new int[]{1,2,3,4};//{24,12,8,6}
        int[] ints = multiply2(A);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] multiply(int[] A) {
        int[]b = new int[A.length];
        int[][] Arr = new int[A.length][A.length];
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[0].length; j++) {
                if (i!=j){
                    Arr[i][j]=A[j];
                }else {
                    Arr[i][j]=1;
                }
            }
            b[i]=1;
        }
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[0].length; j++) {
                b[i]*=Arr[i][j];
            }
        }

        return b;
    }
    public static int[] multiply2(int[] A) {
        int[]b = new int[A.length];

        if (A.length>0){
            b[0]=1;
            for (int i = 1; i < A.length; i++) {
                b[i] = b[i-1]*A[i-1];
            }
            int f=1;
            for (int i=A.length-2;i>=0;i--){
                f=f*A[i+1];
                b[i]*=f;
            }
        }
        return b;
    }
}
