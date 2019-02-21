package main.java.BaseAG;

/**
 * @Desc:
 * @Date: 2019/2/12 12:53  better late than never. 认真思考，不要直接就动手写
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("A");
        new Main();
        new Main();
    }

    public Main() {
        System.out.println("B");
    }

    {
        System.out.println("C--");
    }

    static {
        System.out.println("D");
    }
}