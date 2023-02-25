//package com.test.infrastructure.mq.consumer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.test.infrastructure.model.dto.MessageDetail;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Component;
//
///**
// * @author swzxsyh
// */
//@Slf4j
////@Component
//public class TestListener {
//
//    ///@KafkaListener(topics = "${kafka.testTopic:first}")
//    @KafkaListener(topics = "${kafka.testTopic:first}",autoStartup = "false")
//    public void consumerKafkaConsumer(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
//        try {
//            String value = record.value();
//            log.info("consumerKafkaConsumer value:{}", value);
//            ObjectMapper objectMapper = new ObjectMapper();
//            MessageDetail messageDetail = objectMapper.readValue(value, MessageDetail.class);
//            handle(messageDetail);
//        } catch (Exception e) {
//            log.error("consumerKafkaConsumer error:", e);
//        } finally {
//            acknowledgment.acknowledge();
//        }
//    }
//
//    private void handle(MessageDetail messageDetail) {
//        log.info("handle uuid:{}", messageDetail.getUuid());
//        log.info("handle msg:{}", messageDetail.getMsg());
//        log.info("handle msg time:{}", messageDetail.getTime());
//        log.info("handle time:{}", System.currentTimeMillis());
//    }
//}
