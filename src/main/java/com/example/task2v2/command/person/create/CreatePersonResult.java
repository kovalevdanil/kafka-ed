package com.example.task2v2.command.person.create;

import com.example.task2v2.type.Position;
import lombok.Data;

@Data
public class CreatePersonResult {
    private Long id;
    private String name;
    private String companyName;
    private Position position;
}
