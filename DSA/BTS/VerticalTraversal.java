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

class VerticalTraversal {

    class Pair{
        int column;
        TreeNode node;
        int row;

        Pair(int column, TreeNode node, int row){
            this.column = column;
            this.node = node;
            this.row = row;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }

        Queue<Pair> q = new LinkedList<>();
        Pair rootPair = new Pair(0,root,0);
        q.offer(rootPair);

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while(!q.isEmpty()){

            int size = q.size();



            while(size-- > 0){
                List<Integer> tempList = new ArrayList();
                Pair tempPair = q.poll();
                int col =  tempPair.column;
                int row = tempPair.row;
                TreeNode tempNode =  tempPair.node;
                System.out.println(" col " + col + " val " + tempNode.val + " row " + row);
                map.computeIfAbsent(col, x -> new TreeMap<>())
                        .computeIfAbsent(row, x -> new PriorityQueue<>())
                        .offer(tempNode.val);
                if(tempNode.left != null) q.offer(new Pair(col-1 ,tempNode.left,row+1));

                if(tempNode.right != null) q.offer(new Pair(col+1 ,tempNode.right,row+1));
            }

        }

        for (TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : colMap.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            res.add(colList);
        }
        return res;



    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        //use this input 1 29 22 4 58 44 null null 85 55 null 20 null 84 94 76 null 44 null null null 2 18 85 35 29 16 93 null 85 null 62 null null null null null 29 null 3 99 null null 30 88 51 null null null 60 75 81 20 null 43 73 10 null null 17 null null null null 68 null null 20 76 null 7 31 null null null 33 null 45 null 93 53 null null null null null 32 26 null 2 13 41 null 40 45 null null null 6 22 null null null null 67 71 41 7 95 null 19 46 null 5 11 30 null null 14 31 100 null 62 56 22 null null null null null null null null null null null null null null null null

        List<List<Integer>> lists = new VerticalTraversal().verticalTraversal(root);

        System.out.println(lists);
    }
}
