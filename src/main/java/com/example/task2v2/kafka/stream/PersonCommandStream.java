package com.example.task2v2.kafka.stream;

import com.example.task2v2.cqrs.Command;
import com.example.task2v2.kafka.serialization.CommandSerde;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Slf4j
@Component
public class PersonCommandStream {

    private KafkaStreams kafkaStreams;
    private StreamsBuilder streamsBuilder;
    private Properties streamsProps;

    @Value("${kafka.topic.person-command}")
    private String inputTopic;

    @Value("${kafka.topic.person-event}")
    private String outputTopic;


    @Autowired
    public PersonCommandStream(@Qualifier("defaultStreamsProps") Properties streamsProps){
        this.streamsProps = streamsProps;
        this.streamsBuilder = new StreamsBuilder();
    }

    @PostConstruct
    public void startStreaming(){

        streamsBuilder
                .stream(inputTopic, Consumed.with( Serdes.Long(), CommandSerde.get()))
                .peek((k, v) -> log.info("Key = {}, Value = {}", k, v))
                .to(outputTopic, Produced.with(Serdes.Long(), CommandSerde.get()));

        kafkaStreams = new KafkaStreams(streamsBuilder.build(), streamsProps);
        kafkaStreams.start();
    }
}
