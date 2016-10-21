package com.peierlong;

import org.junit.Test;

/**
 * 包名: com.peierlong
 * 创建人 : Elong
 * 时间: 10/21/16 10:57 AM
 * 描述 :
 */
public class GreeterTest {

    private Greeter greeter = new Greeter();

    @Test
    public void greeterSaysHello() {
        System.out.println(greeter.sayHello());
    }

}
