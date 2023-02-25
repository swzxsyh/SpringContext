package com.test.domain.eventHandler;

import com.lmax.disruptor.EventHandler;
import com.test.infrastructure.model.MessageModel;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.locks.LockSupport;


@Slf4j
public class HelloEventHandler implements EventHandler<MessageModel> {

    @Override
    public void onEvent(MessageModel event, long l, boolean b) throws Exception {
        log.info("Event Handle Start");

        LockSupport.parkNanos(1000000);

        if (Objects.nonNull(event)) {
            log.info("Event Message Not Empty:{}", event);
        }

        log.info("Event Handle End");
    }
}
