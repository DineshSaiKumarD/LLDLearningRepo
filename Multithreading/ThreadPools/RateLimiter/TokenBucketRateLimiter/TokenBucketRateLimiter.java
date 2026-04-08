package RateLimiter.TokenBucketRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiter {

    static class Bucket {
        int tokens;
        long lastRefillTime;

        Bucket(int tokens, long lastRefillTime) {
            this.tokens = tokens;
            this.lastRefillTime = lastRefillTime;
        }
    }

    private final int bucketCapacity;
    private final int refillRate; // tokens per second
    private final Map<String, Bucket> map = new HashMap<>();

    public TokenBucketRateLimiter(int bucketCapacity, int refillRate) {
        this.bucketCapacity = bucketCapacity;
        this.refillRate = refillRate;
    }


    public synchronized boolean allowRequest(String userId) {

        long now = System.currentTimeMillis();

        // get or create bucket for user
        Bucket bucket = map.computeIfAbsent(userId,
                k -> new Bucket(bucketCapacity, now));

        refillTokens(bucket, now);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }


    private void refillTokens(Bucket bucket, long now) {

        long secondsPassed = (now - bucket.lastRefillTime) / 1000;

        if (secondsPassed > 0) {
            int tokensToAdd = (int) (secondsPassed * refillRate);

            bucket.tokens = Math.min(bucketCapacity, bucket.tokens + tokensToAdd);
            bucket.lastRefillTime = now;
        }
    }

}
