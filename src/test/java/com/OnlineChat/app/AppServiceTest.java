package com.OnlineChat.app;

import com.OnlineChat.app.service.AppService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class AppServiceTest {

    @Autowired
    AppService service;

    @Test
    public void sessionTokenTest(){
        String value =service.generateSessionToken("Santhan9");
        System.out.println(value);
        Assert.notNull(value,"value is null");


    }

    @Test
    public void createGroupTest(){
        String value1 =service.generateSessionToken("Santhan9");
        String value2 =service.generateSessionToken("Santhan8");
        String value3 =service.generateSessionToken("Santhan7");
        String value4 =service.generateSessionToken("Santhan6");
        service.createGroup(value1);
        service.createGroup(value2);
        service.createGroup(value3);
        service.createGroup(value4);
        service.match();
        service.match();
        service.postMessage(value2,"Hi M");
        service.postMessage(value1,"F");
        System.out.println(service.fetchMessages(value1));

    }
}
