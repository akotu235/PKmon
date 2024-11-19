package io.github.akotu235.pkmon;


public class PKmon {
    public static void main(String[] args) {
        Bufor buf = new Bufor(10);
        Producent p = new Producent(buf);
        Konsument k = new Konsument(buf);

        p.start();
        k.start();

        try {
            p.join();
            k.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Wątek główny przerwany.");
        }
    }
}