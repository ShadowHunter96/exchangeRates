package com.example.RateExchange.config;

/**
 * Created by User: Vu\
 * Date: 19.09.2025
 * Time: 22:40
 */


import org.apache.kafka.clients.consumer.ConsumerRecord;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class RateMessagesListener {

    private static final Logger log = LoggerFactory.getLogger(RateMessagesListener.class);

    @KafkaListener(topics = "amigoscode", groupId = "rate-exchange")
    public void onMessage(ConsumerRecord<String, String> record) {
        log.info("Consumed: '{}' (partition={}, offset={}, ts={})",
                record.value(), record.partition(), record.offset(), record.timestamp());
    }
}
