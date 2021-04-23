package com.example.task2v2.cqrs;

public interface QueryHandler<R, Q extends Query<R>> {
    R handle(Q query);
}
