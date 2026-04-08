package BInarySearch;



class Max1in2d {
    public int rowWithMax1s(int[][] mat) {

        int ans = -1;
        int rl = mat[0].length;
        int cl = mat.length;
        int pcnt =0;
        int ccnt = 0;

        for(int i=0 ; i< rl ;i++){
            ccnt = 0;
            for(int j=0 ; j < cl;j++){
                if(mat[i][j] == 1){
                    ccnt = ccnt+ (cl-j);
                    break;
                }

            }
            if(ccnt > pcnt) {
                System.out.println("ccnt " + ccnt + " pcnt " + pcnt);
                System.out.println("i " + i);
                pcnt = ccnt;
                ans = i;
                System.out.println("ans " + ans);
            }
        }

        return ans;




    }

    public static void main(String[] args) {
        new Max1in2d().rowWithMax1s(new int[][] {{1, 1, 1}, {0, 0, 1}, {0, 0, 0} });
    }
}
