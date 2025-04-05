package ratelimitter;

import java.time.Instant;

public class Bucket {

    private int capacity;
    private int tokenCount;
    private int ratePerMinute;

    public Bucket(int capacity, int ratePerMinute) {
        this.capacity = capacity;
        this.tokenCount = ratePerMinute;
        this.ratePerMinute = ratePerMinute;
        Replinisher replinisher = new Replinisher(this);
        replinisher.start();
    }

    public synchronized boolean consumeToken() {
        if(tokenCount == 0) {
            System.out.println("No tokens available at: " + Instant.now().toString());
            return false;
        } else {
            tokenCount--;
            System.out.println("Token granted, available token count at " + Instant.now().toString() + ", : " + tokenCount);
            return true;
        }
    }

    public synchronized void refillToken() {
        tokenCount = Math.min(tokenCount + ratePerMinute, capacity);
        System.out.println("Tokens replenished at " + Instant.now().toString() + ", available token count: " + tokenCount);
    }
}
