
class FrogJumpSolution {
    public int frogJump(int[] heights, int ind,int[] dp) {
        // Base case: if the frog is at the first step
        if (ind == 0) return 0;


        if(dp[ind]!=0){
            return dp[ind];
        }
        // Recursively calculate the energy required to
        // jump to the current step from the previous step
        int jumpOne = frogJump(heights, ind - 1,dp) + Math.abs(heights[ind] - heights[ind - 1]);

        // Initialize jumpTwo to a large value
        int jumpTwo = Integer.MAX_VALUE;

        // If possible, recursively calculate the energy required to
        // jump to the current step from two steps back
        if (ind > 1) {
            jumpTwo = frogJump(heights, ind - 2,dp) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        // Return the minimum energy required to reach the current step
        return dp[ind] = Math.min(jumpOne, jumpTwo);
    }

    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        return frogJump(heights, n - 1,dp);
    }

    public static void main(String[] args) {
        /*FrogJumpSolution sol = new FrogJumpSolution();
        int[] heights = {2, 1, 3, 5, 4};
        int result = sol.frogJump(heights);
        System.out.println("Minimum energy required: " + result);*/

        Solution solution = new Solution();
        int i = solution.stockBuySell(new int[]{5, 4, 3, 2, 1}, 5);
        System.out.println(i);
    }
}



class Solution {
    public int stockBuySell(int[] arr, int n) {
        int max = -1;

        for(int i=0;i<arr.length;i++){

            for(int j=i+1;j<arr.length;j++){

                int diff = arr[j] - arr[i];
                max = Math.max(max,diff);
            }
        }
        return max<0?0:max;

    }

    public int stockBuySell2(int[] arr, int n) {
        int max = 0;
        int minPrice = arr[0];

        for(int i=1;i<arr.length;i++){

            if(arr[i]<minPrice){
                minPrice = arr[i];
            }
            else{
                max = Math.max(max,arr[i]-minPrice);
            }
        }
        return max;

    }

    //dp problem






}

