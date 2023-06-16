//package com.online.travel.search.config;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.online.travel.search.dto.HotelDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//@EnableConfigurationProperties
//public class Consumer {
//
//    @Value("${kafka.topic}")
//    private String hotelTopic;
//
//    private final ObjectMapper objectMapper;
//
//    @Autowired
//    public Consumer(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @KafkaListener(topics = "${kafka.topic}")
//    public HotelDto consumeMessage(String message) throws JsonProcessingException {
//        log.info("message consumed {}", message);
//        log.info("topic {}", hotelTopic);
//
//        HotelDto hotelDto = objectMapper.readValue(message, HotelDto.class);
//        return hotelDto;
//    }
//
//}
