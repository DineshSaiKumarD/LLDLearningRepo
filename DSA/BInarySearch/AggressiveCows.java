package BInarySearch;




class AggressiveCows {
    public int aggressiveCows(int[] nums, int k) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i: nums){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        int ans = -1;

        while(low <= high){



            int mid = low + (high - low)/2;

            System.out.println("low " + low + " high " + high + " mid " + mid);

            if(isPossible(nums, mid, k)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

System.out.println("ans " + ans);
        return ans;
    }




    boolean isPossible(int[] nums, int mid, int k){

        int cows = 1;
        int lastPos = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - lastPos >= mid){
                cows++;
                lastPos = nums[i];
            }
        }

        return cows >= k;




    }

    public static void main(String[] args) {
        new AggressiveCows().aggressiveCows(new int[]{4, 2, 1, 3, 6}, 2);
    }
}
