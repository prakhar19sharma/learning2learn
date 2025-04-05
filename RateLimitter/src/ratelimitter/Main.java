package ratelimitter;

public class Main {
    public static void main(String[] args) {
        RateLimitter rateLimitter = RateLimitter.getInstance();
        rateLimitter.createBucket("bucket1");
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                rateLimitter.getBucket("bucket1").consumeToken();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }}).start();
        }
    }
}