package io.github.akotu235.pkmon;

import java.util.LinkedList;
import java.util.Queue;

class Bufor {
    private final Queue<Integer> queue;
    private final int size;

    public Bufor(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(int i) {
        while (queue.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Wątek przerwany podczas oczekiwania w put.");
            }
        }
        queue.add(i);
        System.out.println("P -> " + i);
        notifyAll();
    }

    public synchronized int get() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Wątek przerwany podczas oczekiwania w get.");
            }
        }
        int product = queue.poll();
        notifyAll();
        return product;
    }
}