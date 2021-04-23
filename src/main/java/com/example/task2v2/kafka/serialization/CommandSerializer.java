package com.example.task2v2.kafka.serialization;

import com.example.task2v2.cqrs.Command;
import com.example.task2v2.cqrs.CommandInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class CommandSerializer implements Serializer<Command<?>> {

    @Override
    public byte[] serialize(String topic, Command<?> command) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            String commandId = extractCommandId(command.getClass());
            if (commandId == null){
                throw new SerializationException("Command class should be annotated with @CommandInfo");
            }

            CommandPayload<?> payload = new CommandPayload<>(commandId, command);
            String jsonString = mapper.writeValueAsString(payload);

            return jsonString.getBytes(StandardCharsets.UTF_8);

        } catch (JsonProcessingException e) {
            throw new SerializationException();
        }
    }

    private String extractCommandId(Class<?> commandClass){
        if (!commandClass.isAnnotationPresent(CommandInfo.class)){
            return null;
        }
        return commandClass.getAnnotation(CommandInfo.class).id();
    }
}
