package RateLimiter.SlidingWindowLogRateLimiter;

public class SlidingWindowLogRateLimiterMain {

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowLogRateLimiter slidingWindowLogRateLimiter = new SlidingWindowLogRateLimiter(3, 1000);

        for(int i = 0 ; i < 10; i++) {
            System.out.println(slidingWindowLogRateLimiter.allowRequest("user1"));
            Thread.sleep(100);
        }

    }
}
