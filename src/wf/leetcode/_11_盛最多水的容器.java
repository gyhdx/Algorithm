package wf.leetcode;

public class _11_盛最多水的容器 {

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(a));
    }

    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                area = Math.max(area, (i - j) * Math.min(height[i], height[j]));
            }
        }
        return area;
    }

    /*
    双指针，找最值
     */
    public static int maxArea2(int[] height) {
        int area = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}
