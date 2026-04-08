package BTS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MorrisPreOrder {



    List<TreeNode> morrisPreOrder(TreeNode root){

        List<TreeNode> preOrderList = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){

            if(curr.left == null){
                preOrderList.add(curr);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){   //finding rightmost node in left subtree
                    prev = prev.right;
                }
                if(prev.right == null){       //checking a link established between rightmost and current or not
                    prev.right = curr;
                   preOrderList.add(curr);//adding current node in preOrderList for inorder
                    curr = curr.left;
                }else{
                    prev.right = null;   //break the link

                  //  preOrderList.add(curr);//adding current node in preOrderList for preorder
                    curr = curr.right;
                }
            }



        }

        return preOrderList;
}

    List<TreeNode> morrisPostOrder(TreeNode root){

        LinkedList<TreeNode> postOrderList = new LinkedList<>();
        TreeNode curr = root;

        while(curr != null){

            if(curr.right == null){
                postOrderList.addFirst(curr);
                curr = curr.left;
            }else{
                TreeNode prev = curr.right;
                while(prev.left != null && prev.left != curr){   //finding rightmost node in left subtree
                    prev = prev.left;
                }
                if(prev.left == null){       //checking a link established between rightmost and current or not
                    prev.left = curr;
                     postOrderList.addFirst(curr);//adding current node in preOrderList for inorder
                    curr = curr.right;
                }else{
                    prev.left = null;   //break the link

                 //  postOrderList.addFirst(curr);      //adding current node in preOrderList for preorder
                    curr = curr.left;
                }
            }



        }

        return postOrderList;
    }


    public static void main(String[] args) {
        MorrisPreOrder morrisPreOrder = new MorrisPreOrder();

       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.left = new TreeNode(4);
       root.left.right = new TreeNode(5);
       root.left.right.right = new TreeNode(6);


        List<TreeNode> treeNodes = morrisPreOrder.morrisPreOrder(root);


        for(TreeNode node : treeNodes) {
            System.out.print(node.val);
        }

System.out.println();
        System.out.println("*************PostOrder*******************");

        List<TreeNode> treeNodes1 = morrisPreOrder.morrisPostOrder(root);


        for(TreeNode node : treeNodes1) {
            System.out.print(node.val);
        }
    }
}
