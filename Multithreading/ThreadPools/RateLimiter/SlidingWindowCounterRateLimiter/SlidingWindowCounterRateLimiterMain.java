package RateLimiter.SlidingWindowCounterRateLimiter;

public class SlidingWindowCounterRateLimiterMain {
    public static void main(String[] args) throws InterruptedException {
        SlidingWindowCounterRateLimiter slidingWindowCounterRateLimiter = new SlidingWindowCounterRateLimiter(3, 1000);

        for(int i = 0 ; i < 10; i++) {
            System.out.println(slidingWindowCounterRateLimiter.allowRequest());
            Thread.sleep(100);
        }

    }
}
