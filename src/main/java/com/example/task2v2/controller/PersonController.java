package com.example.task2v2.controller;

import com.example.task2v2.command.person.create.CreatePersonCommand;
import com.example.task2v2.command.person.update.UpdatePersonCommand;
import com.example.task2v2.cqrs.Bus;
import com.example.task2v2.cqrs.CQRSRegistry;
import com.example.task2v2.kafka.producer.KafkaCommandProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final Bus bus;

    public PersonController(KafkaCommandProducer commandProducer, CQRSRegistry registry, Bus bus) {
        this.bus = bus;
    }

    @PostMapping
    public void createPerson(@RequestBody CreatePersonCommand command){
        bus.dispatchCommand(command);
    }

    @PutMapping
    public void updatePerson(@RequestBody UpdatePersonCommand command){
        bus.dispatchCommand(command);
    }
}
