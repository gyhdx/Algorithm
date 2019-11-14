package wf.qt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class 银行家算法 {


    private static AtomicInteger atomic = new AtomicInteger(0);
        // 需要最大资源数
//        int[][] max = new int[5][3];
        private static int[][] max = {{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};
        // 以拥有的资源数
//        int[][] allocation = new int[5][3];
        private static int[][] allocation = {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};
        // 还需要的资源数
        private static int[][] need = new int[5][3];

        // 可用资源数
//        int[] available = new int[3];
        private static volatile int[] available = {3,3,2};

        //中间过程
        private static int[][] work = new int[5][3];

        private static boolean[] finish = new boolean[5] ;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("   work      need     allocation   work+allocation   finish");
        //计算need
        for (int i = 0; i < max.length; i++) {
            for (int j = 0; j < max[0].length; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
            finish[i] = false;
        }

//        print();
//        for (int i = 0; i < need.length; i++) {
//            new Thread(()->{
//                int flg = atomic.get();
//                atomic.getAndIncrement();
//                int a=3;
//                while ((a--)>0){
//                    try {
//                        doThreads(flg);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//
//            }).start();
//         }
        int falg=0,n=0;
        while (falg < 5){
            int i=doJudge2(n,need,available,finish);
//            n=i;
            if (i!=-1){
                m1(i);
                System.out.print(i+"  ");
                print(i);
            }
            falg++;
        }
//        Thread.currentThread().join(2000);
        if (isSafe()){
            System.out.println("系统处于安全状态");
        }else {
            System.out.println("系统处于不安全状态");
        }


    }

    //进行线程中的逻辑
    private static synchronized void doThreads(int flg) throws InterruptedException {
        if (doJudge(flg,need[flg],available,finish)){
//            System.out.println("flg = "+flg);
            m1(flg);
            print(flg);
//            Thread.currentThread().interrupt();
        }else {
//            Thread.sleep(10);
        }
    }

    //模拟资源的分配及回收
    private static void m1(int i) {
        for (int j = 0; j < work[0].length; j++) {
            work[i][j] = available[j];
            available[j] = available[j]+allocation[i][j];
            finish[i] = true;
        }
    }

    //多线程下判断当前线程是否可以获得资源
    private static synchronized boolean doJudge(int local,int[] need,int[] allocation,boolean[] finish){
        int flag;

            flag=0;
            for (int j = 0; j < need.length; j++) {
                if (!finish[local] && need[j]<=allocation[j]){
                    flag ++;
                }
            }
            if (flag == 3){
                return true;
            }



        System.out.println("thread "+local+" --- is over");
        return false;
    }

    //单线程下判断当前线程是否可以获得资源
    private static int doJudge2(int local,int[][] need,int[] allocation,boolean[] finish){
        int flag;
        for (int i = local; i < need.length; i++) {
            flag=0;
            for (int j = 0; j < need[0].length; j++) {
                if (!finish[i] && need[i][j]<=allocation[j]){
                    flag ++;
                }
            }
            if (flag == 3){
                return i;
            }
        }
        return -1;
    }

    //用于输出结果
    private static void print(int i){
        String workStr="";
        String needStr="";
        String allocStr="";
        String toolStr="";


            for (int j = 0; j < max[0].length; j++) {
                workStr += work[i][j]+" ";
                needStr += need[i][j]+" ";
                allocStr += allocation[i][j]+" ";
                toolStr += (work[i][j]+allocation[i][j])+" ";
            }
            System.out.println(i+"  "+workStr+"   "+needStr+"     "+allocStr+"       "+toolStr+"           "+finish[i]);
            workStr="";
            needStr="";
            allocStr="";
            toolStr="";

    }
    private static boolean isSafe(){
        boolean flag=true;
        for (int i = 0; i < finish.length; i++) {
            if (!finish[i]){
                flag=false;
            }
        }
        return flag;
    }
}
