package test;

import java.util.Random;

public class t2  {

    public static void main(String[] args) {
        Thread t = new Thread();
        Random random = new Random();
        System.out.println(random.nextInt(8));
    }
}
