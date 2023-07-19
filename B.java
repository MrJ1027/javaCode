package com.jtl.chapter10.abstract_;

public class B extends Template{

    public void job(){
        int num = 0;
        for (long i = 1; i <= 10000; i++) {
            num *= i;
        }
    }
}
