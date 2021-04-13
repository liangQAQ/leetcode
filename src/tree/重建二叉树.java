package tree;

import ListNode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7] => [根、左、右]
 * 中序遍历 inorder = [9,3,15,20,7] => [左、根、右]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *前序遍历列表：第一个元素永远是 【根节点 (root)】
 * 中序遍历列表：根节点 (root)【左边】的所有元素都在根节点的【左分支】，【右边】的所有元素都在根节点的【右分支】
 * 算法思路：
 *
 */
public class 重建二叉树 {

    public static void main(String[] args) {
//        int[] preorder = {3,9,20,15,7};//前序
//        int[] inorder = {9,3,15,20,7};//中序
        int[] preorder = {1,2,3};//前序
        int[] inorder = {1,2,3};//中序

        TreeNode node = buildTree(preorder, inorder);

        System.out.println(node);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        //树的左边数据的中序遍历
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, getIndexOfArray(inorder,rootVal));
        //树的右边数据的中序遍历
        int[] rightInorder = Arrays.copyOfRange(inorder,getIndexOfArray(inorder,rootVal)+1,inorder.length);
        //树的左边数据的前序遍历
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length+1);
        //树的右边数据的前序遍历
        int[] rightPreorder = Arrays.copyOfRange(preorder,leftInorder.length+1,preorder.length);

        root.left = buildTree(leftPreorder,leftInorder);
        root.right = buildTree(rightPreorder,rightInorder);

        return root;
    }

    public static int getIndexOfArray(int[] arr,int value){
        int result = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                result = i;
                break;
            }
        }
        return result;
    }
}
