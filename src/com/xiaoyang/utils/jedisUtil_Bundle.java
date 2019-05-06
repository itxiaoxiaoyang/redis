package com.xiaoyang.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author 小帅杨
 * @version v1.0
 * @date 2019/3/15/0015 23:10
 * @description TODO
 **/
public class jedisUtil_Bundle {
    private static String host;
    private static String port;
    private static int maxTotal;
    private static int maxIdle;
    private static JedisPool jedisPool;

    static {

        ResourceBundle jedis = ResourceBundle.getBundle("jedis");
        try {
            host = jedis.getString("host");
            port = jedis.getString("port");
            maxTotal = Integer.parseInt(jedis.getString("maxTotal"));
            maxIdle = Integer.parseInt(jedis.getString("maxIdle"));

            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(maxTotal);
            jedisPoolConfig.setMaxIdle(maxIdle);

            jedisPool = new JedisPool(jedisPoolConfig, host, Integer.parseInt(port));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void closeJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }

    }


}
