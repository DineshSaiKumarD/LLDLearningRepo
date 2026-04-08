package BTS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NodeAtDistanceK {



    public NodeAtDistanceK(TreeNode root, Map<TreeNode, TreeNode> map, int k, TreeNode target){

        markParents(root, map);
        HashMap<TreeNode, Integer> visited = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        visited.put(target,1);
        int distance = 0;

        while(!q.isEmpty()){

            int size = q.size();

            if(distance == k){
                while(size-- > 0){
                    TreeNode node = q.poll();
                    System.out.println(node.val);
                }
                break;
            }


            while(size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.containsKey(node.left)) {
                    visited.put(node.left, 1);
                    q.offer(node.left);
                }
                if (node.right != null && !visited.containsKey(node.right)) {
                    visited.put(node.right, 1);
                    q.offer(node.right);
                }
                if (map.containsKey(node) && !visited.containsKey(map.get(node))) {
                    visited.put(map.get(node), 1);
                    q.offer(map.get(node));
                }
            }
            distance++;


        }


    }






    void markParents(TreeNode root, Map<TreeNode, TreeNode> map){ {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right != null){
                map.put(node.right,node);
                q.offer(node.right);
            }
        }


       /* for(Map.Entry<TreeNode,TreeNode> entry : map.entrySet())
            System.out.println(entry.getKey().val + " " + entry.getValue().val);
*/



    }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Map<TreeNode, TreeNode> map = new HashMap<>();
        NodeAtDistanceK nodeAtDistanceK = new NodeAtDistanceK(root, map, 2, root.left);
    }


}




