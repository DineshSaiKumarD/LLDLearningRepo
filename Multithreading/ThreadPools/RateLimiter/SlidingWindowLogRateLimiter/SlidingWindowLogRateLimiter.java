package RateLimiter.SlidingWindowLogRateLimiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowLogRateLimiter {

    private int windowSize;
    private int limit;

    private Map<String, Deque<Long>> map = new HashMap<>();

    public SlidingWindowLogRateLimiter(int limit, int windowSize) {
        this.windowSize = windowSize;
        this.limit = limit;
    }

    public synchronized boolean allowRequest(String user) {
        Deque<Long> window = map.computeIfAbsent(user, k -> new ArrayDeque<>());

        long now = System.currentTimeMillis();

        while (!window.isEmpty() && now - window.peekFirst() >= windowSize) {
            window.pollFirst();
        }

        if (window.size() >= limit) {
            return false;
        }

        window.addLast(now);
        return true;
    }
}
