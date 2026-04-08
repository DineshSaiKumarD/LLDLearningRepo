package RateLimiter.SlidingWindowCounterRateLimiter;

public class SlidingWindowCounterRateLimiter {

    private final int limit;
    private final long windowSize;

    private long windowStart;
    private int currentCount;
    private int previousCount;

    public SlidingWindowCounterRateLimiter(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
        windowStart = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        if (now - windowStart >= windowSize) {
            previousCount = currentCount;
            currentCount = 0;
            windowStart = now;
        }

        double overlapRatio =
                (double) (windowSize - (now - windowStart)) / windowSize;

        double effectiveCount =
                currentCount + (previousCount * overlapRatio);

        if (effectiveCount >= limit) {
            return false;
        }

        currentCount++;
        return true;
    }



    }
