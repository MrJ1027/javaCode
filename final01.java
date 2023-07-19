package com.jtl.chapter10.final_;

import com.sun.javaws.IconUtil;

public class final01 {
    public static void main(String[] args) {
        AA aa = new AA();
        //aa.Pai = 0.9;error
    }
}

final class A{}//修饰类：类A不能被其他类继承（加final修饰）,但A类还是可以被实例化


class AA{
    public final double Pai = 3.14;//修饰属性：属性变为常量，无法修改;而且必须赋值，可以在定义时、代码块、构造器赋初始值
    public final void function(){//修饰方法：此方法不能被子类重写，子类只能继承父类的方法。
        System.out.println("call function");
    }
}

class BB{
    //final和static搭配使用，效率更高，不会导致类加载、底层有优化
    public final static double TAX_RATE;
    static{
        TAX_RATE = 1.0;
    }

    public BB() {
        //TAX_RATE = 1.0;
        // error!静态属性在类加载的时候就要初始化，
        // 而构造器在创建对象的时候才调用，这种情况只能在定义时赋值或者在静态代码块赋值
    }
}





