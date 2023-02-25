package com.test.domain.factory;

import com.lmax.disruptor.EventFactory;
import com.test.infrastructure.model.MessageModel;

public class HelloEventFactory implements EventFactory<MessageModel> {

    @Override
    public MessageModel newInstance() {
        return new MessageModel();
    }
}
