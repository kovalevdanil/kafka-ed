package com.example.task2v2.command.person.update;

import com.example.task2v2.cqrs.Command;
import com.example.task2v2.cqrs.CommandInfo;
import com.example.task2v2.type.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@CommandInfo(id = "UpdatePersonCommand")
public class UpdatePersonCommand implements Command<UpdatePersonResult> {
    private Long id;
    private String name;
    private String companyName;
    private Position position;
}
