package com.lovecws.mumu.storage.fdht.service;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/8.
 */
public interface FastDHTService {

    /**
     * 设置缓存值
     * @param key 键
     * @param value 值
     * @return 0代表成功；非0出错
     */
    public int set(String key,String value);
    public int set(byte[] key, byte[] value);

    /**
     * 设置缓存值
     * @param key   键
     * @param value 值
     * @param expires 缓存时间
     * @return 0代表成功；非0出错
     */
    public int set(String key, String value,int expires);
    public int set(byte[] key, byte[] value,int expires);

    /**
     * 批量设置缓存值
     * @param keyValues
     * @param failKeys
     * @return success set key count, < 0 for all keys fail
     */
    public int batchSet(Map<String,String> keyValues, Map<String,Integer> failKeys);

    /**
     * 批量设置缓存值
     * @param keyValues
     * @param failKeys
     * @param expires 缓存时间
     * @return success set key count, < 0 for all keys fail
     */
    public int batchSet(Map<String,String> keyValues, Map<String,Integer> failKeys,int expires);

    /**
     * 删除缓存的数据
     * @param key 键
     * @return 0代表成功；非0出错
     */
    public int delete(String key);
    public int delete(byte[] key);

    /**
     * 批量删除
     * @param keys
     * @param failKeys
     * @return
     */
    public int batchDelete(String[] keys, Map<String,Integer> failKeys);

    /**
     * 获取缓存的数据
     * @param key 键
     * @return none null for success, null for fail
     */
    public String get(String key);
    public byte[] get(byte[] key);

    /**
     * 获取缓存的数据,获取完成并设置缓存时间
     * @param key 键
     * @return none null for success, null for fail
     */
    public String get(String key,int expires);
    public byte[] get(byte[] key,int expires);

    /**
     * 批量获取
     *
     * @param keys
     * @param failKeys
     * @return none null for success, null for all keys fail
     */
    public Hashtable batchGet(String[] keys, Map<String, Integer> failKeys);

    /**
     * 批量获取 获取完成并设置缓存时间
     * @param keys
     * @param failKeys
     * @param expires  缓存时间
     * @return none null for success, null for all keys fail
     */
    public Hashtable batchGet(String[] keys, Map<String, Integer> failKeys, int expires);

    /**
     * 自增
     * @param key 键
     * @param increment 增量
     * @return
     */
    public Long inc(String key,int increment);
    public Long inc(byte[] key,int increment);

    /**
     * 自增 获取完成并设置缓存时间
     * @param key       键
     * @param increment 增量
     * @param expires 缓存时间
     * @return
     */
    public Long inc(String key,int increment,int expires);
    public Long inc(byte[] key,int increment,int expires);

    /**
     *获取服务状态
     * @param server_index
     * @return stat Hashtable for success, null for fail
     */
    public Hashtable stat(int server_index);

    /**
     *
     * @return
     */
    public String[] getSubKeys();
}
