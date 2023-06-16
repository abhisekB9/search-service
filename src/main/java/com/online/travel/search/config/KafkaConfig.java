//package com.online.travel.search.config;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.core.*;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableConfigurationProperties
//public class KafkaConfig {
//
//    @Value("${kafka.topic}")
//    private String hotelTopic;
//
//    private final KafkaProperties kafkaProperties;
//    private final ConsumerApplicationProperties consumerApplicationProperties;
//
//    @Autowired
//    public KafkaConfig(KafkaProperties kafkaProperties, ConsumerApplicationProperties consumerApplicationProperties) {
//        this.kafkaProperties = kafkaProperties;
//        this.consumerApplicationProperties = consumerApplicationProperties;
//    }
//
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public ModelMapper modelMapper() {
//        return new ModelMapper();
//    }
//
//    @Bean
//    public NewTopic adviceTopic() {
//        return new NewTopic(consumerApplicationProperties.getTopic(), 3, (short) 1);
//    }
//
//    @Bean
//    public ConsumerFactory<String, Object> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(
//                kafkaProperties.buildConsumerProperties());
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//
//        return factory;
//    }
//}
//
