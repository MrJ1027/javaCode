package com.jtl.houserent.Service;

import com.jtl.houserent.House.House;

public class HouseService {
    private House[] houses;
    private int houseNums;//记录当前房屋个数;
    private int idCounter;//记录id增长值

    public HouseService(int size) {
        houses = new House[size];
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House newHouse) {
        //判断是否可以添加：
        if (houseNums == houses.length) {
            //此处可以进行扩容......
            //扩展数组，然后把原有的数据拷贝，最后把新数组地址给旧的即可
            House[] newHouses = new House[houseNums + 1];
            for (int i = 0; i < houses.length; i++) {
                newHouses[i] = houses[i];
            }
            houses = newHouses;
        }
        houses[houseNums++] = newHouse;
        //houseNums++ 上面写法更妙
        //idCounter++;
        newHouse.setId(++idCounter);
        return true;

    }

    //删除一个房屋信息：
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        //进行删除：
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;//置空最后一个
        //houseNums--;
        return true;

    }

    //查找房屋信息：
    public House find(int findId) {
        for (int i = 0; i < houseNums; i++) {
            if (houses[i].getId() == findId) {

                return houses[i];
            }
        }
        return null;
    }
}
