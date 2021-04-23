package com.example.task2v2.kafka.producer;

import com.example.task2v2.cqrs.Command;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaCommandProducer {

    private final KafkaTemplate<Long, Command<?>> kafkaTemplate;

    public KafkaCommandProducer(KafkaTemplate<Long, Command<?>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, Long key, Command<?> command){
        kafkaTemplate.send(topic, key, command);
    }

    public void send(String topic, Command<?> command){
        kafkaTemplate.send(topic, command);
    }
}
