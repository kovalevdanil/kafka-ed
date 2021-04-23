package com.example.task2v2.cqrs;

public interface Bus {
    <R, C extends Command<R>> void dispatchCommand(C command);
}
