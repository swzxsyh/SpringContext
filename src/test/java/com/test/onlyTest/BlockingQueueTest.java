package com.test.onlyTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class BlockingQueueTest {

    static final int MAX_CAPACITY = 3;
    ExecutorService executorService = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 数组有界队列，FIFO
     */
    @Test
    public void arrayBlockingQueueTest() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(MAX_CAPACITY, Boolean.FALSE);
        log.info("start Thread add Element");

        executorService.execute(() -> this.addElement(blockingQueue, MAX_CAPACITY));

        //获取元素，队列为空返回Null，不阻塞
        final Integer pool = blockingQueue.poll();
        log.info("ArrayBlockingQueue pool element: {}", pool);
        //没有元素时会阻塞，等待线程添加数据后可以获取
        final Integer take = blockingQueue.take();
        log.info("ArrayBlockingQueue take element: {}", take);

        executorService.execute(() -> this.removeElement(blockingQueue));
        //将指定元素插入队列的尾部，如果队列已满则阻塞等待。
        blockingQueue.put(100);

        log.info("ArrayBlockingQueue offer element status: {}", blockingQueue.size());
        final boolean offer = blockingQueue.offer(500);
        log.info("ArrayBlockingQueue offer element status: {}", offer);

        blockingQueue.poll();
        final int remainingCapacity = blockingQueue.remainingCapacity();
        log.info("ArrayBlockingQueue remainingCapacity: {}", remainingCapacity);
        final boolean offerAgain = blockingQueue.offer(500);
        log.info("ArrayBlockingQueue second time offer element status: {}", offerAgain);
    }

    /**
     * 链表有界队列，FIFO。如果列表为空，获取操作会进入阻塞状态
     */
    @Test
    public void LinkedBlockingQueueTest() throws InterruptedException {
        final LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(3);
        log.info("start Thread add Element");

        executorService.execute(() -> this.addElement(blockingQueue, MAX_CAPACITY));

        //获取元素，队列为空返回Null，不阻塞
        final Integer pool = blockingQueue.poll();
        log.info("LinkedBlockingQueue pool element: {}", pool);
        //没有元素时会阻塞，等待线程添加数据后可以获取
        final Integer take = blockingQueue.take();
        log.info("LinkedBlockingQueue take element: {}", take);

        executorService.execute(() -> this.removeElement(blockingQueue));
        //将指定元素插入队列的尾部，如果队列已满则阻塞等待。
        blockingQueue.put(100);

        log.info("LinkedBlockingQueue offer element status: {}", blockingQueue.size());
        final boolean offer = blockingQueue.offer(500);
        log.info("LinkedBlockingQueue offer element status: {}", offer);

        blockingQueue.poll();
        final int remainingCapacity = blockingQueue.remainingCapacity();
        log.info("LinkedBlockingQueue remainingCapacity: {}", remainingCapacity);
        final boolean offerAgain = blockingQueue.offer(500);
        log.info("LinkedBlockingQueue second time offer element status: {}", offerAgain);


    }

    /**
     * 支持优先级排序的无界队列，元素按照自然排序或指定排序，为空时获取操作进入阻塞状态
     */
    @Test
    public void priorityBlockingQueueTest() throws InterruptedException {
        final PriorityBlockingQueue<Integer> blockingQueue = new PriorityBlockingQueue<>(MAX_CAPACITY);
        log.info("start Thread add Element");
        executorService.execute(() -> this.addElement(blockingQueue, MAX_CAPACITY));

        //获取元素，队列为空返回Null，不阻塞
        final Integer pool = blockingQueue.poll();
        log.info("PriorityBlockingQueue pool element: {}", pool);
        //没有元素时会阻塞，等待线程添加数据后可以获取
        final Integer take = blockingQueue.take();
        log.info("PriorityBlockingQueue take element: {}", take);

        //将指定元素插入队列的尾部，无界队列 remainingCapacity: 2147483647
        blockingQueue.put(100);
        log.info("PriorityBlockingQueue offer element size: {}", blockingQueue.size());
        final boolean offer = blockingQueue.offer(500);
        log.info("PriorityBlockingQueue offer element status: {}", offer);

        final int remainingCapacity = blockingQueue.remainingCapacity();
        log.info("PriorityBlockingQueue remainingCapacity: {}", remainingCapacity);
    }

    /**
     * SynchronousQueue 不支持存储多条数据
     * 不存储元素的队列，用于线程之间之间传输
     * 每个插入操作必须等待另一个线程的删除操作，否则插入会一直堵塞。同理，每个删除也必须等待一个插入动作。
     * 队列由两种数据结构组成，分别是FILO的堆栈和FIFO的队列，堆栈是非公平的，队列是公平的
     */
    @Test
    public void synchronousQueueTest() throws ExecutionException, InterruptedException {
        final SynchronousQueue<String> queue = new SynchronousQueue<>(Boolean.TRUE);
        executorService.execute(() -> this.addElement(queue));
        //在调用poll方法时，如果当前没有其他线程在等待进行数据传输，那么返回的值将为null
        String poll = queue.poll();
        log.info("SynchronousQueue poll: {}", poll);
        // SynchronousQueue 内部没有一个存储元素的缓冲区，它只是在某个线程插入元素的同时，阻塞等待另一个线程来取走这个元素，因此 SynchronousQueue 的 size() 方法总是返回 0
        int size = queue.size();
        log.info("SynchronousQueue size:{}", size);
        final String result = executorService.submit(() -> this.takeElement(queue)).get();
        log.info("SynchronousQueue take Element: {}", result);
        final int remainingCapacity = queue.remainingCapacity();
        log.info("SynchronousQueue remainingCapacity:{}", remainingCapacity);
    }

    /**
     * 支持延迟获取元素的无界阻塞队列，元素只有到期才能获取。排序可以FIFO也可以自定义
     */
    @Test
    public void delayQueueTest() throws InterruptedException {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        DelayedTask delayedTask = new DelayedTask("DelayedTask-1", 1000L);
        DelayedTask poll = queue.poll();
        log.info("DelayQueue poll: {}", poll);
        queue.put(delayedTask);
        int size = queue.size();
        log.info("DelayQueue size: {}", size);
        DelayedTask take = queue.take();
        log.info("DelayQueue take: {}", take);
        int remainingCapacity = queue.remainingCapacity();
        log.info("DelayQueue remainingCapacity: {}", remainingCapacity);
    }

    private void addElement(BlockingQueue<Integer> blockingQueue, Integer maxCapacity) {
        LockSupport.parkNanos(1500000000L);
        for (int i = 0; i < 5; i++) {
            blockingQueue.add(i);
            if (blockingQueue.size() == maxCapacity) {
                break;
            }
        }
    }

    private void addElement(BlockingQueue<String> blockingQueue) {
        LockSupport.parkNanos(1000000000L);
        blockingQueue.add(UUID.randomUUID().toString());
    }

    private void removeElement(BlockingQueue<Integer> blockingQueue) {
        LockSupport.parkNanos(1500000000L);
        blockingQueue.poll();
    }

    private String takeElement(BlockingQueue<String> blockingQueue) {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    class DelayedTask implements Delayed {
        private String name;
        private Long delayTime;
        private Long expireTime;

        public DelayedTask(String name, Long delayTime) {
            this.name = name;
            this.delayTime = delayTime;
            this.expireTime = System.currentTimeMillis() + delayTime;
        }

        public String getName() {
            return name;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(expireTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }
    }
}
