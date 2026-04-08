package BTS;/*
import java.util.ArrayList;
import java.util.List;

class PrintRootToPath {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        //your code goes here
        List<Integer> temp = new ArrayList<>();


        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }
        findPath(root,temp,ans);

        return ans;


    }

    void findPath(TreeNode root, List<Integer> temp, List<List<Integer>> ans){



        if(root != null){
            System.out.println("root " + root.val);
            temp.add(root.val);
            System.out.println("temp 1 " + temp);
        }

        if(root.left != null){
            System.out.println("left " + root.left.val);
            findPath(root.left,temp,ans);
        }

        if(root.right != null){
            System.out.println("right " + root.right.val);
            findPath(root.right,temp,ans);
        }

        if(root.left == null && root.right == null ){
            System.out.println("both are null ");
            ans.add(new ArrayList<>(temp));
            System.out.println("ans when null " + ans);

        }

        temp.remove(temp.size() - 1);




    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        List<List<Integer>> lists = new PrintRootToPath().allRootToLeaf(root);

        System.out.println(lists);
    }


}
*/

import java.util.ArrayList;
import java.util.List;

class PrintRootToPath {

    public List<List<Integer>> allRootToLeaf(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        List<Integer> temp = new ArrayList<>();
        findPath(root,temp,ans);

        return ans;
    }


    void findPath(TreeNode root, List<Integer> temp, List<List<Integer>> ans) {

        if(root != null){
            temp.add(root.val);
            if(root.left == null && root.right == null){
                ans.add(new ArrayList<>(temp));
            }
            findPath(root.left,temp,ans);
            findPath(root.right,temp,ans);
            temp.remove(temp.size() - 1);
    }

    }

    public static void main(String[] args) {
        PrintRootToPath printRootToPath = new PrintRootToPath();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        List<List<Integer>> lists = printRootToPath.allRootToLeaf(root);

        System.out.println(lists);





    }


}
