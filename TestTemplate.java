package com.jtl.chapter10.abstract_;

public class TestTemplate {
    public static void main(String[] args) {
        A a = new A();
        a.calculateTime();
        B b = new B();
        b.calculateTime();

    }
}


abstract class Template{
    public void calculateTime(){//抽象类的模板设计模式
        long start = System.currentTimeMillis();
        job();//动态绑定机制---与对象绑定
        long end = System.currentTimeMillis();
        System.out.println("times = " +( end - start));
    }
    public abstract void job();//抽象方法
}
