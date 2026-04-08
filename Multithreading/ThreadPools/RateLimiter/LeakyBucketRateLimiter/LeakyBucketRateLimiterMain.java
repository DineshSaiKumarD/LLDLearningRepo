package RateLimiter.LeakyBucketRateLimiter;

public class LeakyBucketRateLimiterMain {
    public static void main(String[] args) throws Exception {

        LeakyBucketRateLimiter limiter =
                new LeakyBucketRateLimiter(5, 2); // capacity=5, leak=2/sec

        String user = "user1";

        System.out.println("Sending 7 requests instantly");

        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " -> " + allowed);
        }

        System.out.println("\nWait 1 second...");
        Thread.sleep(1000);

        for (int i = 8; i <= 10; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " -> " + allowed);
        }

        System.out.println("\nWait another 1 second...");
        Thread.sleep(1000);

        for (int i = 11; i <= 13; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " -> " + allowed);
        }
    }
}
