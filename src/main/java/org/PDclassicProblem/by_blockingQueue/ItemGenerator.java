package org.PDclassicProblem.by_blockingQueue;

@FunctionalInterface
public interface ItemGenerator<T> {
    T generate();
}

