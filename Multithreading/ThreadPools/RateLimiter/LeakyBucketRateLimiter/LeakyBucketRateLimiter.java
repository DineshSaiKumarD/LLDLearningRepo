package RateLimiter.LeakyBucketRateLimiter;

import java.util.*;

class LeakyBucketRateLimiter {

    static class Bucket {
        Queue<Long> queue = new ArrayDeque<>();
        long lastLeakTime = System.currentTimeMillis();
    }

    private final int capacity;
    private final int leakRate; // requests per second
    private final Map<String, Bucket> map = new HashMap<>();

    public LeakyBucketRateLimiter(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
    }

    public synchronized boolean allowRequest(String user) {

        long now = System.currentTimeMillis();

        Bucket bucket = map.computeIfAbsent(user, k -> new Bucket());

        leak(bucket, now);

        if (bucket.queue.size() >= capacity) {
            return false; // bucket full
        }

        bucket.queue.add(now);
        return true;
    }

    private void leak(Bucket bucket, long now) {

        long secondsPassed = (now - bucket.lastLeakTime) / 1000;

        int requestsToLeak = (int) (secondsPassed * leakRate);

        while (requestsToLeak > 0 && !bucket.queue.isEmpty()) {
            bucket.queue.poll();
            requestsToLeak--;
        }

        if (secondsPassed > 0) {
            bucket.lastLeakTime = now;
        }
    }
}
