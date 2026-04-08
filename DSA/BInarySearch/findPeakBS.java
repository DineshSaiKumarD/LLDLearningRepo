package BInarySearch;


class findPeakBS {
    public int findPeakElement(int[] arr) {
        int low =0;
        int high = arr.length-1;
        int ans =-1;

        while(low<= high){
            int mid = (low+high)/2 ;


            System.out.println("low " + low + " high " + high + " mid " + mid + " arr[mid] " + arr[mid]);

           if(high - low +1 == 2) {
               if(arr[low] > arr[high]){
                   ans = low;
                   break;
               }else{
                   ans = high;
                   break;
               }
           }

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {

                ans = mid;
                System.out.println("ans " + ans);
                low =mid+1;
            }else if(arr[low] < arr[mid] ){

                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        new findPeakBS().findPeakElement(new int[]{49,50,-77,16,-54});
    }
}
