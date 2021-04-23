package com.example.task2v2.command.person.create;

import com.example.task2v2.cqrs.CommandHandler;

public class CreatePersonHandler implements CommandHandler<CreatePersonResult, CreatePersonCommand> {
    @Override
    public CreatePersonResult handle(CreatePersonCommand command) {
        return null;
    }
}
