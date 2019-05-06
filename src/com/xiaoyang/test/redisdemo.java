package com.xiaoyang.test;

import com.xiaoyang.utils.jedisUtil;
import com.xiaoyang.utils.jedisUtil_Bundle;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * @author 小帅杨
 * @version v1.0
 * @date 2019/3/15/0015 22:18
 * @description TODO
 **/
public class redisdemo {
    @Test
    public void method01(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("name", "小帅杨");
        String name = jedis.get("name");
//        List<String> stu_map = jedis.mget("stu_map");
//////        List<String> name = jedis.hmget("stu_map","name");
        System.out.println(name);

        jedis.close();

    }

    @Test
    public void method02(){
        //使用jedis池化技术
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxTotal(50);

        JedisPool jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379);
        Jedis jedis = jedisPool.getResource();

        String set = jedis.set("name", "zhangsan");
        String name = jedis.get("name");
        System.out.println(name);

        jedisPool.close();



/*

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name", "小帅杨");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
*/

    }




    @Test
    public void method03(){
//        Jedis jedis = jedisUtil.getJedis();
        Jedis jedis = jedisUtil_Bundle.getJedis();
        String set = jedis.set("name", "hello");
        String name = jedis.get("name");
        System.out.println("name = " + name);
        jedisUtil.closeJedis(jedis);
    }
}

