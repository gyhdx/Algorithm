package 秋招.网易互娱;

public class Main2 {

    public static void main(String[] args) {
        int[] a = {3,5,4};
        System.out.println(count(a));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算小易最多爬的楼层数
     * @param floors int整型一维数组 新人入职部门所在楼层列表
     * @return int整型
     */
    public static int count (int[] floors) {
        if (floors == null||floors.length<=0)return 0;
        if (floors.length==1)return getFloors(floors[0]);
        // write code here
        int[] mid = new int[floors.length];
        mid[0] = getFloors(floors[0]);
        mid[1] = getFloors(Math.max(floors[0],floors[1]));
        for (int i = 2; i < floors.length; i++) {
            mid[i] = Math.max(mid[i-1],(mid[i-2]+getFloors(floors[i])));
        }
        return mid[floors.length-1];
    }

    private static int getFloors(int floor) {

        return (floor-1)*2;
    }
}
