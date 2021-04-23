package com.example.task2v2.command.person.update;

import com.example.task2v2.cqrs.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdatePersonHandler implements CommandHandler<UpdatePersonResult, UpdatePersonCommand> {

    @Override
    public UpdatePersonResult handle(UpdatePersonCommand command) {
        return null;
    }
}

// 1. Given a command (i.e CreatePersonCommand).
// 2. Give the command to a message broker (custom deserializer)
// 3. Somehow deserialize (we need to find class by command id)