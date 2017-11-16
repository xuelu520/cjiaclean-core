package com.huazhu.hvip.redis;

import com.huazhu.hvip.util.CommonUtil;
import com.huazhu.hvip.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

import java.util.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author HUQIANBO001
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class RedisTemplate {
    public static Logger logger = LoggerFactory.getLogger(RedisTemplate.class);
    private final Object objectList = new Object();
    private final Object listFlag = new Object();
    private final Object listAdd = new Object();

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    /**
     * 设置一个key的过期时间（单位：秒）
     *
     * @param key
     *            key值
     * @param seconds
     *            多少秒后过期
     * @return 1：设置了过期时间 0：没有设置过期时间/不能设置过期时间
     */
    public long expire(String key, int seconds) {
        if (key == null || key.equals("")) {
            return 0;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.expire(key, seconds);
        } catch (Exception ex) {
            logger.error("EXPIRE error[key=" + key + " seconds=" + seconds + "]" + ex.getMessage(), ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    /**
     * 设置一个key在某个时间点过期
     *
     * @param key
     *            key值
     * @param unixTimestamp
     *            unix时间戳，从1970-01-01 00:00:00开始到现在的秒数
     * @return 1：设置了过期时间 0：没有设置过期时间/不能设置过期时间
     */
    public long expireAt(String key, long unixTimestamp) {
        if (key == null || key.equals("")) {
            return 0;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.expireAt(key, unixTimestamp);
        } catch (Exception ex) {
            logger.error("EXPIRE error[key=" + key + " unixTimestamp=" + unixTimestamp + "]" + ex.getMessage(), ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    /**
     * 截断一个List
     *
     * @param key
     *            列表key
     * @param start
     *            开始位置 从0开始
     * @param end
     *            结束位置
     * @return 状态码
     */
    public String trimList(String key, long start, long end) {
        if (key == null || key.equals("")) {
            return "-";
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.ltrim(key, start, end);
        } catch (Exception ex) {
            logger.error("LTRIM 出错[key=" + key + " start=" + start + " end=" + end + "]" + ex.getMessage(), ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return "-";
    }

    /**
     * 检查Set长度
     *
     * @param key
     * @return
     */
    public long countSet(String key) {
        if (key == null) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.scard(key);
        } catch (Exception ex) {
            logger.error("countSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    /**
     * 添加到Set中（同时设置过期时间）
     *
     * @param key
     *            key值
     * @param seconds
     *            过期时间 单位s
     * @param value
     * @return 成功true
     */
    public boolean addSet(String key, int seconds, String... value) {
        boolean result = addSet(key, value);
        if (result) {
            long i = expire(key, seconds);
            return i == 1;
        }
        return false;
    }

    /**
     * 添加到Set中
     *
     * @param key
     * @param value
     * @return
     */
    public boolean addSet(String key, String... value) {
        if (key == null || value == null) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.sadd(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("setList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * @param key
     * @param value
     * @return 判断值是否包含在set中
     */
    public boolean containsInSet(String key, String value) {
        if (key == null || value == null) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.sismember(key, value);
        } catch (Exception ex) {
            logger.error("setList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获取Set
     *
     * @param key
     * @return
     */
    public Set<String> getSet(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.smembers(key);
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 从set中删除value
     *
     * @param key
     * @return
     */
    public boolean removeSetValue(String key, String... value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.srem(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 从list中删除value 默认count 1
     *
     * @param key
     * @param values
     *            值list
     * @return
     */
    public int removeListValue(String key, List<String> values) {
        return removeListValue(key, 1, values);
    }

    /**
     * 从list中删除value
     *
     * @param key
     * @param count
     * @param values
     *            值list
     * @return
     */
    public int removeListValue(String key, long count, List<String> values) {
        int result = 0;
        if (values != null && values.size() > 0) {
            for (String value : values) {
                if (removeListValue(key, count, value)) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 从list中删除value
     *
     * @param key
     * @param count
     *            要删除个数
     * @param value
     * @return
     */
    public boolean removeListValue(String key, long count, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.lrem(key, count, value);
            return true;
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 截取List
     *
     * @param key
     * @param start
     *            起始位置
     * @param end
     *            结束位置
     * @return
     */
    public List<String> rangeList(String key, long start, long end) {
        if (key == null || key.equals("")) {
            return null;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.lrange(key, start, end);
        } catch (Exception ex) {
            logger.error("rangeList 出错[key=" + key + " start=" + start + " end=" + end + "]" + ex.getMessage(), ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 检查List长度
     *
     * @param key
     * @return
     */
    public long countList(String key) {
        if (key == null) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.llen(key);
        } catch (Exception ex) {
            logger.error("countList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    /**
     * 添加到List中（同时设置过期时间）
     *
     * @param key
     *            key值
     * @param seconds
     *            过期时间 单位s
     * @param value
     * @return
     */
    public boolean addList(String key, int seconds, String... value) {
        boolean result = addList(key, value);
        if (result) {
            long i = expire(key, seconds);
            return i == 1;
        }
        return false;
    }

    /**
     * 添加到List
     *
     * @param key
     * @param value
     * @return
     */
    public boolean addList(String key, String... value) {
        if (key == null || value == null) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.lpush(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("setList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 添加到List(只新增)
     *
     * @param key
     * @param list
     * @return
     */
    public boolean addList(String key, List<String> list) {
        if (key == null || list == null || list.size() == 0) {
            return false;
        }
        synchronized (listAdd) {//安全锁机制，防止出现缓存数据异常
            for (String value : list) {
                addList(key, value);
            }
        }
        return true;
    }

    /**
     * 获取List
     *
     * @param key
     * @return
     */
    public List<String> getList(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.lrange(key, 0, -1);
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 获取List
     *
     * @param key
     * @return
     */
    public List<String> getList(String key, Integer database) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if(null != database){
                Jedis jd = shardedJedis.getAllShards().iterator().next();
                jd.select(database);
                return jd.lrange(key, 0, -1);
            }else {
                return shardedJedis.lrange(key, 0, -1);
            }
        } catch (Exception ex) {
            logger.error("getList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 保存LIST集合
     * @param key
     * @param list
     * @param database
     * @return
     */
    public boolean setList(String key, List<String> list, Integer database) {
        ShardedJedis shardedJedis = null;
        try {
            if(CommonUtil.isNullOREmpty(key) || null==list || list.size()<=0){
                return false;
            }
            synchronized (listFlag) {//安全锁机制，防止出现缓存数据异常
                shardedJedis = shardedJedisPool.getResource();
                if (null != database) {
                    Jedis jd = shardedJedis.getAllShards().iterator().next();
                    jd.select(database);
                    jd.del(key);//清空集合
                    for (String data : list) {
                        jd.rpush(key, data);
                    }
                } else {
                    for (String data : list) {
                        shardedJedis.rpush(key, data);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            logger.error("setList error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 设置HashSet对象
     *
     * @param domain
     *            域名
     * @param key
     *            键值
     * @param value
     *            Json String or String value
     * @return
     */
    public boolean setHSet(String domain, String key, String value) {
        if (value == null)
            return false;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.hset(domain, key, value);
            return true;
        } catch (Exception ex) {
            logger.error("setHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获得HashSet对象
     *
     * @param domain
     *            域名
     * @param key
     *            键值
     * @return Json String or String value
     */
    public String getHSet(String domain, String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.hget(domain, key);
        } catch (Exception ex) {
            logger.error("getHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 删除HashSet对象
     *
     * @param domain
     *            域名
     * @param key
     *            键值
     * @return 删除的记录数
     */
    public long delHSet(String domain, String key) {
        ShardedJedis shardedJedis = null;
        long count = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            count = shardedJedis.hdel(domain, key);
        } catch (Exception ex) {
            logger.error("delHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return count;
    }

    /**
     * 删除HashSet对象
     *
     * @param domain
     *            域名
     * @param key
     *            键值
     * @return 删除的记录数
     */
    public long delHSet(String domain, String... key) {
        ShardedJedis shardedJedis = null;
        long count = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            count = shardedJedis.hdel(domain, key);
        } catch (Exception ex) {
            logger.error("delHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return count;
    }

    /**
     * 判断key是否存在
     *
     * @param domain
     *            域名
     * @param key
     *            键值
     * @return
     */
    public boolean existsHSet(String domain, String key) {
        ShardedJedis shardedJedis = null;
        boolean isExist = false;
        try {
            shardedJedis = shardedJedisPool.getResource();
            isExist = shardedJedis.hexists(domain, key);
        } catch (Exception ex) {
            logger.error("existsHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return isExist;
    }

    /**
     * 全局扫描hset
     *
     * @param match
     *            field匹配模式
     * @return
     */
    public List<Map.Entry<String, String>> scanHSet(String domain, String match) {
        ShardedJedis shardedJedis = null;
        try {
            int cursor = 0;
            shardedJedis = shardedJedisPool.getResource();
            ScanParams scanParams = new ScanParams();
            scanParams.match(match);
            Jedis jedis2 = shardedJedis.getShard(domain);
            ScanResult<Map.Entry<String, String>> scanResult;
            List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
            do {
                scanResult = jedis2.hscan(domain, String.valueOf(cursor), scanParams);
                list.addAll(scanResult.getResult());
                cursor = Integer.parseInt(scanResult.getStringCursor());
            } while (cursor > 0);
            return list;
        } catch (Exception ex) {
            logger.error("scanHSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 返回 domain 指定的哈希集中所有字段的value值
     *
     * @param domain
     * @return
     */

    public List<String> hvals(String domain) {
        ShardedJedis shardedJedis = null;
        List<String> retList = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hvals(domain);
        } catch (Exception ex) {
            logger.error("hvals error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return retList;
    }

    /**
     * 返回 domain 指定的哈希集中所有字段的key值
     *
     * @param domain
     * @return
     */

    public Set<String> hkeys(String domain) {
        ShardedJedis shardedJedis = null;
        Set<String> retList = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hkeys(domain);
        } catch (Exception ex) {
            logger.error("hkeys error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return retList;
    }

    /**
     * 返回 domain 指定的哈希key值总数
     *
     * @param domain
     * @return
     */
    public long lenHset(String domain) {
        ShardedJedis shardedJedis = null;
        long retList = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hlen(domain);
        } catch (Exception ex) {
            logger.error("hkeys error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return retList;
    }

    /**
     * 设置排序集合
     *
     * @param key
     * @param score
     * @param value
     * @return
     */
    public boolean setSortedSet(String key, long score, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.zadd(key, score, value);
            return true;
        } catch (Exception ex) {
            logger.error("setSortedSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获得排序集合
     *
     * @param key
     * @param startScore
     * @param endScore
     * @param orderByDesc
     * @return
     */
    public Set<String> getSoredSet(String key, long startScore, long endScore, boolean orderByDesc) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if (orderByDesc) {
                return shardedJedis.zrevrangeByScore(key, endScore, startScore);
            } else {
                return shardedJedis.zrangeByScore(key, startScore, endScore);
            }
        } catch (Exception ex) {
            logger.error("getSoredSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 计算排序长度
     *
     * @param key
     * @param startScore
     * @param endScore
     * @return
     */
    public long countSoredSet(String key, long startScore, long endScore) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            Long count = shardedJedis.zcount(key, startScore, endScore);
            return count == null ? 0L : count;
        } catch (Exception ex) {
            logger.error("countSoredSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0L;
    }

    /**
     * 删除排序集合
     *
     * @param key
     * @param value
     * @return
     */
    public boolean delSortedSet(String key, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            long count = shardedJedis.zrem(key, value);
            return count > 0;
        } catch (Exception ex) {
            logger.error("delSortedSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获得排序集合
     *
     * @param key
     * @param startRange
     * @param endRange
     * @param orderByDesc
     * @return
     */
    public Set<String> getSoredSetByRange(String key, int startRange, int endRange, boolean orderByDesc) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if (orderByDesc) {
                return shardedJedis.zrevrange(key, startRange, endRange);
            } else {
                return shardedJedis.zrange(key, startRange, endRange);
            }
        } catch (Exception ex) {
            logger.error("getSoredSetByRange error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 获得排序打分
     *
     * @param key
     * @return
     */
    public Double getScore(String key, String member) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.zscore(key, member);
        } catch (Exception ex) {
            logger.error("getSoredSet error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    public boolean set(String key, String value, int second) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.setex(key, second, value);
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 是否存在，指定库
     * @param key
     * @param database
     * @return
     */
    public boolean exists(String key, Integer database) {
        ShardedJedis shardedJedis = null;
        boolean result = false;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if(null != database){
                Collection<Jedis> collection=shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(database);
                result = jd.exists(key);
            }else{
                result = shardedJedis.exists(key);
            }
        } catch (Exception ex) {
            logger.error("get error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return result;
    }

    public boolean exists(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.exists(key);
        } catch (Exception ex) {
            logger.error("set error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    public boolean set(String key, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.set(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    public boolean set(String key, String value, Integer database, int second) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if(database!=null){
                Collection<Jedis> collection=shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(database);
                if(second > 0){
                    jd.setex(key, second, value);
                }else {
                    jd.set(key, value);
                }
            }else{
                if(second > 0){
                    shardedJedis.setex(key, second, value);
                }else {
                    shardedJedis.set(key, value);
                }
            }
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    public boolean set(String key, Integer database, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if(database!=null){
                Collection<Jedis> collection=shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(database);
                jd.set(key, value);
            }else{
                shardedJedis.set(key, value);
            }
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    public Object getObject(String key) {
        Object ret = null;
        ShardedJedis jedis2 = shardedJedisPool.getResource();
        try {

            // 去redis中取回序列化后的对象
            byte[] obj = jedis2.get(key.getBytes());

            // 取回的对象反序列化
            if (obj != null) {
                ret = SerializeUtil.unserialize(obj);
            }

        } catch (Exception e) {
            jedis2.close();
        } finally {
            jedis2.close();
        }
        return ret;
    }

    /**
     * 取值
     * @param key
     * @return
     */
    public String get(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.get(key);
        } catch (Exception ex) {
            logger.error("get error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    public String get(String key, String defaultValue) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.get(key) == null ? defaultValue : shardedJedis.get(key);
        } catch (Exception ex) {
            logger.error("get error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return defaultValue;
    }

    /**
     * 取值，指定库
     * @param key
     * @param database
     * @return
     */
    public String get(String key, Integer database) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            String result = null;
            if(null != database){
                Collection<Jedis> collection=shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(database);
                result = jd.get(key);
            }else{
                result = shardedJedis.get(key);
            }
            return result;
        } catch (Exception ex) {
            logger.error("get error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 取值，指定库
     * @param key
     * @param database
     * @return
     */
    public String get(String key, Integer database, String defaultValue) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            String result = null;
            if(null != database){
                Collection<Jedis> collection=shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(database);
                result = jd.get(key);
            }else{
                result = shardedJedis.get(key);
            }
            return result == null ? defaultValue : result;
        } catch (Exception ex) {
            logger.error("get error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 删除
     * @param key
     * @return
     */
    public boolean del(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.del(key);
            return true;
        } catch (Exception ex) {
            logger.error("del error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 删除 指定库
     * @param key
     * @return
     */
    public boolean del(String key, Integer database) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if(null != database){
                Collection<Jedis> collection=shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(database);
                jd.del(key);
            }else{
                shardedJedis.del(key);
            }
            return true;
        } catch (Exception ex) {
            logger.error("del error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 需要递增的key 不存在就新添加
     * @param key
     * @param second
     * @return
     */
    public long existsAndIncr(String key,int second){
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if(shardedJedis.exists(key)){
                return shardedJedis.incr(key);
            }else{
                set(key,"1",second);
            }
        } catch (Exception ex) {
            logger.error("incr error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 1;
    }

    public long incr(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.incr(key);
        } catch (Exception ex) {
            logger.error("incr error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    public long decr(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.decr(key);
        } catch (Exception ex) {
            logger.error("incr error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return 0;
    }

    private void returnBrokenResource(ShardedJedis shardedJedis) {
        try {
            if (shardedJedis == null) {
                return;
            }
            shardedJedis.close();
        } catch (Exception e) {
            logger.error("returnBrokenResource error.", e);
        }
    }

    private void returnResource(ShardedJedis shardedJedis) {
        try {
            if (shardedJedis == null) {
                return;
            }
            shardedJedis.close();
        } catch (Exception e) {
            logger.error("returnResource error.", e);
        }
    }

    public boolean hmset(String key, Map<String, String> value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.hmset(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 取值
     * @param key
     * @return
     */
    public List<String> hmget(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.hmget(key);
        } catch (Exception ex) {
            logger.error("get error.", ex);
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * REDIS中保存指定对象
     * @param
     * @return
     */

    public <T>boolean setObject(String key, Integer base, T value) {
        ShardedJedis shardedJedis = null;

        try {
            shardedJedis = shardedJedisPool.getResource();
            byte[] obj = SerializeUtil.serialize(value);
            if(null != base){
                Collection<Jedis> collection = shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(base);
                jd.set(key.getBytes(), obj);
            }else{
                shardedJedis.set(key.getBytes(), obj);
            }
            return true;
        } catch (Exception e) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * REDIS中获取指定对象
     * @param
     * @return
     */
    public <T>T getObject(String key, Integer base, Class<T> clazz) {
        T result = null;

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            byte[] obj = null;
            if(null != base){
                Collection<Jedis> collection = shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(base);
                obj = jd.get(key.getBytes());
            }else{
                obj = shardedJedis.get(key.getBytes());
            }

            if(null!=obj){
                result = (T) SerializeUtil.unserialize(obj);
            }
        } catch (Exception e) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }

        return result;
    }

    /**
     * REDIS中保存指定对象的LIST
     * @param
     * @return
     */
    public <T>boolean setListObject(String key, Integer base, List<T> list) {
        ShardedJedis shardedJedis = null;

        try {
            synchronized (objectList) {//安全锁机制，防止出现缓存数据异常
                shardedJedis = shardedJedisPool.getResource();
                if(null != base){
                    Jedis jd = shardedJedis.getAllShards().iterator().next();
                    jd.select(base);
                    jd.del(key.getBytes());//清空集合
                    if (null != list && list.size() > 0) {
                        for (T data : list) {
                            jd.rpush(key.getBytes(), SerializeUtil.serialize(data));
                        }
                    }
                }else {
                    shardedJedis.del(key.getBytes());//清空集合
                    if (null != list && list.size() > 0) {
                        for (T data : list) {
                            shardedJedis.rpush(key.getBytes(), SerializeUtil.serialize(data));
                        }
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * REDIS中获取指定对象的LIST
     * @param
     * @return
     */
    public <T>List<T> getListObject(String key, Integer base, Class<T> clazz) {
        List<T> result = new ArrayList<T>();

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            List<byte[]> list = null;
            if(null != base){
                Collection<Jedis> collection = shardedJedis.getAllShards();
                Iterator<Jedis> jedis = collection.iterator();
                Jedis jd = jedis.next();
                jd.select(base);
                list = jd.lrange(key.getBytes(), 0, -1);
            }else{
                list = shardedJedis.lrange(key.getBytes(), 0, -1);
            }

            if(null!=list && list.size()>0){
                for(byte[] data : list) {
                    result.add((T) SerializeUtil.unserialize(data));
                }
            }
        } catch (Exception e) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }

        return result;
    }

    /**
     * redis批量删除统配字符串*key*
     * @param
     * @return
     */
    public int batchDel(String preKey, Integer base) {
        int result = 0;//批量删除KEY的数量

        ShardedJedis shardedJedis = null;
        try {
            if(StringUtil.isEmpty(preKey)) return result;

            shardedJedis = shardedJedisPool.getResource();
            Set<byte[]> keySet1 = null;
            Set<String> keySet2 = null;

            Collection<Jedis> collection = shardedJedis.getAllShards();
            Iterator<Jedis> jediSet = collection.iterator();
            Jedis jd = jediSet.next();
            if(null != base){
                jd.select(base);
            }
            keySet1 = jd.keys(preKey.getBytes());
            keySet2 = jd.keys(preKey);

            result = keySet1.size() + keySet2.size();
            Iterator<byte[]> it1 = keySet1.iterator();
            while(it1.hasNext()){
                byte[] keyStr = it1.next();
                jd.del(keyStr);
            }
            Iterator<String> it2 = keySet2.iterator();
            while(it2.hasNext()){
                String keyStr = it2.next();
                jd.del(keyStr);
            }
        } catch (Exception e) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }

        return result;
    }

    /**
	 * 在REDIS中进行加锁的机制
	 * @param key 键
	 * @param time
	 * @param database 库
	 * @return
	 */
	public boolean getLock(String key, String time, int database){
		boolean result = false;
		ShardedJedis shardedJedis = null;
		if (!StringUtil.isEmpty(key)){
			try {
                shardedJedis = shardedJedisPool.getResource();
				Collection<Jedis> collection = shardedJedis.getAllShards();
                Iterator<Jedis> jediSet = collection.iterator();
                Jedis jd = jediSet.next();
                jd.select(database);
				long data = jd.setnx(key, time);
				if(1 == data) return true; // 获取锁成功
				long out = Long.parseLong(jd.get(key));
				long now = System.currentTimeMillis();
				if(out > now) return false; // 别人的锁还未超时
				long sure = Long.parseLong(jd.getSet(key, time));
				result = (sure!=out)? false : true; // 判断当前竞争锁是否成功
			} catch (Exception e) {
                returnBrokenResource(shardedJedis);
            }finally {
				returnResource(shardedJedis);
			}
		}
		return result;
	}

	/**
	 * 删除REDIS中的锁的信息
	 * @param key 键
	 * @param time
	 * @param database 库
	 * @return
	 */
	public boolean delLock(String key, long time, int database){
		boolean result = false;
		ShardedJedis shardedJedis = null;
		if (!StringUtil.isEmpty(key)){
			try {
				shardedJedis = shardedJedisPool.getResource();
				Collection<Jedis> collection = shardedJedis.getAllShards();
                Iterator<Jedis> jediSet = collection.iterator();
                Jedis jd = jediSet.next();
                jd.select(database);
				if(!jd.exists(key)) return false;
				long out = Long.parseLong(jd.get(key));
				result = (time!=out)? false : (1==jd.del(key));
			} catch (Exception e) {
                returnBrokenResource(shardedJedis);
            }finally {
				returnResource(shardedJedis);
			}
		}
		return result;
	}

    /**
     * 删除REDIS中的锁的信息
     * @param key 键
     * @param lockTime
     * @param database 库
     * @return
     */
    public Boolean addWaitLock(String key, Long lockTime, int database){
        Boolean isLock  = this.getLock(key, lockTime.toString(), database);
        while (null==isLock || !isLock) {
            try {
                Thread.sleep(50);
                lockTime = System.currentTimeMillis()+100+1;
                isLock  = this.getLock(key, lockTime.toString(), database);
            } catch (InterruptedException e) {
                logger.error("addWaitLock error.", e);
            }
        }
        return isLock;
    }
}