package BTS;

import java.util.LinkedList;
import java.util.Queue;

class MaxwidthofBt {
    public int widthOfBinaryTree(TreeNode root) {
        //your code goes here

        int noOfLevels = calculateLevels(root);

        



        return noOfLevels;
    }





    public int calculateLevels(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {
                TreeNode node = q.remove();


                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            level++;
        }
        return level;


    }

    public static void main(String[] args) {
        MaxwidthofBt maxwidthofBt = new MaxwidthofBt();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right.right = new TreeNode(9);

        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right.right.left = new TreeNode(8);


        int i = maxwidthofBt.calculateLevels(root);

        System.out.println(i);
    }
}
