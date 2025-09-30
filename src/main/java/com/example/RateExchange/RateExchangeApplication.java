package com.example.RateExchange;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class RateExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateExchangeApplication.class, args);
	}

	@ConditionalOnProperty(value = "app.kafka.enabled", havingValue = "true")
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			kafkaTemplate.send("amigoscode","hello kafka");
		};
	}




}
