package com.interview.corejava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class BoundedBuffer<T> {
    private final BlockingQueue<T> queue;

    public BoundedBuffer(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void put(T value) throws InterruptedException {
        queue.put(value);
    }

    public T take() throws InterruptedException {
        return queue.take();
    }

    public int size() {
        return queue.size();
    }
}
