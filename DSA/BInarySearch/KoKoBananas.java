package BInarySearch;



class KoKoBananas {
    public int minimumRateToEatBananas(int[] nums, int h) {

        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);
        }

        while(low<=high){
            int mid = (low+high)/2;

            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += Math.ceil(nums[i]/(double)mid);
            }

            if(sum <= h){
                ans = Math.min(ans, mid);
                high = mid-1;
            }else{
                low = mid+1;
            }


        }

        return ans;

    }
}


