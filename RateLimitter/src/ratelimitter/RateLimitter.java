package ratelimitter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple rate limiter implementation using bucket-refill algorithm
 */
class RateLimitter {

    private static volatile RateLimitter rateLimitter;
    private ConcurrentHashMap<String, Bucket> bucketHashMap;

    private RateLimitter() {
        bucketHashMap = new ConcurrentHashMap<>();
    }

    public static RateLimitter getInstance() {
        if (rateLimitter == null) {
            synchronized (RateLimitter.class) {
                if (rateLimitter == null) {
                    rateLimitter = new RateLimitter();
                }
            }
        }
        return rateLimitter;
    }

    public Bucket getBucket(String bucketName) {
        Bucket bucket = bucketHashMap.get(bucketName);
        if (bucket == null) {
            throw new RuntimeException("No bucket with given name present: " + bucketName);
        }
        return bucket;
    }

    public Bucket createBucket(String bucketName) {
        return bucketHashMap.computeIfAbsent(bucketName, k -> new Bucket(5, 2));
    }
}
