package 秋招.顺网;

public class Main1 {

    public static void main(String[] args) {
        int[] list = {5, 7, 1, 8, 4, 10, 2};
//        changSort(list);//选择排序
        mpSort(list);//冒泡排序
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    private static void mpSort(int[] list) {
        boolean flag = true;
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]){
                    swap(list,j,j+1);
                    flag = false;
                }
            }
            if (flag)
                break;

        }
    }

    //选择排序
    private static void changSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int mid = i;
            for (int j = i + 1; j < list.length; j++)
                if (list[mid] > list[j])
                    mid = j;
            swap(list, mid, i);
        }
    }

    private static void swap(int[] list, int mid, int i) {
        int x = list[i];
        list[i] = list[mid];
        list[mid] = x;
    }
}
