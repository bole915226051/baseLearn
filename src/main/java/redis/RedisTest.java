package redis;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.UUID;

@Component
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Jedis jedis;
    private final String MUTEX_KEY = "MUTEX_";

    public String getData(String key) throws InterruptedException {
        String value = stringRedisTemplate.opsForValue().get(key);
        //缓存失效
        if (StringUtils.isBlank(value)) {
            //设置分布式锁，只允许一个线程去查询DB，同时指定过期时间为1min，防止del操作失败，导致死锁，缓存过期无法加载DB数据
            if (tryLock(MUTEX_KEY + key, 60L)) {
                //从数据库查询数据,将查询的结果缓存起来
                value = getValueFromDB();
                stringRedisTemplate.opsForValue().set(key, value);

                //释放分布式锁
                stringRedisTemplate.delete(MUTEX_KEY + key);
            } else {
                //当锁被占用时，睡眠5s继续调用获取数据请求
                Thread.sleep(5000);
                getData(key);
            }
        }
        return value;
    }

    /**
     * redis实现分布式事务锁 尝试获取锁
     *
     * @param lockName   锁
     * @param expireTime 过期时间
     * @return
     */
    public Boolean tryLock(final String lockName, final long expireTime) {
        //RedisCallback redis事务管理，将redis操作命令放到事务中处理，保证执行的原子性
        String result = stringRedisTemplate.opsForValue().getOperations().execute(new RedisCallback<String>() {

            /**
             * @param key 使用key来当锁，因为key是唯一的。
             * @param value 请求标识，可通过UUID.randomUUID().toString()生成,解锁时通value参数可识别出是哪个请求添加的锁
             * @param nx 表示SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作
             * @param ex 表示过期时间的单位是秒
             * @param time 表示过期时间
             */
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return jedis.set(lockName, UUID.randomUUID().toString(), "NX", "EX", expireTime);
            }
        });

        if ("OK".equals(result)) {
            return true;
        }
        return false;
    }

    public String getValueFromDB() {
        return "";
    }
}

