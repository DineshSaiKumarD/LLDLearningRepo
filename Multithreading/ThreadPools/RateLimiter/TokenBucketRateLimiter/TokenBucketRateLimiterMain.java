package RateLimiter.TokenBucketRateLimiter;

public class TokenBucketRateLimiterMain {

    public static void main(String[] args) throws Exception {

        TokenBucketRateLimiter limiter =
                new TokenBucketRateLimiter(5, 1); // 5 burst, 1 token/sec

        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + " -> " +
                    limiter.allowRequest("user1"));
        }
    }
}
