package BTS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumBst {



        Set st = new HashSet<>();
        public boolean twoSumBST(TreeNode root, int k) {
            //your code goes here
            inOrder(root);

            List<Integer> list = new ArrayList<>(st);

            for (int num : list) {
                int target = k - num;
                // avoid pairing with itself unless duplicates exist
                if (target != num && st.contains(target)) return true;
            }
            return false;

        }


        void inOrder(TreeNode root){
            if(root == null) return ;

            inOrder(root.left);
            st.add(root.val);
            inOrder(root.right);
        }

}
