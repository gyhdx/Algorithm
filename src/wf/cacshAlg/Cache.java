package wf.cacshAlg;



import java.util.Scanner;

public class Cache {
    static Scanner sc = new Scanner(System.in);

    //指向内存中空闲块链表的首指针
    private static AllocatedBlock allocatedBlockHead=null;
    //进程分配内存块链表的首指针
    private static FreeBlock freeBlock=null;
    //最小碎片的大小
    private final static int MIN_SLICE = 10;
    //内存大小
    private final static int DEFAULT_MEM_SIZE=1024;
    //起始位置
    private final static int DEFAULT_MEM_START=0;

    //首次匹配算法
    private final static int MA_FF = 1;
    //最佳匹配算法
    private final static int MA_BF = 2;
    //最坏匹配算法
    private final static int MA_WF = 3;

    //内存大小
    private static int memSize = DEFAULT_MEM_SIZE;
    //当前分配算法
    private static int maAlgorithm = MA_FF;
    //初始pid
    private static int pid = 0;
    //设置内存大小标志
    private static int flag = 0;


    public static void main(String[] args) {

        int choise;
        pid=0;
        //初始化空闲区
        freeBlock=initFreeBlock(memSize);
        while (true){
            //显示菜单
            displayMenu();
            System.out.print("请输入选项：");
            choise = sc.nextInt();
            if (choise==1){
                //设置内存大小
                setMemSize();
            }else if(choise==2){
                //设置算法
                setAlgorithm();
                flag=1;
            }else if (choise==3){
                //创建新进程
                newProcess();
                flag=1;
            }else if(choise==4){
                //删除进程
                killProcess();
                flag=1;
            }else if (choise==5){
                //显示内存使用
                displayMemUsage();
                flag=1;
            }else if (choise==0){
                doExit();
                System.exit(0);
            }else {
                break;
            }
        }
        sc.close();
    }

    private static void doExit() {
        allocatedBlockHead=null;
        freeBlock=null;
    }

    /**
     * 初始化空闲块，默认为一块，可以指定大小及起始地址
     * @param memSize
     * @return
     */
    public static FreeBlock initFreeBlock(int memSize){
        FreeBlock freeBlock = new FreeBlock();
        if (freeBlock==null){
            System.out.println("No mem");
            return null;
        }
        freeBlock.setSize(memSize);
        freeBlock.setStartAddr(DEFAULT_MEM_START);
        freeBlock.next=null;
        return freeBlock;
    }

    /**
     * 显示菜单
     */
    public static void displayMenu(){
        System.out.println("1 - 设置内存大小 (default="+DEFAULT_MEM_SIZE+")");
        System.out.println("2 - 选择内存分配算法");
        System.out.println("3 - 新建进程");
        System.out.println("4 - 终止一个进程");
        System.out.println("5 - 显示内存使用情况 ");
        System.out.println("0 - 退出");
    }

    /**
     * 设置内存的大小
     * @return
     */
    public static int setMemSize(){
        int size;
        if (flag!=0){
            //防止重复设置
            System.out.println("Cannot set memory size again");
            return 0;
        }
        System.out.print("Total memory size =");
        size = sc.nextInt();
        if (size>0){
            memSize = size;
            freeBlock.setSize(memSize);
        }
        flag=1;
        return 1;
    }

    /**
     * 设置当前的分配算法
     */
    public static void setAlgorithm(){
        int algroithm;
        System.out.println("\t1 - First Fit");
        System.out.println("\t2 - Best Fit ");
        System.out.println("\t3 - Worst Fit");
        algroithm = sc.nextInt();
        if (algroithm>=1&&algroithm<=3){
            maAlgorithm = algroithm;
            //按指定算法重新排列空闲区链表
            rearrange(maAlgorithm);
        }
    }

    /**
     * 按指定的算法整理内存空闲块链表
     * @param maAlgorithm
     */
    private static void rearrange(int maAlgorithm) {
        if (maAlgorithm==1){
            rearrangeFF();
        }else if(maAlgorithm==2){
            rearrangeBF();
        }else if(maAlgorithm==3){
            rearrangeWF();
        }
    }

