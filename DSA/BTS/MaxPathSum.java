package BTS;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

public class MaxPathSum {
    public static int  globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //your code goes here

        if(root == null) return 0;

        int leftSum =  maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);

        return globalMax = Math.max(globalMax,root.val + Math.max(leftSum,rightSum));


    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();

        //20 9 -10 null null 15 7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(maxPathSum.maxPathSum(root));
    }
}
