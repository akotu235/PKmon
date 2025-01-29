package io.github.akotu235.pkmon;


import io.github.akotu235.pkmon.bufor.Bufor;
import io.github.akotu235.pkmon.bufor.BuforV1;

public class PKmon {
    public static void main(String[] args) {
        Bufor buf = new BuforV1(10);
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