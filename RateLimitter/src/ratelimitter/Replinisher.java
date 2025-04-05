package ratelimitter;

public class Replinisher extends Thread{

    private Bucket bucket;

    public Replinisher(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        while (true) {
            bucket.refillToken();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
