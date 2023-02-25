//package com.test.infrastructure.mq.producer.impl;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.test.infrastructure.model.dto.MessageDetail;
//import com.test.infrastructure.mq.producer.TestProducer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//@Slf4j
////@Component
//public class TestProducerImpl implements TestProducer {
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    @Value("${kafka.testTopic:first}")
//    private String responseTopic;
//
//
//    @Override
//    public void send(MessageDetail detail) {
//        String msg = toJson(detail);
//
//        kafkaTemplate.send(responseTopic, msg).addCallback(new ListenableFutureCallback() {
//            @Override
//            public void onFailure(Throwable ex) {
//                log.error("send error:{},e:", msg, ex);
//            }
//
//            @Override
//            public void onSuccess(Object result) {
//                log.info("send success:{}", msg);
//            }
//        });
//    }
//
//    private String toJson(Object obj) {
//        log.info("toJson:{}", obj.toString());
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            return objectMapper.writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            log.error("toJson error:", e);
//        }
//        return null;
//    }
//}
