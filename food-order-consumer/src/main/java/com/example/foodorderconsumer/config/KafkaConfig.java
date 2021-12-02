package com.example.foodorderconsumer.config;

import com.example.foodorderconsumer.error.handler.FoodOrderErrorHandler;
import com.example.foodorderconsumer.error.handler.GlobalErrorHandler;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaProducerException;

import java.util.Map;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 6:39 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderconsumer.config
 * To change this template use File | Settings | File and Code Template
 */
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    @Bean(value = "kafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Object, Object> kafkaListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer){
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        configurer.configure(factory, consumerFactory());
        factory.setErrorHandler(new GlobalErrorHandler());
        return factory;

    }

    @Bean
    public ConsumerFactory<Object, Object> consumerFactory() {
        Map<String,Object> properties = kafkaProperties.buildConsumerProperties();
        properties.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "12000");
        return new DefaultKafkaConsumerFactory<Object, Object>(properties);
    }
}
