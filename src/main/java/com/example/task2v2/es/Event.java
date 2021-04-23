package com.example.task2v2.es;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Event<T> {
    private UUID eventId = UUID.randomUUID();
    private int version = 1;

    protected abstract void applyOn(T aggregate);
}
