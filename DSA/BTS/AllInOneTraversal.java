package BTS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AllInOneTraversal {

    public static void main(String[] args) {
        //create treenode
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));//create treenode
        List<List<Integer>> lists = new AllInOneTraversal().treeTraversal( root);
        System.out.println(lists);

    }

    List<List<Integer>> treeTraversal(TreeNode root) {

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        if (root == null) return Arrays.asList(preOrder, inOrder, postOrder);
        Stack<NodeState> nodeStates = new Stack<>();

        nodeStates.push(new NodeState(1, root));

        while(!nodeStates.isEmpty()) {

            NodeState pop = nodeStates.pop();
            int val = pop.node.val;

            if(pop.state == 1) {
                preOrder.add(val);
                nodeStates.push(new NodeState(2, pop.node));
                if(pop.node.left != null) {
                    nodeStates.push(new NodeState(1, pop.node.left));
                }
            } else if(pop.state == 2) {
                inOrder.add(val);
                nodeStates.push(new NodeState(3, pop.node));
                if(pop.node.left != null) {
                    nodeStates.push(new NodeState(1, pop.node.right));
                }
            } else if(pop.state == 3) {
                postOrder.add(val);
            }


        }


        return Arrays.asList(preOrder, inOrder, postOrder);
    }



}


class NodeState {
    int state;
    TreeNode node;
    NodeState(int state, TreeNode node) {
        this.state = state;
        this.node = node;
    }
}
