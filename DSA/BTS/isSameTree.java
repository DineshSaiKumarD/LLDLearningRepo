package BTS;

import java.util.LinkedList;

public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) { //DFS

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        isSameTree isSameTree = new isSameTree();

        System.out.println(isSameTree.isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3))));


        System.out.println("******************Queue based approach*************************");

        System.out.println(isSameTree.isSameTree2(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }

    public boolean isSameTree2(TreeNode p , TreeNode q){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(p);
        treeNodes.add(q);

        while(!treeNodes.isEmpty()){
            TreeNode node1 = treeNodes.removeFirst();
            TreeNode node2 = treeNodes.removeFirst();

            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;

            treeNodes.add(node1.left);
            treeNodes.add(node2.left);
            treeNodes.add(node1.right);
            treeNodes.add(node2.right);
        }
        return true;
    }
}
