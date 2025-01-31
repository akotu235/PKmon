package io.github.akotu235.pkmon;


import io.github.akotu235.pkmon.bufor.Bufor;
import io.github.akotu235.pkmon.bufor.BuforFactory;
import io.github.akotu235.pkmon.timer.Timer;

public class PKmon {
    public static void main(String[] args) {
        int buforVersion = 1;
        int bufferSize = 10;
        int sleepTime = 5;

        Bufor buf = BuforFactory.createBufor(buforVersion, bufferSize);
        Producent p = new Producent(buf, sleepTime);
        Konsument k = new Konsument(buf, sleepTime);

        Timer timer = new Timer();

        timer.start();

        p.start();
        k.start();

        try {
            p.join();
            k.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Wątek główny przerwany.");
        }

        timer.stop();

        System.out.println("Całkowity czas eksperymentu: " + timer.getElapsedTimeInNano() / 1_000_000 + " ms");
    }
}