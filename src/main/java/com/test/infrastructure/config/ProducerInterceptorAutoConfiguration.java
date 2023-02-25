//package com.test.infrastructure.config;
//
//import com.test.infrastructure.aspect.interceptor.TraceContextProducerInterceptor;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerInterceptor;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @author tangtong
// * @date 2020/12/25
// */
//@ConditionalOnClass(name = "org.springframework.kafka.core.ProducerFactory")
//public class ProducerInterceptorAutoConfiguration {
//
//
//    private final KafkaProperties properties;
//
//    public ProducerInterceptorAutoConfiguration(KafkaProperties properties) {
//        this.properties = properties;
//    }
//
//    @Bean
//    public TraceContextProducerInterceptor userContextProducerInterceptor() {
//        return new TraceContextProducerInterceptor();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(ProducerFactory.class)
//    public ProducerFactory<?, ?> kafkaProducerFactory(
//            ObjectProvider<DefaultKafkaProducerFactoryCustomizer> customizers,
//            List<ProducerInterceptor> producerInterceptorList) {
//
//        List<String> interceptorNameList = producerInterceptorList.stream().map(
//                producerInterceptor -> producerInterceptor.getClass().getName()).collect(Collectors.toList());
//
//        Map<String, Object> map = this.properties.buildProducerProperties();
//        map.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptorNameList);
//
//        DefaultKafkaProducerFactory<?, ?> factory = new DefaultKafkaProducerFactory<>(map);
//        String transactionIdPrefix = this.properties.getProducer().getTransactionIdPrefix();
//        if (transactionIdPrefix != null) {
//            factory.setTransactionIdPrefix(transactionIdPrefix);
//        }
//        customizers.orderedStream().forEach((customizer) -> customizer.customize(factory));
//        return factory;
//    }
//}
