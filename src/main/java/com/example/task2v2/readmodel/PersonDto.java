package com.example.task2v2.readmodel;

import com.example.task2v2.type.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private String companyName;
    private Position position;
}
