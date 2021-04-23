package com.example.task2v2.kafka.serialization;

import com.example.task2v2.command.person.create.CreatePersonCommand;
import com.example.task2v2.command.person.create.CreatePersonResult;
import com.example.task2v2.command.person.update.UpdatePersonCommand;
import com.example.task2v2.cqrs.Command;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.HashMap;
import java.util.Map;

public class CommandDeserializer implements Deserializer<Command<?>> {

    private static final String COMMAND_ID_FIELD = "commandId";
    private static final String COMMAND_FIELD = "command";

    private static final Map<String, Class<? extends Command<?>>> commandIdClass;

    static {
        commandIdClass = new HashMap<>();



    }

    @Override
    public Command<?> deserialize(String topic, byte[] data) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = new String(data);

        try {
            JsonNode jsonCommand = mapper.readTree(jsonString);

            String commandId = jsonCommand.get(COMMAND_ID_FIELD).asText();
            if (commandId == null){
                throw new SerializationException("Command payload should have field '" + COMMAND_ID_FIELD + "'");
            }

            Class<? extends Command<?>> targetClass = findCommandClassById(commandId);
            if (targetClass == null){
                throw new SerializationException("Unable to resolve command id " + commandId);
            }

            return mapper.convertValue(jsonCommand.get(COMMAND_FIELD), targetClass);
        } catch (JsonProcessingException e) {
            throw new SerializationException();
        }
    }

    private Class<? extends Command<?>> findCommandClassById(String commandId){
        return UpdatePersonCommand.class;
    }
}
