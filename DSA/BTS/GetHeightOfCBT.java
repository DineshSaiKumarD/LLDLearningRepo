package BTS;

public class GetHeightOfCBT {




    int getHeightOfCBT(TreeNode root){


        if(root == null) return 0;

        return 1 + Math.max(getHeightOfCBT(root.left), getHeightOfCBT(root.right));

    }


    int countNodes(TreeNode root){


        if(root == null) return 0;

        int left = getHeightOfCBT(root.left);
        int right = getHeightOfCBT(root.right);

        if(left == right) return (2 << left) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    public static void main(String[] args) {

        GetHeightOfCBT getHeightOfCBT = new GetHeightOfCBT();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(getHeightOfCBT.countNodes(root));
    }
}
