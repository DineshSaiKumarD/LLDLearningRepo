package RateLimiter.FixedWindow;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter {

    //below 2 are configurable things
    private final int limit;
    private final long windowSize;

    //usually we use redis to maintian this counts..here we use map

    private Map<String, Integer> counter = new HashMap<>();
    private long windowStart = System.currentTimeMillis();

    public FixedWindowRateLimiter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }


    public synchronized boolean allowRequest(String user) {
        long now = System.currentTimeMillis();

        if (now - windowStart > windowSize) {
            counter.clear();
            windowStart = now;
        }

        counter.put(user, counter.getOrDefault(user, 0) + 1);

        return counter.get(user) <= limit;
    }






}
