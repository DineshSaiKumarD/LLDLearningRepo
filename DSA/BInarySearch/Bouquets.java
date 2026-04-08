package BInarySearch;




class Bouquets {
    public int roseGarden(int n, int[] nums, int k, int m) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int count = 0;
        int finalAns = 0;


        for(int i = 0; i < nums.length; i++){
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }

        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] >= mid){
                    count++;
                }
                if(count == k){
                    count = 0;
                    ans = ans+1;
                }
                if(ans >= m){
                    finalAns = Math.min(finalAns, mid);
                    break;
                }
            }

            if(ans >= m){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }


        return finalAns;

    }
}
