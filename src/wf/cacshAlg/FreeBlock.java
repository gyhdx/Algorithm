package wf.cacshAlg;

/**
 * 描述每一个空闲块的数据结构
 */
public class FreeBlock{

    FreeBlock next = null;

    private int size;
    private int startAddr;

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
}