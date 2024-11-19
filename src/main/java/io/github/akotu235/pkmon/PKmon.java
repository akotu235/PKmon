package io.github.akotu235.pkmon;

// PKmon.java

class Producent extends Thread {
    private Bufor _buf;

    public void run() {
        for (int i = 0; i < 100; ++i) {
            _buf.put(i);
        }
    }
}

class Konsument extends Thread {
    private Bufor _buf;

    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println(_buf.get());
        }
    }
}

class Bufor {
    public void put(int i) {

    }

    public int get() {

    }
}

public class PKmon {
    public static void main(String[] args) {

    }
}
