package tree;

import ListNode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {

    public static int count = 0;

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
//        traversalRecur(root,result);
        traversalStack(root);
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

    public static List<Integer> traversalStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
