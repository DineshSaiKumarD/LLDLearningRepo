


class PeakElement {
    public int findPeakElement(int[] arr) {

        int ans =0;
        int cnt=0;
        for (int i = 1; i < arr.length - 2; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                ans = i;
                cnt++;
                System.out.println("ans " + ans);
            }
        }
        if(cnt ==0) return 0;
        if(cnt>1){
            if(ans == arr[ans]) return 1;
            else return 0;
        }else return ans;
    }

    public static void main(String[] args) {
        PeakElement obj = new PeakElement();
        int peakElement = obj.findPeakElement(new int[]{-20,-5,-20,14,-85,21,-34,-5,-25,-41,-31,-61,57,90,-67});


        System.out.println(peakElement);
    }
}


