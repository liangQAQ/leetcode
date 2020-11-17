package tree;

import ListNode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode right_left = new TreeNode(3);
        root.right = right;
        right.left = right_left;

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traversalRecur(root,result);
        return result;
    }

    public static void traversalRecur(TreeNode root,List<Integer> result){
        if(root == null){
            return ;
        }
        traversalRecur(root.left,result);
        result.add(root.val);
        traversalRecur(root.right,result);
    }
}
