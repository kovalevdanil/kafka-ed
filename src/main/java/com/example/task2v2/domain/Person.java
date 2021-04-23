package com.example.task2v2.domain;

import com.example.task2v2.type.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String companyName;
    private Position position;
}
