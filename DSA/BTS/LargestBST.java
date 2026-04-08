package BTS;

import java.util.ArrayList;

public class LargestBST {


    public int largestBST(TreeNode root) {
        ArrayList<TreeNode> in = new ArrayList<>();
        int ans = 0;
        //your code goes here
        inorder(root,in);


        if (in == null || in.size() == 0) return 0;

        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < in.size(); i++) {
            if (in.get(i).val > in.get(i - 1).val) {
                currLen++;   // continue increasing sequence
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 1; // reset when sequence breaks
            }
        }

        return maxLen;


    }

    void inorder(TreeNode root, ArrayList<TreeNode> in) {
        if(root == null) return ;

        inorder(root.left, in);
        in.add(root);
        inorder(root.right, in);

    }
}
