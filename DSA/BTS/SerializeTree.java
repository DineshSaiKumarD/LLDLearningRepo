package BTS;

public class SerializeTree {



    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root,sb);
       // remove the last comma

        sb.delete(sb.length()-2,sb.length());

        System.out.println("Serialized Tree String " + sb);
        return sb.toString();



    }


    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");
        int index = 0;


        return deserializeHelper(nodes,index);
    }

   TreeNode deserializeHelper(String[] nodes, int index){
        if(index >= nodes.length || nodes[index].equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        index++;
        root.left = deserializeHelper(nodes,index);
        index++;
        root.right = deserializeHelper(nodes,index);
        return root;
    }


    void preOrderTraverse(TreeNode root, StringBuilder sb){

        if(root == null){
            sb.append("null , ");
            return;
        }

        sb.append(root.val);
        sb.append(" , ");

        preOrderTraverse(root.left,sb);
        preOrderTraverse(root.right,sb);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        SerializeTree serializeTree = new SerializeTree();

        serializeTree.serialize(root);
    }



}
