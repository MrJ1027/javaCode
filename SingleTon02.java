package com.jtl.chapter10.single_;

public class SingleTon02 {
    public static void main(String[] args) {
        System.out.println(Cat.n);
        //虽然使用静态属性，类进行了加载
        // 但是并没有创建cat对象
        Cat instance = Cat.getInstance();
        System.out.println(instance);

    }

}

//饿汉式，不管你用没用对象，在类加载时就给你创建了(存在资源浪费问题）
//懒汉式,对对象的创建限制，但可能会有线程冲突
//两者区别在于创建对象的时机不同
//Runtime -- 一个单例模式的类


class Cat{
    private String name;
    public static int n = 1;
    private static Cat cat;
    //1.构造器依旧私有化
    //2.定义static属性对象
    //3.提供一个public的static方法，返回一个Cat对象
    //4.懒汉式，只有当用户使用getInstance时，才返回cat对象，而且后面再次调用时会返回上次的cat实例
    private Cat(String name){
        this.name = name;
    }
    public static Cat getInstance(){
        if(cat == null){
            cat = new Cat("小猫咪");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}