package RateLimiter.FixedWindow;

public class FixedWindowRateLimiterMain {


    public static void main(String[] args) {

        FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(3, 1000);
        for(int i = 0 ; i < 10; i++) {
            System.out.println(fixedWindowRateLimiter.allowRequest("user" + i));
        }

    }
}
