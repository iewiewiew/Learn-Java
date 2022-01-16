package utils;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

//双击redis-server.exe启动Redis：D:\workspace\Redis-x64-3.0.504\redis-server.exe
public class RRedisUtil {
    public static void main(String[] args) {
        RRedisUtil redisUtil = new RRedisUtil();

        String key = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        redisUtil.redisConn();
        setRedis(key, "小工具666");
        redisUtil.getRedis("testkey");
        delRedis(key);
        keysRedis("*");
    }


    /**
     * 连接Redis
     *
     * @return
     */
    public static Jedis redisConn() {
        Jedis jedis = new Jedis("127.0.0.1");
        if (jedis != null) {
            jedis.auth("root");  //如redis没有设置密码, 则无需添加此行
            System.out.println("连接Redis成功");
        }
        return jedis;
    }

    /**
     * 插入Redis
     *
     * @param key
     * @param value
     */
    public static void setRedis(String key, String value) {
        Jedis jedis = RRedisUtil.redisConn();
        jedis.set(key, value);
        System.out.println("set: " + jedis.get(key));
    }

    /**
     * 查询Redis
     *
     * @param key
     * @return
     */
    public String getRedis(String key) {
        Jedis jedis = RRedisUtil.redisConn();
        String values = jedis.get(key);
        System.out.println("get key=" + key + " values=" + values);
        return values;
    }

    /**
     * 删除Redis
     *
     * @param key
     */
    public static void delRedis(String key) {
        Jedis jedis = RRedisUtil.redisConn();
        jedis.del(key);
        System.out.println("del: " + key);
    }

    /**
     * 批量查询Redis
     *
     * @param patten
     * @return
     */
    public static Set<String> keysRedis(String patten) {
        Jedis jedis = RRedisUtil.redisConn();
        Set<String> keys = jedis.keys(patten);
        System.out.printf("keys：" + keys + "\n");
        return keys;
    }
}
