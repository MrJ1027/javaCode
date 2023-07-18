package com.jtl.chapter10.main_;

import sun.applet.Main;

public class Main01 {
    private int n1 = 100;
    private static  int n2 = 200;

    public void f1(){
        System.out.println("f1 called");
    }
    public static void f2(){
        System.out.println("f2 called");
    }
    public static void main(String[] args) {
        //静态方法中不能调用非静态成员
        //System.out.println(n1);
        //f1();
        //静态方法可以调用静态成员
        System.out.println(n2);
        f2();
        //通过创建对象在静态方法中调用非静态成员
        Main01 main01 = new Main01();
        main01.f1();
        System.out.println(main01.n1);
    }
}
