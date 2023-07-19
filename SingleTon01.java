package com.jtl.chapter10.single_;

public class SingleTon01 {
    public static void main(String[] args) {
        //通过类名调用静态方法获取对象
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
    }
}

class GirlFriend {

    private String name;
    //类一旦加载，gf就创建了
    private static GirlFriend gf = new GirlFriend("小红");
    //(单例模式---饿汉式) 单个实例化对象，只实例化一次对象
    //1.构造器私有化，防止在类外随意创建...
    //2.在类内直接创建对象(static对象,为了static方法可以调用)
    //3.提供公共static方法，返回gf对象
    private GirlFriend(String name) {
        this.name = name;
    }
    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
