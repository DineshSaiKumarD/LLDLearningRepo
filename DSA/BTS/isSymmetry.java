package BTS;

public class isSymmetry {

    boolean isSymmetry(TreeNode root){
        if(root == null) return true;

        return symmetry(root.left, root.right);
    }

    boolean symmetry(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;

        return symmetry(left.left, right.right) && symmetry(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
