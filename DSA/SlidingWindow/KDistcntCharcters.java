package SlidingWindow;


import java.util.HashMap;

class KDistcntCharcters {
    public int kDistinctChar(String s, int k) {
        //your code goes here
        int maxLen = 0;

        int[] mpp = new int[256];
        char[] charArray = s.toCharArray();

        int start = 0;
        int end = 0;
        int cnt = 0;
//longest substring with k distinct characters
        while (end < charArray.length) {
            if (mpp[charArray[end]] == 0) {
                cnt++;
            }
            mpp[charArray[end]]++;
            end++;
            while (cnt > k) {
                mpp[charArray[start]]--;
                if (mpp[charArray[start]] == 0) {
                    cnt--;
                }
                start++;
            }
            if (cnt == k) {
                maxLen = Math.max(maxLen, end - start);
            }
        }


        return maxLen;
    }



}
