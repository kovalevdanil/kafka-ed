package com.example.task2v2.controller;

import com.example.task2v2.command.person.create.CreatePersonCommand;
import com.example.task2v2.command.person.update.UpdatePersonCommand;
import com.example.task2v2.readmodel.PersonDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @PostConstruct
    public void createPerson(@RequestBody CreatePersonCommand command){

    }

    @PutMapping
    public void updatePerson(@RequestBody UpdatePersonCommand command){

    }

    @GetMapping
    public List<PersonDto> getPersons(){

        return null;
    }
}
