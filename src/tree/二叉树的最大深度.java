package tree;

import ListNode.entity.TreeNode;
import utils.TreeUtils;

/**
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *           0,1,2,  3,  4 ,  5  ,6
 */
public class 二叉树的最大深度 {

    public static int maxDepth(TreeNode root) {

        if(root==null || root.val == 0 ){
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeUtils.array2TreeNode(arr);
        System.out.println(maxDepth(root));
    }
}
