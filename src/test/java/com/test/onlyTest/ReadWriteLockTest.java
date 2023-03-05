package com.test.onlyTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 需要实现一个高效的缓存，该缓存允许多个用户读，但只允许一个用户写，以此来保持它的完整性，如何实现
 */
public class ReadWriteLockTest {

    //定义一个缓存类，内部维护一个map用来存储数据。
    private Map<String, Object> data = new HashMap<>();
    //定义一个读写锁（ReadWriteLock），并将其作为缓存类的属性。
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 读操作时，先获取读锁，然后从map中读取数据并返回，最后释放读锁。
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        lock.readLock().lock();
        try {
            return data.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * 写操作时，先获取写锁，然后将数据写入map中，最后释放写锁。
     *
     * @param obj
     * @param value
     */
    public void put(String obj, Object value) {
        lock.writeLock().lock();
        try {
            data.put(obj, value);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
