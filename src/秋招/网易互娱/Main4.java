package 秋招.网易互娱;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main4 {

    Map<Integer, ArrayList<Integer>> user = new HashMap<>();
    ArrayList<int[]> listActivity = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {1, 12};
        int[] b = {1, 0, 10};
        int[] c = {1, 2};
        int[] d = {2, 13};
        int[] f = {1, 0, 10};
        int[] g = {1, 2};
        int[] h = {1, 0, 10};
        Main4 main4 = new Main4();
        ArrayList<ArrayList<Integer>> lists = main4.testCommunity(a, b, c, d, f, g, h);
        System.out.println(lists);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 完成题目要求的功能，使用示例中的单元测试进行验证
     * @param postActivity1 int整型一维数组 发布动态
     * @param getFeed1 int整型一维数组 获取订阅
     * @param followUser int整型一维数组 关注用户
     * @param postAcvitivy2 int整型一维数组 发布动态
     * @param getFeed2 int整型一维数组 获取订阅
     * @param unfollowUser int整型一维数组 取消关注
     * @param getFeed3 int整型一维数组 获取订阅
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> testCommunity (int[] postActivity1, int[] getFeed1, int[] followUser, int[] postAcvitivy2, int[] getFeed2, int[] unfollowUser, int[] getFeed3) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        postActivity(postActivity1[0],postActivity1[1]);

        ArrayList<Integer> activity1 = getFeed(getFeed1[0],getFeed1[1],getFeed1[2]);

        followUser(followUser[0],followUser[1]);

        postActivity(postAcvitivy2[0],postAcvitivy2[1]);

        ArrayList<Integer> activity2 = getFeed(getFeed2[0], getFeed2[1], getFeed2[2]);

        unfollowUser(unfollowUser[0],unfollowUser[1]);
        ArrayList<Integer> activity3 = getFeed(getFeed3[0], getFeed3[1], getFeed3[2]);
        lists.add(activity1);
        lists.add(activity2);
        lists.add(activity3);
        return lists;
    }

    private void unfollowUser(int userId, int targetUserId) {
        if (!user.containsKey(userId)){
            return;
        }else {
            ArrayList<Integer> list = user.get(userId);
            list.remove((Integer) targetUserId);

        }
    }

    private void followUser(int userId, int targetUserId) {
        if (!user.containsKey(userId)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(targetUserId);
            list.add(userId);
            user.put(userId,list);
        }else {
            ArrayList<Integer> list = user.get(userId);
            list.add(targetUserId);
        }
    }

    private ArrayList<Integer> getFeed(int userId, int offset, int limit) {
        ArrayList<Integer> ens = new ArrayList<>();
        ArrayList<Integer> list = user.get(userId);
        for (int[] ints : listActivity) {
            if (list.contains(ints[0])){
                ens.add(ints[1]);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (offset<0||offset>=ens.size())return res;
        for (int i = offset; i<ens.size()&&i < offset+limit; i++) {
            res.add(ens.get(i));
        }
        return res;
    }

    private void postActivity(int userId, int activityId) {
        if (!user.containsKey(userId)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(userId);
            user.put(userId,list);
        }
        int[] mid = new int[2];
        mid[0] = userId;
        mid[1] = activityId;
        listActivity.add(mid);
    }
}
