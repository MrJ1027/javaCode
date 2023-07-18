package com.jtl.houserent.View;
import com.jtl.houserent.House.House;
import com.jtl.houserent.Service.HouseService;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(2);

    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("\n----------房屋出租系统----------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 显 示 房 屋 列 表");
            System.out.println("\t\t\t6    退    出");
            System.out.print("请输入你的选择（1-6）：");
            key = com.hspedu.renthouse_.utils.Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    modifyHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("选择错误！！！（1---6）请重新选择！！！");
                    break;

            }
        } while (loop);
    }

    //显示房屋列表
    public void listHouses() {

        System.out.println("-----------0房屋列表0----------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租\\未出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;//如果为null我就不玩了，直接跳出去
            }
            System.out.println(houses[i]);
        }
        System.out.println("---------0房屋显示完毕0---------");

    }

    //接受用户输入：
    public void addHouse() {
        System.out.println("-----------0添加房屋0----------");
        System.out.print("姓名：");
        String name = com.hspedu.renthouse_.utils.Utility.readString(8);
        System.out.print("电话：");
        String phone = com.hspedu.renthouse_.utils.Utility.readString(11);
        System.out.print("地址：");
        String address = com.hspedu.renthouse_.utils.Utility.readString(16);
        System.out.print("月租：");
        int rent = com.hspedu.renthouse_.utils.Utility.readInt();
        System.out.print("状态：");
        String state = com.hspedu.renthouse_.utils.Utility.readString(3);

        House house = new House(1, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("----------添加房屋成功----------");
        } else {
            System.out.println("----------添加房屋失败----------");
        }

    }

    //删除房屋
    public void delHouse() {
        System.out.println("----------删除房屋----------");
        System.out.print("请输入待删除房屋的编号(输入-1退出)：");
        this.listHouses();
        int delId = com.hspedu.renthouse_.utils.Utility.readInt();
        if (delId == -1) {
            System.out.println("----------放弃删除房屋信息----------");
            return;
        }
        char choice = com.hspedu.renthouse_.utils.Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("-----------删除房屋信息成功-----------");

            } else {
                System.out.println("----------房屋编号不存在，无法删除----------");
            }
        } else {
            System.out.println("----------放弃删除房屋信息----------");
        }
    }

    public void exit() {
        char c = com.hspedu.renthouse_.utils.Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void findHouse() {
        System.out.println("----------查找房屋信息----------");
        System.out.print("请输入待查找房屋的编号(输入-1退出)：");
        int findId = com.hspedu.renthouse_.utils.Utility.readInt();
        if (findId == -1) {
            System.out.println("----------放弃查找房屋信息----------");
            return;
        }

        House house = houseService.find(findId);
        if (house == null) {
            System.out.println("----------查找的信息不存在----------");
        } else {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租\\未出租)");
            System.out.println(houseService.find(findId));
        }

    }

    public void modifyHouse() {
        System.out.println("----------修改房屋信息----------");
        System.out.print("请输入待修改房屋的编号(输入-1退出)：");
        int modifyId = com.hspedu.renthouse_.utils.Utility.readInt();
        if (modifyId == -1) {
            System.out.println("----------放弃修改房屋信息----------");
            return;
        }
        House house = houseService.find(modifyId);
        if (house == null) {
            System.out.println("修改房屋信息编号不存在");
            return;
        }
        System.out.print("姓名（" + house.getName() + "):");
        String name = com.hspedu.renthouse_.utils.Utility.readString(8, "");
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.print("电话（" + house.getPhone() + "):");
        String phone = com.hspedu.renthouse_.utils.Utility.readString(11, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址（" + house.getAddress() + "):");
        String address = com.hspedu.renthouse_.utils.Utility.readString(16, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.println("租金（" + house.getRent() + "):");
        int rent = com.hspedu.renthouse_.utils.Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.println("状态（" + house.getState() + "):");
        String state = com.hspedu.renthouse_.utils.Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setPhone(state);
        }
        System.out.println("----------修改房屋信息成功----------");


    }


}
