package io.github.akotu235.pkmon;

import io.github.akotu235.pkmon.bufor.Bufor;

class Producent extends Thread {
    private final Bufor _buf;
    private final int delay;

    public Producent(Bufor buf, int delay) {
        this._buf = buf;
        this.delay = delay;
    }

    public void run() {
        for (int i = 0; i < 100; ++i) {
            _buf.put(i);
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Wątek producenta został przerwany.");
            }
        }
    }
}