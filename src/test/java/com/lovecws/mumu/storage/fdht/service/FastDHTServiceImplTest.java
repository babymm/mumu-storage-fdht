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
        for (int i = 0; i < 10000; i++) {
            int value = fastDHTService.set("ganliang"+i, "lovecws"+i);
            System.out.println(i + ":set:" + value);
        }
    }

    @Test
    public void get() {
        for(int i=0;i<1000;i++){
            String value = fastDHTService.get("ganliang"+i);
            System.out.println(i+":get:"+value);
        }
    }

    @Test
    public void delete() {
        int value = fastDHTService.delete("ganliang");
    }

    @Test
    public void getWithExpires() {
        String value = fastDHTService.get("ganliang",1);
        System.out.println(value);
    }

    @Test
    public void stat() {
        Hashtable hashtable = fastDHTService.stat(1);
        System.out.println(hashtable);
    }

    @Test
    public void getSubKeys() {
        String[] subKeys = fastDHTService.getSubKeys();
        System.out.println(subKeys);
    }
}
