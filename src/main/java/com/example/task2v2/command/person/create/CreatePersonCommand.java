package com.example.task2v2.command.person.create;

import com.example.task2v2.cqrs.Command;
import com.example.task2v2.cqrs.CommandInfo;
import com.example.task2v2.domain.Person;
import com.example.task2v2.type.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@CommandInfo(id = "CreatePersonCommand")
public class CreatePersonCommand implements Command<CreatePersonResult> {
    private String name;
    private String companyName;
    private Position position;
}