    /**
     * 按FF算法重新整理内存空闲块链表
     */
    private static void rearrangeFF() {
        FreeBlock p,p1,p2;
        FreeBlock lastFlag;
        p1=new FreeBlock();
        p1.next=freeBlock;
        //不改变p1,free_block指向头p1
        freeBlock=p1;
        if(freeBlock!=null){
            for(lastFlag=null;lastFlag!=freeBlock;lastFlag=p){
                for(p=p1=freeBlock;p1.next!=null&&p1.next.next!=null&&p1.next.next!=lastFlag;p1=p1.next){
                    if(p1.next.getStartAddr()>p1.next.next.getStartAddr()){
                    p2=p1.next.next;
                    p1.next.next=p2.next;
                    p2.next=p1.next;
                    p1.next=p2;
                    p=p1.next.next;
                    }
                }
            }
        }
        p1=freeBlock;
        freeBlock=freeBlock.next;
        p1=null;

    }

    /**
     * 按BF算法重新整理内存空闲块链表
     */
    private static void rearrangeBF() {
        FreeBlock p,p1,p2;
        FreeBlock lastFlag;
        p1=new FreeBlock();
        p1.next=freeBlock;
        //不改变p1,free_block指向头p1
        freeBlock=p1;
        if(freeBlock!=null){
            for(lastFlag=null;lastFlag!=freeBlock;lastFlag=p){
                for(p=p1=freeBlock;p1.next!=null&&p1.next.next!=null&&p1.next.next!=lastFlag;p1=p1.next){
                    if(p1.next.getSize()>p1.next.next.getSize()){
                        p2=p1.next.next;
                        p1.next.next=p2.next;
                        p2.next=p1.next;
                        p1.next=p2;
                        p=p1.next.next;
                    }
                }
            }
        }
        p1=freeBlock;
        freeBlock=freeBlock.next;
        p1=null;
    }

    /**
     * 按WF算法重新整理内存空闲块链表
     */
    private static void rearrangeWF() {
        FreeBlock p,p1,p2;
        FreeBlock lastFlag;
        p1=new FreeBlock();
        p1.next=freeBlock;
        //不改变p1,free_block指向头p1
        freeBlock=p1;
        if(freeBlock!=null){
            for(lastFlag=null;lastFlag!=freeBlock;lastFlag=p){
                for(p=p1=freeBlock;p1.next!=null&&p1.next.next!=null&&p1.next.next!=lastFlag;p1=p1.next){
                    if(p1.next.getSize()<p1.next.next.getSize()){
                        p2=p1.next.next;
                        p1.next.next=p2.next;
                        p2.next=p1.next;
                        p1.next=p2;
                        p=p1.next.next;
                    }
                }
            }
        }
        p1=freeBlock;
        freeBlock=freeBlock.next;
        p1=null;
    }

    /**
     * 创建新的进程，主要是获取内存的申请数量
     */
    public static int newProcess(){
        AllocatedBlock ab = new AllocatedBlock();
        int size,ret;
        if (ab==null){
            System.exit(-5);
        }
        ab.next=null;
        pid++;
        String name = "PROCESS-"+pid;
        ab.setProcessName(name);
        ab.setPid(pid);
        System.out.print(ab.getProcessName()+"的内存大小为:");
        size = sc.nextInt();
        if (size>0){
            ab.setSize(size);
        }
        //从空闲区分配内存，ret==1表示分配ok
        ret = allocateMem(ab);
        //如果此时allocated_block_head尚未赋值，则赋值
        if ((ret==1)&&(allocatedBlockHead == null)){
            allocatedBlockHead = ab;
            return 1;
        }
        //分配成功，将该已分配块的描述插入已分配链表
        else if (ret==1){
            ab.next=allocatedBlockHead;
            allocatedBlockHead=ab;
            return 2;
        }else if (ret==-1){
            System.out.println("Allocation fail");
            ab=null;
            return -1;
        }
        return 3;
    }

    /**
     * 分配内存模块
     * @param ab
     * @return
     */
    private static int allocateMem(AllocatedBlock ab) {

        FreeBlock fbt,pre;
        int requestSize=ab.getSize();
        fbt = pre = freeBlock;
        while ((pre!=null)&&(requestSize>pre.getSize())){
            ////遍历查找匹配空白区
            fbt=pre;
            pre=pre.next;
        }
        //pre=pre->next结尾
        if (pre==null){

            //可以空间足够
            if (memSize>=requestSize){
                freeMemRearrange(ab,memSize-requestSize,requestSize);
                memSize-=ab.getSize();
            }else {
                return -1;
            }
            //内存能满足 request_size<=pre->size
        }else {
            //找到可满足空闲分区且分配后剩余空间足够大，则分割
           if ((pre.getSize()-requestSize)>MIN_SLICE){
               pre.setSize(pre.getSize()-requestSize);
               ab.setStartAddr(pre.getStartAddr()+pre.getSize());
               //找到可满足空闲分区且但分配后剩余空间比较小，则一起分配，删除该节点
           }else {
               if (pre==fbt){
                   fbt=pre.next;
                   freeBlock=fbt;
               }else {
                   fbt.next=pre.next;
               }
               ab.setStartAddr(pre.getStartAddr());
               ab.setSize(pre.getSize());
               pre=null;
           }
            memSize-=ab.getSize();
        }

        //分配成功，按照相应算法排序
        rearrange(maAlgorithm);

        return 1;
    }

