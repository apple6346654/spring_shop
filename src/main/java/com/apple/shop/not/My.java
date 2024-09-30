package com.apple.shop.not;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class My {
    private String name ;
    private int age ;


    public int ageadd(){
        return this.age = age+1;
    }

    public int agechange(int age){
        return this.age = age;
    }


    public static void main(String[] args) {
        My my = new My();

        my.setName("정성윤");
        my.setAge(10);

        System.out.println(my.getName());
        System.out.println(my.getAge());


        my.ageadd();
        System.out.println(my.age);

        my.agechange(20);
        System.out.println(my.age);

    }


}
