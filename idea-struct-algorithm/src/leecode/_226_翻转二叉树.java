package leecode;

import java.util.LinkedList;
import java.util.Queue;

public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        //前序遍历
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        //层序遍历
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp1 = node.left;
            node.left = node.right;
            node.right = tmp1;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }


}
