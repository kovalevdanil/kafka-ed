package com.example.task2v2.cqrs;

import org.springframework.context.ApplicationContext;

public class CommandProvider<H extends CommandHandler<?, ?>> {
    private final ApplicationContext applicationContext;
    private final Class<H> type;

    CommandProvider(ApplicationContext applicationContext, Class<H> type) {
        this.applicationContext = applicationContext;
        this.type = type;
    }

    public H get() {
        return applicationContext.getBean(type);
    }
}