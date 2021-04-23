package com.example.task2v2.kafka.stream.config;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class StreamConfig {

    @Bean(name = "defaultStreamsProps")
    public Properties streamsProps(@Value("${kafka.stream.bootstrap-servers}") String brokers,
                                    @Value("${kafka.stream.client-id}") String clientId,
                                    @Value("${kafka.stream.application-id}") String applicationId,
                                    @Value("${kafka.stream.interval.poll}") Integer pollInterval,
                                    @Value("${kafka.stream.interval.commit}") Integer commitInterval) {

        Properties props = new Properties();

        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        props.put(StreamsConfig.CLIENT_ID_CONFIG, clientId);
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
        props.put(StreamsConfig.POLL_MS_CONFIG, pollInterval);
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, commitInterval);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        return props;
    }

}
