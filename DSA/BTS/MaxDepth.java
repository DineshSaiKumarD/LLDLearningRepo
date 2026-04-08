package BTS;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        int i = new MaxDepth().maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));

        System.out.println(i);

        System.out.println("********************** Queue based iterative approach *******************************");

        System.out.println(new MaxDepth().maxDepth2(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int level = 0;
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while(size-- > 0) {
                TreeNode node = treeNodes.remove();
                if(node.left != null) treeNodes.add(node.left);
                if(node.right != null) treeNodes.add(node.right);
            }
            level++;
        }
        return level;
    }
}
