package test;

public class t1 {

    public static void main(String[] args) {
        t1 t = new t1();
        t.fun(null);
    }

    public void fun(Object o){
        System.out.println(o + "o");
    }

    public void fun(t1 t){
        System.out.println(t + "ti");
    }
}
