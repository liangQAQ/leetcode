package tree;

import ListNode.entity.TreeNode;
import utils.TreeUtils;

/**
 * 多个参数的递归
 */
public class 对称二叉树 {

    public static boolean isSymmetric(TreeNode root) {
        return compareChild(root.left,root.right);
    }

    private static boolean compareChild(TreeNode left,TreeNode right){
        if(left!=null && right!=null && hasChild(left) && hasChild(right)){
            return left.val == right.val && compareChild(left.left,right.right) && compareChild(left.right,right.left);
        }else if (left==null && right==null){
            return true;
        }else if(left==null && right!=null || left!=null && right==null){
            return false;
        }else{
            return left.val == right.val;
        }
    }

    private static boolean hasChild(TreeNode root){
        return root.left!=null || root.right!=null;
    }

    public static void main(String[] args) {
//        Integer[] arr = {1,0};
//        Integer[] arr = {1,2,2,null,3,null,3};
//        Integer[] arr = {1,2,2,3,4,4,3};
        Integer[] arr = {2,3,3,4,5,5,4,null,null,8,9,null,null,9,8};
        TreeNode treeNode = TreeUtils.array2TreeNode(arr);
        System.out.println(isSymmetric(treeNode));
    }
}
