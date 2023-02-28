package com.test.onlyTest;

import com.test.LearnIOCTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * 多线程操作数据库回滚测试
 * <p>
 * 工程未引入数据库，无法测试，结果失败
 */
@Slf4j
public class MultiThreadTransactionTest extends LearnIOCTest {

    @Resource
    private PlatformTransactionManager transactionManager;

    private static final ExecutorService executorService = new ThreadPoolExecutor(5,
            30,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(5 * 2),
            new ThreadPoolExecutor.CallerRunsPolicy());


    @Test
    public void threadPoolTransactionTest() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final Item item = new Item();
            item.setCode("" + i);
            item.setName(UUID.randomUUID().toString());
            items.add(item);
        }

        this.batchInsert(items);
    }

    private void batchInsert(List<Item> items) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                int batchSize = 1000;
                for (int i = 0; i < items.size(); i += batchSize) {
                    int fromIndex = i;
                    int toIndex = Math.min(i + batchSize, items.size());
                    List<Item> subList = items.subList(fromIndex, toIndex);
                    insertBatch(subList);
                }
            }
        });
    }

    private void insertBatch(List<Item> items) {
        List<Future<Void>> futures = new ArrayList<>();
        for (Item item : items) {
            futures.add(executorService.submit(() -> {
                // 执行Insert操作
                insertItem(item);
                return null;
            }));
        }
        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                // 子线程出现异常，回滚事务
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                throw new RuntimeException(e);
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertItem(Item item) {
        // Insert操作
        //simulate exception
        if (item.getCode().equals("5")) {
            throw new RuntimeException();
        }
    }


    class Item {
        private String name;
        private String code;

        public Item() {
        }

        public Item(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;

            Item item = (Item) o;

            if (name != null ? !name.equals(item.name) : item.name != null) return false;
            return code != null ? code.equals(item.code) : item.code == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (code != null ? code.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }

}
