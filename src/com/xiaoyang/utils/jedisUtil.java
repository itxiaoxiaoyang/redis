package com.xiaoyang.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 小帅杨
 * @version v1.0
 * @date 2019/3/15/0015 22:44
 * @description TODO
 **/
public class jedisUtil {
    private static String host;
    private static String port;
    private static int maxTotal;
    private static int maxIdle;
    private static JedisPool jedisPool;


    static {
        //类加载器加载配置文件

        InputStream inputStream = jedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            host = properties.getProperty("host");
            port = properties.getProperty("port");
            maxTotal = Integer.parseInt(properties.getProperty("maxTotal"));
            maxIdle = Integer.parseInt(properties.getProperty("maxIdle"));

            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(maxTotal);
            jedisPoolConfig.setMaxIdle(maxIdle);

            jedisPool = new JedisPool(jedisPoolConfig, host, Integer.parseInt(port));


        } catch (IOException e) {
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
