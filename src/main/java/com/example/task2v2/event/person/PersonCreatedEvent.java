package com.example.task2v2.event.person;

import com.example.task2v2.domain.Person;
import com.example.task2v2.es.Event;
import com.example.task2v2.readmodel.PersonDto;
import com.example.task2v2.type.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonCreatedEvent extends Event<Person> {
    private Long id;
    private String name;
    private String companyName;
    private Position position;

    @Override
    protected void applyOn(Person aggregate) {
        Objects.requireNonNull(aggregate, "Aggregate objects can't be null");

        aggregate.setId(id);
        aggregate.setName(name);
        aggregate.setCompanyName(companyName);
        aggregate.setPosition(position);
    }
}
