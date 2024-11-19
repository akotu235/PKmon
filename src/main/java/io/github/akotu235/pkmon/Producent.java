package io.github.akotu235.pkmon;

class Producent extends Thread {
    private final Bufor _buf;

    public Producent(Bufor buf) {
        this._buf = buf;
    }

    public void run() {
        for (int i = 0; i < 100; ++i) {
            _buf.put(i);
        }
    }
}