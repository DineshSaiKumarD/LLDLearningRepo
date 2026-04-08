package BTS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class RIghtView {
    public List<Integer> rightSideView(TreeNode root) {
        //your code goes here

        List<Integer> ans = new ArrayList();

        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();


            List<Integer> tempList = new ArrayList();

            while(size-- > 0){
                TreeNode temp = q.poll();
                int data = temp.val;

                tempList.add(data);

                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);

            }

            System.out.println("tempList " + tempList);

            ans.add(tempList.get(tempList.size()-1));



        }

        return ans;



    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> integers = new RIghtView().rightSideView(root);

        System.out.println(integers);
    }

}
