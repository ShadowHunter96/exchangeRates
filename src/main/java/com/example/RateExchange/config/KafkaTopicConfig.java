package com.example.RateExchange.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created by User: Vu
 * Date: 17.09.2025
 * Time: 21:03
 */
@ConditionalOnProperty(value = "app.kafka.enabled", havingValue = "true")
@Configuration
public class KafkaTopicConfig {
public NewTopic amigosCodeTopic(){
    return TopicBuilder.name("amigoscode")
            .build();
}
}
