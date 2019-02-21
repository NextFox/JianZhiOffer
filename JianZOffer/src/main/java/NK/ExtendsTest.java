package main.java.NK;

/**
 * @Desc:
 * @Date: 2019/2/16 9:54  better late than never. 认真思考，不要直接就动手写
 */
class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
}

class C extends B {
    public C() {
        System.out.println("C");
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        Object o = new Object();
        o=true;
    }
}
