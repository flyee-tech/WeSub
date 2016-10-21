package com.peierlong;

import org.joda.time.LocalTime;

/**
 * 包名: com.peierlong
 * 创建人 : Elong
 * 时间: 10/21/16 10:30 AM
 * 描述 :
 */
public class HelloWorld {

    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println(currentTime);
        Greeter greeter = new Greeter();
        String hello = greeter.sayHello();
        System.out.println(hello);
    }


}
