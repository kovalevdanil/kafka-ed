package com.example.task2v2.kafka.serialization;

import com.example.task2v2.cqrs.Command;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

public class CommandSerde extends Serdes.WrapperSerde<Command<?>> {
    private CommandSerde(Serializer<Command<?>> serializer, Deserializer<Command<?>> deserializer) {
        super(serializer, deserializer);
    }

    public static CommandSerde get(){
        return new CommandSerde(new CommandSerializer(), new CommandDeserializer());
    }
}
