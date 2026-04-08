import java.util.*;

class LongestSubArraySum {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            // calculate the prefix sum till index i
            sum += nums[i];



            // if the sum equals k, update maxLen
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            System.out.println("sum "+sum + " maxLen "+maxLen);

            // calculate the sum of remaining part i.e., sum - k
            int rem = sum - k;

            // calculate the length and update maxLen
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // update the map if sum is not already present
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, 9};
        int k = 15;

        // Create an instance of the Solution class
        LongestSubArraySum solution = new LongestSubArraySum();
        // Function call to get the result
        int len = solution.longestSubarray(nums, k);

        System.out.println("The length of the longest subarray is: " + len);
    }
}

