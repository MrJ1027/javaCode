package com.jtl.chapter10.abstract_;

public class Abstract01 {
    public static void main(String[] args) {
        //Animal animal = new Animal("animal");'Animal' is abstract; cannot be instantiated,抽象类无法实例化
    }
}

abstract class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    //父类方法不确定---》设计为抽象方法（abstract）,就是没有实现的方法（没有方法体）。
//    public void eat(){
//        System.out.println("......");
//    }

    //public void eat();//Missing method body, or declare abstract
    public abstract void eat();//当一个类中存在抽象方法时，需要将该类声明为abstract类，但一个类是抽象类不一定要有抽象方法
    //抽象类一般来说被继承，由子类实现抽象方法
    //抽象类也是类，所以可以有类的各种成员
}

class Cat extends Animal{
    //如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类

    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {

    }
}

abstract class Text{
    //抽象方法不能使用private、final和static修饰，因为这些关键字与重写相违背
    //private abstract void f1();Illegal combination of modifiers: 'abstract' and 'private'
    //public final abstract void f1();Illegal combination of modifiers: 'final' and 'abstract'
    //public static abstract  void f1();Illegal combination of modifiers: 'abstract' and 'static'
}
