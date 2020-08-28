package wf.bs;

import java.util.*;

/**
 * @author wangzhao
 * @date 2020/8/8 15:48
 */
public class te {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        strings = scanner.nextLine().split(" ");
        for (String s : strings){
            list.add(Integer.parseInt(s));
            set.remove(Integer.parseInt(s));
        }
        List<Integer> result = getResult(n, list, set);
        for (int i = 0; i < result.size() - 1; i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println(result.get(result.size() - 1));
    }

    private static List<Integer> getResult(int n, List<Integer> list, Set<Integer> set) {

        List<Integer> newList = new ArrayList<> (list);

        int num = list.get(0);
        while (num > 1){
            num--;
            if (set.contains(num)){
                newList.add(0, num);
                set.remove(num);
            }
        }

        for (int i = 1; i < list.size(); i++){
            if (list.get(i) < list.get(i-1)){
                continue;
            }
            num = list.get(i-1);
            int idx = newList.indexOf(num);
            while (num++ < list.get(i)){
                if (set.contains(num)){
                    newList.add(++idx, num);
                    set.remove(num);
                }
            }
        }

        num = list.get(list.size() - 1);
        while (num < n){
            num++;
            if (set.contains(num)){
                newList.add(num);
                set.remove(num);
            }
        }
        return newList;
    }

}