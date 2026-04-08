package BTS;

import java.util.Stack;

class ConstructBst {
    public TreeNode bstFromPreorder(int[] preorder) {
        //your code goes here
        if (preorder.length == 0) return null;


        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        for (int i = 1; i < preorder.length; i++) {

            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);

            while (!stack.isEmpty() && stack.peek().val < child.val) {
                node = stack.pop();
            }


            if (node.val < child.val) {
                node.right = child;
            } else {
                node.left = child;
            }





            stack.push(child);




        }

        return root;




    }


    public static void main(String[] args) {
        ConstructBst obj = new ConstructBst();
        obj.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }






}
