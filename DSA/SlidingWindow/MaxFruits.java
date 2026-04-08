package SlidingWindow;


import java.util.HashMap;

class MaxFruits {
    public int totalFruits(int[] fruits) {
        //your code goes here


        int n = fruits.length;
        int cnt =0;

        int l=0,r=0;

        HashMap<Integer, Integer> fruitsMap = new HashMap<>();

        while(r<n){

            if(fruitsMap.containsKey(fruits[r])){
                fruitsMap.put(fruits[r], fruitsMap.get(fruits[r])+1);
            }else{
                fruitsMap.put(fruits[r], 1);
            }

            while(fruitsMap.size()>2){
                fruitsMap.put(fruits[l], fruitsMap.get(fruits[l])-1);
                if(fruitsMap.get(fruits[l])==0){
                    fruitsMap.remove(fruits[l]);
                }
                l++;
            }

            cnt = Math.max(cnt, r-l+1);
            r++;



        }

        return cnt;
    }
}
