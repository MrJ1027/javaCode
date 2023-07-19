package com.jtl.chapter10.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        double d1 = new Circle(5).countArea();
        System.out.println(d1);
    }
}

class Circle{
    private double radius;
    private final double PI = 3.14;
    public Circle(double radius){
        this.radius = radius;
    }
    public double countArea(){
        return PI * radius * radius;
    }

    public int addOne(final int x){
        //++x;//error,final 不可修改
        return x + 1;//可以，没修改final
    }
}
