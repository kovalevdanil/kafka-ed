package com.example.task2v2.kafka.bus;

import com.example.task2v2.cqrs.Bus;
import com.example.task2v2.cqrs.Command;
import com.example.task2v2.kafka.producer.KafkaCommandProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaBus implements Bus {

    @Value("${kafka.topic.person-command}")
    private String commandTopic;

    private final KafkaCommandProducer producer;

    public KafkaBus(KafkaCommandProducer producer) {
        this.producer = producer;
    }

    @Override
    public <R, C extends Command<R>> void dispatchCommand(C command) {
        producer.send(commandTopic, command);
    }
}
