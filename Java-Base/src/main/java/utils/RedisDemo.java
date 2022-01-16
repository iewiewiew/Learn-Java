package utils;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }


    /**
     * 启动Redis：D:\software\redis-2.8.9\redis-server.exe redis.windows.conf
     */
    @Test
    public void test1() {
        Jedis jedis = new Jedis("127.0.0.1");
        if (jedis != null) {
            jedis.auth("root");
            System.out.println("连接Redis成功");
        }
        System.out.println("服务器运行状态: " + jedis.ping());
    }


    @Test
    public void test2() {
        Jedis jedis = new Jedis("127.0.0.1");
        if (jedis != null) {
            jedis.auth("root");
            System.out.println("连接Redis成功");
        }

        jedis.set("testkey", "设置Redis字符串数据");
        System.out.println("获取存储的数据并输出: " + jedis.get("testkey"));
    }


    @Test
    public void test3() {
        Jedis jedis = new Jedis("127.0.0.1");
        if (jedis != null) {
            jedis.auth("root");
            System.out.println("连接Redis成功");
        }

        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println("获取Redis所有key：" + key);
        }
    }


    @Test
    public void test4() {
        Jedis jedis = new Jedis("127.0.0.1");
        if (jedis != null) {
            jedis.auth("root");
            System.out.println("连接Redis成功");
        }

        //存储数据到列表中
        jedis.lpush("jedis-list", "Redis");
        jedis.lpush("jedis-list", "Mongodb");
        jedis.lpush("jedis-list", "Mysql");
        //获取存储的数据并输出
        List<String> list = jedis.lrange("jedis-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("jedis-list的values为: " + list.get(i));
        }
    }


    @Test
    public void test5() {
        Jedis jedis = new Jedis("127.0.0.1");
        if (jedis != null) {
            jedis.auth("root");
            System.out.println("连接Redis成功");
        }
        System.out.println("查看key所储存的值的类型：" + jedis.type("testkey"));
    }


    @Test
    public void test6() {
        Jedis jedis = new Jedis("127.0.0.1");
        if (jedis != null) {
            jedis.auth("root");
            System.out.println("连接Redis成功");
        }

        System.out.println("=============增=============");
        System.out.println("zset中添加元素element001：" + jedis.zadd("zset", 7.0, "element001"));
        System.out.println("zset中添加元素element002：" + jedis.zadd("zset", 8.0, "element002"));
        System.out.println("zset中添加元素element003：" + jedis.zadd("zset", 2.0, "element003"));
        System.out.println("zset中添加元素element004：" + jedis.zadd("zset", 3.0, "element004"));
        System.out.println("zset集合中的所有元素：" + jedis.zrange("zset", 0, -1));//按照权重值排序
        System.out.println();

        System.out.println("=============查=============");
        System.out.println("统计zset集合中的元素中个数：" + jedis.zcard("zset"));
        System.out.println("统计zset集合中权重某个范围内（1.0——5.0），元素的个数：" + jedis.zcount("zset", 1.0, 5.0));
        System.out.println("查看zset集合中element004的权重：" + jedis.zscore("zset", "element004"));
        System.out.println("查看下标1到2范围内的元素值：" + jedis.zrange("zset", 1, 2));
    }


    @Test
    public void test7() {
        //连接池
        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);

        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth("root");

            System.out.println("插入操作前，全部Key值：" + jedis.keys("*"));
            Pipeline p = jedis.pipelined();
            //插入多条数据
            for (Integer i = 0; i < 10; i++) {
                p.set(i.toString(), i.toString());
            }
            //获取所有的response
            p.sync();
            System.out.println("插入操作后，全部Key值：" + jedis.keys("*"));

            //删除多条数据
            for (Integer i = 0; i < 5; i++) {
                p.del(i.toString());
            }
            p.sync();
            System.out.println("删除操作后，全部Key值：" + jedis.keys("*"));

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}