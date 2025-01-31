package io.github.akotu235.pkmon.bufor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BuforV2 implements Bufor {
    private final BlockingQueue<Integer> queue;

    public BuforV2(int size) {
        this.queue = new LinkedBlockingQueue<>(size);
    }

    @Override
    public void put(int i) {
        try {
            queue.put(i);
            System.out.println("P -> " + i);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Wątek przerwany podczas dodawania do kolejki.");
        }
    }

    @Override
    public int get() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Wątek przerwany podczas pobierania z kolejki.");
            return -1;
        }
    }
}
