package SlidingWindow;

public class MaxPointsFromCards {



    //below will fail lets see this example {1,100,2,3,4,5,6}
    //but for ordered unique elements it works
    public int maxScore(int[] cardScore, int k) {

        int start = 0;
        int end = cardScore.length - 1;


        int count = 0;
        int maxSum = 0;

        while(count < k){
            if(cardScore[start] > cardScore[end]){
                count++;
                maxSum= maxSum + cardScore[start];
                start++;

            }else{
                count++;
                maxSum= maxSum + cardScore[end];
                end--;


            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        MaxPointsFromCards maxPointsFromCards = new MaxPointsFromCards();

        int i = maxPointsFromCards.maxScore(new int[]{1, 2, 3, 4, 5, 6}, 3);

        System.out.println(i);

    }



}
