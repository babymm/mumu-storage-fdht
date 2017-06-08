package com.lovecws.mumu.storage.fdht.fastdht;

/**
 * Created by Administrator on 2017/6/8.
 */
public class FastDHTClientTest {

    public static void main(String[] args)throws Exception{
        ClientGlobal.init("fdht_client.conf");
        FastDHTClient client=new FastDHTClient(true);
        KeyInfo keyInfo= new KeyInfo("FastDHT", "FastDHT", "ganliang");
        String value= client.get(keyInfo);
        System.out.println(value);
    }
}
