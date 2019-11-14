package wf.cacshAlg;

/**
 * 每个进程分配到的内存块的描述
 */
public class AllocatedBlock {

    AllocatedBlock next=null;

    private int pid;
    private int size;
    private int startAddr;
    private String processName;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartAddr() {
        return startAddr;
    }

    public void setStartAddr(int startAddr) {
        this.startAddr = startAddr;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
