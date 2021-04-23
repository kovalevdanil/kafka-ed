package com.example.task2v2.cqrs;

public interface CommandHandler<R, C extends Command<R>> {
    R handle(C command);
}
