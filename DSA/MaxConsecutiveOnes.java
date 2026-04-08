public class MaxConsecutiveOnes {

    public int findLengthOfMaxConsecutiveOnes(int[] nums,int k) {
        int zeros =0;
        int l=0;
        int r =0;
        int ans =0;

        while(r<nums.length){
            if(nums[r]==0){
                zeros++;
            }
            while(zeros>k){
                if(nums[l]==0){
                    zeros--;
                }
                l++;
            }
            if(zeros <=k){
                System.out.println(l+" "+r+" "+zeros);
                ans = Math.max(ans,r-l+1);
            }
            r++;
        }

        return ans;

}

    public static void main(String[] args) {
        int lengthOfMaxConsecutiveOnes = new MaxConsecutiveOnes().findLengthOfMaxConsecutiveOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);


        System.out.println(lengthOfMaxConsecutiveOnes);
    }

}



