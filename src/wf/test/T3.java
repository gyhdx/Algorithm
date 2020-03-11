package wf.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T3 {

    public static void main(String[] args) {
        char[] num = "123456789".toCharArray();
        char[] str = "abcdefg".toCharArray();
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            for (char c : num) {
                lock.lock();
                System.out.println(c);
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            for (char c : str) {
                lock.lock();
                System.out.println(c);
                lock.unlock();
            }
        }).start();

    }
}
