package tree;

import ListNode.entity.TreeNode;

/**
 * 二叉树的镜像定义：
 *     源二叉树
 *     8
 *     | |
 *     6 10
 *     | | | |
 *     5 7 9 11
 *     镜像二叉树
 *     8
 *     | |
 *     10 6
 *     | | | |
 *     11 9 7 5
 */
public class 镜像二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode left_left = new TreeNode(5);
        TreeNode left_right = new TreeNode(7);
        left.left = left_left;
        left.right = left_right;
        TreeNode right = new TreeNode(10);
        TreeNode right_left = new TreeNode(9);
        TreeNode right_right = new TreeNode(11);

        right.left = right_left;
        right.right = right_right;

        root.left = left;
        root.right = right;

        change(root);

        System.out.println(1);
    }

    public static void change(TreeNode node){

        if(node == null){
            return ;
        }

        TreeNode temp = new TreeNode(0);

        temp = node.left;

        node.left = node.right;

        node.right = temp;

        change(node.left);
        change(node.right);
    }
}
