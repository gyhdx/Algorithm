package 秋招.完美世界;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建筑物个数
        int n = Integer.parseInt(sc.nextLine());
        int[][] buildings = new int[n][3];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for (int j = 0; j < arr.length; j++) {
                buildings[i][j] = Integer.parseInt(arr[j]);
            }
        }

        //获取天际线，待实现
        List<List<Integer>> skyline = getSkyline(buildings);

        //输出skyline到标准输出
        for (List<Integer> point : skyline) {
            int size = point.size();
            for (int i = 0; i < size; i++) {
                System.out.print(point.get(i));
                if (i < size-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        //todo 实现算法
        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < buildings[0].length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int right = buildings[1][i];
            map.put(buildings[0][i],buildings[2][i]);
            map.put(buildings[1][i],buildings[2][i]);
            for (int j = i+1; j < buildings[0].length; j++) {
                if (right>= buildings[0][j]&&right<=buildings[1][j]){
                    if (map.containsKey(buildings[0][j])){
                        map.put(buildings[0][j],Math.max(buildings[2][j],map.get(buildings[0][j])));
                    }else {
                        map.put(buildings[0][j],buildings[2][j]);
                    }
                    if (map.containsKey(buildings[1][j])){
                        map.put(buildings[1][j],Math.max(buildings[2][j],map.get(buildings[1][j])));
                    }else {
                        map.put(buildings[1][j],buildings[2][j]);
                    }
                }else {
                    break;
                }
            }
            list.add(map);
        }

        
        return null;
    }
}
