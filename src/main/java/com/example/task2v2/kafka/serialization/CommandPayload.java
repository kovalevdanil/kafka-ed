package com.example.task2v2.kafka.serialization;

import com.example.task2v2.cqrs.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandPayload<R> {
    private String commandId;
    private Command<R> command;
}
