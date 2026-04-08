package BTS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    LinkedList<List<Integer>> zigZagTraversal(TreeNode root) {


       Queue<TreeNode> q = new LinkedList<>();
       LinkedList<List<Integer>> temp = new LinkedList<>();
       q.offer(root);

       boolean leftToRight = false;

       while(!q.isEmpty()) {

           int size = q.size();
           LinkedList<Integer> level = new LinkedList<>();

           while(size-- > 0) {

               TreeNode node = q.poll();

               if(leftToRight) {
                   level.addFirst(node.val);
               } else {
                   level.addLast(node.val);
               }

               if(node.left != null) {
                   q.offer(node.left);
               }
               if(node.right != null) {
                   q.offer(node.right);
               }




           }

           leftToRight = !leftToRight;

           temp.add(level);

           }
       return temp;

   }


    public static void main(String[] args) {

        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        LinkedList<List<Integer>> lists = zigZagTraversal.zigZagTraversal(root);
        System.out.println(lists);
    }
}
