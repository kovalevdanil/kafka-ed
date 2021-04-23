package com.example.task2v2.controller;

import com.example.task2v2.command.person.create.CreatePersonCommand;
import com.example.task2v2.command.person.update.UpdatePersonCommand;
import com.example.task2v2.cqrs.CQRSRegistry;
import com.example.task2v2.cqrs.Command;
import com.example.task2v2.kafka.producer.KafkaCommandProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Value("${kafka.topic.person-command}")
    private String personCommandTopic;

    private final KafkaCommandProducer commandProducer;
    private final CQRSRegistry registry;

    public PersonController(KafkaCommandProducer commandProducer, CQRSRegistry registry) {
        this.commandProducer = commandProducer;
        this.registry = registry;
    }

    @PostMapping
    public void createPerson(@RequestBody CreatePersonCommand command){
        commandProducer.send(personCommandTopic, command);
    }

    @PutMapping
    public void updatePerson(@RequestBody UpdatePersonCommand command){
        commandProducer.send(personCommandTopic, command);
    }
//
//    @GetMapping
//    public List<PersonDto> getPersons(){
//        // NOSONAR
//        return null;
//    }
}
