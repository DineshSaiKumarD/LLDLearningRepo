package BTS;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class LCABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //your code goes here


        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        TreeNode ans = null;

        findPath(root,pPath,p);
        findPath(root,qPath,q);

        for (TreeNode node : pPath) {
            System.out.println("PATH P " + node.val + " ");
        }

        for(TreeNode node : qPath){
            System.out.println("PATH Q " + node.val + " ");
        }

        int i = 0;
        while (i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)) {
            i++;
        }

        return pPath.get(i - 1);




    }


    boolean findPath(TreeNode root , List<TreeNode> path, TreeNode target){

        if(root == null) return false;



        path.add(root);
        for (TreeNode node : path) {
            System.out.println(node.val + " ");
        }

        System.out.println("************");
        if(root == target){

            System.out.println("found");

            return true;
        }

        if (findPath(root.left, path, target) || findPath(root.right, path, target)) {
            return true;
        }

        path.remove(path.size()-1);

    return false;

    }


    public static void main(String[] args) {
        LCABT lcabt = new LCABT();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode treeNode = lcabt.lowestCommonAncestor(root, root.left, root.left.right.right);

        System.out.println(treeNode.val);

    }





}
