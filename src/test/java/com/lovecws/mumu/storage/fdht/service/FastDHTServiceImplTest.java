package com.lovecws.mumu.storage.fdht.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Hashtable;

/**
 * Created by Administrator on 2017/6/8.
 */
public class FastDHTServiceImplTest {

    private FastDHTService fastDHTService=null;
    @Before
    public void before(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-storage-fdht.xml");
        classPathXmlApplicationContext.start();
        fastDHTService = classPathXmlApplicationContext.getBean(FastDHTService.class);
    }

    @Test
    public void set(){
        int set = fastDHTService.set("ganliang123456", "lovecws");
        System.out.println(set);
    }

    @Test
    public void get() {
        String value = fastDHTService.get("ganliang123456");
        System.out.println(value);
    }

    @Test
    public void delete() {
        int value = fastDHTService.delete("ganliang123456");
        System.out.println(value);
    }

    @Test
    public void getWithExpires() {
        String value = fastDHTService.get("ganliang",1);
        System.out.println(value);
    }

    @Test
    public void stat() {
        Hashtable hashtable = fastDHTService.stat(0);
        System.out.println(hashtable);
    }

    @Test
    public void getSubKeys() {
        String[] subKeys = fastDHTService.getSubKeys();
        System.out.println(subKeys);
    }
}