    private static void freeMemRearrange(AllocatedBlock ab, int i, int requestSize) {
        FreeBlock fb=freeBlock;
        while (fb.next!=null||fb.getSize()>requestSize){
            fb.setSize(fb.next.getSize()+fb.getSize());
            fb.next=fb.next.next;
        }
        ab.setStartAddr(fb.getStartAddr());
        ab.setSize(fb.getSize());
        freeBlock=fb.next;
    }

    /**
     * 删除进程，归还分配的存储空间，并删除描述该进程内存分配的节点
     */
    public static void killProcess(){
        AllocatedBlock ab;
        int pid;
        System.out.print("Kill Process, pid=");
        pid=sc.nextInt();
        ab=findProcess(pid);
        if (ab!=null){
            //释放ab所表示的分配区
            freeMem(ab);
            //释放ab数据结构节点
            dispose(ab);
        }
    }



    /**
     *将ab所表示的已分配区归还，并进行可能的合并
     * @param ab
     * @return
     */
    private static int freeMem(AllocatedBlock ab) {
        int algorithm = maAlgorithm;
        AllocatedBlock ab1 = allocatedBlockHead;
        FreeBlock fbt,pre,work;
        fbt = new FreeBlock();
        if (fbt==null){
            return -1;
        }
        while (ab1!=null){
            if (ab1==ab){
                ab1.next=ab.next;
                break;
            }
            ab1=ab1.next;

        }
        fbt.setSize(ab.getSize());
        fbt.setStartAddr(ab.getStartAddr());
        fbt.next=freeBlock;
        freeBlock=fbt;
        rearrange(maAlgorithm);
        // 进行可能的合并，基本策略如下
        // 1. 将新释放的结点插入到空闲分区队列末尾
        // 2. 对空闲链表按照地址有序排列
        // 3. 检查并合并相邻的空闲分区
        // 4. 将空闲链表重新按照当前算法排序

        return 1;
    }

    /**
     * 释放ab数据结构节点
     * @param freeAb
     * @return
     */
    private static int dispose(AllocatedBlock freeAb) {
        AllocatedBlock pre,ab;
        if (freeAb == allocatedBlockHead){
            //如果要释放第一个节点
            allocatedBlockHead = allocatedBlockHead.next;
            freeAb=null;
            return 1;
        }
        pre = allocatedBlockHead;
        ab = allocatedBlockHead.next;
        while(ab!=freeAb){
            pre = ab;
            ab = ab.next;
        }
        pre.next = ab.next;
        ab=null;
        return 2;
    }

    /**
     * 根据pid查询对象
     * @param pid
     * @return
     */
    private static AllocatedBlock findProcess(int pid) {
        AllocatedBlock ab = allocatedBlockHead;
        while (true){
            if (ab.getPid()==pid){
                return ab;
            }
            ab = ab.next;
        }
    }

    /**
     * 显示当前内存的使用情况，包括空闲区的情况和已经分配的情况
     */
    public static int displayMemUsage(){
        FreeBlock fbt = freeBlock;
        AllocatedBlock ab = allocatedBlockHead;
//        if (fbt==null){
//            return -1;
//        }
        System.out.println("----------------------------------------------------------");

        //显示空闲区
        System.out.println("Free Memory:");
        System.out.printf("%20s%20s\n","strar_addr","size");
        while (fbt!=null){
            System.out.printf("%20d %20d\n",fbt.getStartAddr(),fbt.getSize());
            fbt=fbt.next;
        }
        //显示已分配区
        System.out.println("Used Memory:");
        System.out.printf("%10s %20s %20s %20s\n", "PID", "ProcessName", "start_addr", " size");
        while (ab!=null){
            System.out.printf("%10d %20s %20d %20d\n",ab.getPid(),ab.getProcessName(),ab.getStartAddr(),ab.getSize());
            ab=ab.next;
        }
        System.out.println("----------------------------------------------------------");
        return 0;
    }
}
