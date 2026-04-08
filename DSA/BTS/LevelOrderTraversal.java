package BTS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {



    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); //addig root to queue

        List<List<Integer>> res = new LinkedList<>();


        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            while(size-- > 0){
                TreeNode node = q.remove();
                level.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            res.add(level);
        }



        return res;
    }

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(6);

        System.out.println(levelOrderTraversal.levelOrder(root));

        List<List<Integer>> lists = levelOrderTraversal.levelOrder(root);

        levelOrderTraversal.topView(lists);
    }


    void topView(List<List<Integer>> lists){

        System.out.println("Top View");
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = lists.size() -1; i >= 0; i--){
            ans.add(lists.get(i).get(0));
        }

        for(int i = 1; i < lists.size(); i++){
            ans.add(lists.get(i).get(lists.get(i).size() - 1));
        }

        System.out.println(ans);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
