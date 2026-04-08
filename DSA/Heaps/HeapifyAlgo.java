package Heaps;

public class HeapifyAlgo {


    public void heapify(int[] nums, int ind, int val) {

        int currInd = ind;
        nums[currInd] = val;


        while(currInd >= 0){

            int parentInd = (currInd-1)/2; //get the parent Index

            System.out.println("currInd " + currInd + " parentInd " + parentInd);

            if(nums[parentInd] > nums[currInd]){
                int temp = nums[parentInd];
                nums[parentInd] = nums[currInd];
                nums[currInd] = temp;
            }
            currInd = parentInd;

            for(int i : nums) System.out.print(i + " ");
            System.out.println();
            if(currInd == 0) break;

        }

    }

    public static void main(String[] args) {
        HeapifyAlgo obj = new HeapifyAlgo();
        int []nums = {2, 4, 3, 6, 5, 7, 8, 7};
        obj.heapify(nums, 0, 7);
    }
}
