//package wf.leetcode;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///*
//给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
//
//如果有多个目标子集，返回其中任何一个均可。
//
// */
//public class _368_最大整除子集dp {
//
//    public static void main(String[] args) {
//        int[] m = {5,9,18,54,108,540,90,180,360,720};
//        System.out.println(largestDivisibleSubset(m));
//    }
//
//    public static List<Integer> largestDivisibleSubset(int[] nums) {
//        List<Integer> ens = new ArrayList<>();
//        if (nums.length == 0)return ens;
//        int x = 0;
//        Arrays.sort(nums);
//        ArrayList<Integer>[] mid = new ArrayList[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            mid[i] = new ArrayList<>();
//            mid[i].add(nums[i]);
//        }
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                int n = mid.get(mid.size() - 1);
//                if (nums[j]%n == 0){
//                    mid.add(nums[j]);
//                }
//            }
//            if (mid.size() > ens.size()){
//                ens = mid;
//                mid = new ArrayList<>();
//            }else {
//                mid.clear();
//            }
//        }
//        return mid[x];
//    }
//}
