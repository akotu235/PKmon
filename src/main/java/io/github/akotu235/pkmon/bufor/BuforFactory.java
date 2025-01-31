package io.github.akotu235.pkmon.bufor;

public class BuforFactory {
    public static Bufor createBufor(int version, int initialValue) {
        return switch (version) {
            case 1 -> new BuforV1(initialValue);
            case 2 -> new BuforV2(initialValue);
            default -> throw new IllegalArgumentException("Unsupported bufor: " + version);
        };
    }
}