package com.jtl.chapter10.abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manager jtl = new Manager("jtl", "220521128", 20000, 1000000);
        jtl.work();
        CommonEmployee cqh = new CommonEmployee("cqh", "220521129", 3000);
        cqh.work();

    }
}


abstract class Employee{
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }


    @Override
    public void work() {
        System.out.println("经理" + getName() + "工作中....");

    }
}

class CommonEmployee extends Employee{
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }
    public void work(){
        System.out.println("普通员工" + getName() + "工作中....");

    }
}



