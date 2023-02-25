package com.test.infrastructure.config;

import com.test.infrastructure.aspect.filter.MdcTaskDecorator;
import com.test.infrastructure.utils.ThreadMdcUtil;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author swzxsyh
 **/
@Configuration
public class ThreadPoolConfig {

    private int corePoolSize = 50;
    private int maxPoolSize = 200;
    private int queueCapacity = 1000;
    private int keepAliveSeconds = 300;

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor() {
            @Override
            public <T> Future<T> submit(Callable<T> task) {
                // 传入线程池之前先复制当前线程的MDC
                return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
            }

            @Override
            public void execute(Runnable task) {
                super.execute(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
            }
        };

        executor.setMaxPoolSize(maxPoolSize);
        executor.setCorePoolSize(corePoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setTaskDecorator(new MdcTaskDecorator());
        // 线程池对拒绝任务(无线程可用)的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("async-thread-pool-thread-");
        executor.initialize();
        return executor;
    }

}
