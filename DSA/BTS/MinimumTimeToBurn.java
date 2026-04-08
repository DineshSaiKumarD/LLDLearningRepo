package BTS;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class MinimumTimeToBurn {
    public int timeToBurnTree(TreeNode root, int start) {
        //your code goes here
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        mapParents(root,parentMap);
        for(Map.Entry<TreeNode, TreeNode> entry : parentMap.entrySet()){
            System.out.println(entry.getKey().val + " " + entry.getValue().val);
        }

       Set<TreeNode> visited = new HashSet<>();

        TreeNode targetNode = getTargetNode(root, start);

        return checkMinTime(targetNode,parentMap,visited);

    }

    TreeNode getTargetNode(TreeNode root, int start){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode temp = q.poll();
                if(temp.val == start){
                    return temp;
                }
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
        }
        return null;


    }

    int checkMinTime(TreeNode targetNode, Map<TreeNode, TreeNode> parentMap, Set<TreeNode> visited){

        Queue<TreeNode> target = new LinkedList<>();
        target.offer(targetNode);
        visited.add(targetNode);

        int minTime = 0;
        while(!target.isEmpty()) {
            boolean burn = false;
            int size = target.size();

            while (size-- > 0) {
                TreeNode temp = target.poll();
                if (temp.left != null && !visited.contains(temp.left)) {
                    burn = true;
                    target.offer(temp.left);
                    visited.add(temp.left);
                }
                if (temp.right != null && !visited.contains(temp.right)) {
                    burn = true;
                    target.offer(temp.right);
                    visited.add(temp.right);
                }
                if (parentMap.get(temp) != null && !visited.contains(parentMap.get(temp))) {
                    burn = true;
                    target.offer(parentMap.get(temp));
                    visited.add(parentMap.get(temp));
                }
            }
            if(burn) minTime++;



        }
        return minTime;
    }


    void mapParents(TreeNode root, Map<TreeNode, TreeNode> parentMap){


        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);


        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){

                TreeNode temp = q.poll();

                if(temp.left != null){
                    q.offer(temp.left);
                    parentMap.put(temp.left,temp);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                    parentMap.put(temp.right,temp);
                }

            }
        }
    }


    public static void main(String[] args) {
        MinimumTimeToBurn minimumTimeToBurn = new MinimumTimeToBurn();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);



        System.out.println("time " + minimumTimeToBurn.timeToBurnTree(root,4));







    }
}
