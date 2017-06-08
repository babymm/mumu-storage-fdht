package com.lovecws.mumu.storage.fdht.service;

import com.lovecws.mumu.storage.fdht.fastdht.ClientGlobal;
import com.lovecws.mumu.storage.fdht.fastdht.FastDHTClient;
import com.lovecws.mumu.storage.fdht.fastdht.KeyInfo;
import com.lovecws.mumu.storage.fdht.fastdht.ObjectInfo;
import org.apache.log4j.Logger;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Administrator on 2-117/6/8.
 */
public class FastDHTServiceImpl implements FastDHTService{

    private static final Logger log = Logger.getLogger(FastDHTServiceImpl.class);

    private static FastDHTClient fastdht=null;

    @Override
    public int set(String key, String value) {
        try {
            return fastdht.set(new KeyInfo(namespace, objectId, key), value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int set(byte[] key, byte[] value) {
        try {
            return fastdht.set(new KeyInfo(namespace.getBytes(), objectId.getBytes(), key), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int set(String key, String value, int expires) {
        try {
            return fastdht.set(new KeyInfo(namespace, objectId, key), value,expires);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int set(byte[] key, byte[] value, int expires) {
        try {
            return fastdht.set(new KeyInfo(namespace.getBytes(), objectId.getBytes(), key), value, expires);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int batchSet(Map<String, String> keyValues, Map<String, Integer> failKeys) {
        try {
            return fastdht.batchSet(new ObjectInfo(namespace,objectId),keyValues,failKeys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int batchSet(Map<String, String> keyValues, Map<String, Integer> failKeys, int expires) {
        try {
            return fastdht.batchSet(new ObjectInfo(namespace, objectId), keyValues, failKeys, expires);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(String key) {
        try {
            return fastdht.delete(new KeyInfo(namespace,objectId,key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(byte[] key) {
        try {
            return fastdht.delete(new KeyInfo(namespace.getBytes(), objectId.getBytes(), key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int batchDelete(String[] keys, Map<String, Integer> failKeys) {
        try {
            return fastdht.batchDelete(new ObjectInfo(namespace, objectId), keys, failKeys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String get(String key) {
        try {
            return fastdht.get(new KeyInfo(namespace, objectId, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] get(byte[] key) {
        try {
            String value = fastdht.get(new KeyInfo(namespace.getBytes(), objectId.getBytes(), key));
            return value!=null?value.getBytes(ClientGlobal.charset):null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[-1];
    }

    @Override
    public String get(String key, int expires) {
        try {
            return fastdht.get(new KeyInfo(namespace, objectId, key), expires);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] get(byte[] key, int expires) {
        try {
            String value = fastdht.get(new KeyInfo(namespace.getBytes(), objectId.getBytes(), key), expires);
            return value!=null?value.getBytes(ClientGlobal.charset):null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[-1];
    }

    @Override
    public Hashtable batchGet(String[] keys, Map<String, Integer> failKeys) {
        try {
            return fastdht.batchGet(new ObjectInfo(namespace,objectId),keys,failKeys);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Hashtable batchGet(String[] keys, Map<String, Integer> failKeys, int expires) {
        try {
            return fastdht.batchGet(new ObjectInfo(namespace, objectId), keys, failKeys,expires);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long inc(String key, int increment) {
        try {
            return fastdht.inc(new KeyInfo(namespace,objectId,key),increment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long inc(byte[] key, int increment) {
        try {
            return fastdht.inc(new KeyInfo(namespace.getBytes(), objectId.getBytes(), key), increment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long inc(String key, int increment, int expires) {
        try {
            return fastdht.inc(new KeyInfo(namespace, objectId, key), increment,expires);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long inc(byte[] key, int increment, int expires) {
        try {
            return fastdht.inc(new KeyInfo(namespace.getBytes(), objectId.getBytes(), key), increment, expires);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Hashtable stat(int server_index) {
        try {
            return fastdht.stat(server_index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String[] getSubKeys() {
        try {
            return fastdht.getSubKeys(new ObjectInfo(namespace,objectId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[-1];
    }

    /**
     * 初始化fastdht连接
     */
    public void init() {
        try {
            ClientGlobal.init(configPath);
            fastdht = new FastDHTClient(true);
            log.info("fastdht分布式缓存系统初始化完毕");
        } catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * 关闭的时候 断开fastdht连接
     */
    public void destory() {
        try {
            if (fastdht != null) {
                fastdht.close();
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    private String configPath;//fastdfs 客户端配置文件
    private String namespace;//fastdht命名空间(类似于关系型数据库的 database数据库)
    private String objectId;//对象（类似于关系型数据库的 table表）

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @SuppressWarnings("unused")
    private FastDHTServiceImpl() {
        super();
    }

    public FastDHTServiceImpl(String configPath) {
        this.configPath = configPath;
    }
}
