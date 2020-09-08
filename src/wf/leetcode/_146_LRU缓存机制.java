package wf.leetcode;

import java.util.HashMap;

public class _146_LRU缓存机制 {


}

class Node{
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
        next = null;
    }
}

class LRUCache{

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int size, capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (size <=0)return -1;
        return map.get(head.value);
    }

    public void put(int key, int value) {
        if (!map.keySet().contains(key)){
            map.put(key, value);
            Node node = new Node(key);
            node.next = head;
            head = node;
            if (size == 0){
                tail = node;
            }
            if (size == capacity){

            }
            size++;
        }
    }
}
