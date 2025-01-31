package io.github.akotu235.pkmon.timer;

public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getElapsedTimeInNano() {
        return endTime - startTime;
    }
}