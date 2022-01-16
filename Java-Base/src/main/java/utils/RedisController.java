package utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Redis 增删改查
 */

@RestController
@Controller
@RequestMapping("/redis")
public class RedisController {

    RRedisUtil redisUtil = new RRedisUtil();

    @GetMapping("/set")
    public String setRedis(@RequestParam String key, @RequestParam String value) {
        RRedisUtil.setRedis(key, value);
        return "插入成功";
    }

    @GetMapping("/get")
    public String getRedis(@RequestParam String key) {
        String values = redisUtil.getRedis(key);
        return values;
    }

    @GetMapping("/del")
    public String delRedis(@RequestParam String key) {
        RRedisUtil.delRedis(key);
        return "删除成功";
    }

    @GetMapping("/keys")
    public Set<String> keysRedis(@RequestParam String patten) {
        Set<String> keys = RRedisUtil.keysRedis(patten);
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println("获取Redis所有key：" + key);
        }
        return keys;
    }
}