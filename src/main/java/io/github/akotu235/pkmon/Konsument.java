package io.github.akotu235.pkmon;

class Konsument extends Thread {
    private final Bufor _buf;

    public Konsument(Bufor buf) {
        this._buf = buf;
    }

    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println("K <- " + _buf.get());
        }
    }
}