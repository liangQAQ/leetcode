package tree;

import ListNode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
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
        int[] preorder = {3,9,20,15,7};//前序
        int[] inorder = {9,3,15,20,7};//中序

        TreeNode node = buildTree(preorder, inorder);

        System.out.println(node);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        //树的左边数据的中序遍历
        int[] leftArr = Arrays.copyOfRange(inorder, 0, getIndexOfArray(inorder,preorder[0])-1);
        //树的右边数据的中序遍历
        int[] rightArr = Arrays.copyOfRange(inorder,getIndexOfArray(inorder,preorder[0])+1,inorder.length-1);

        root.left = findRoot(0,preorder,leftArr);
        root.right = findRoot(0,preorder,rightArr);

        return root;
    }

    //找到根节点
    public static TreeNode findRoot(int lastRootIndex,int[] preorder,int[] inorder){
        if(inorder.length==1){
            return new TreeNode(inorder[0]);
        }
        int rootIndex = 2*lastRootIndex+1;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        //树的左边数据的中序遍历
        int[] leftArr = Arrays.copyOfRange(inorder, 0, getIndexOfArray(inorder,preorder[rootIndex]) - 1);
        //树的右边数据的中序遍历
        int[] rightArr = Arrays.copyOfRange(inorder,getIndexOfArray(inorder,preorder[rootIndex])+1,inorder.length-1);

        root.left = findRoot(rootIndex,preorder,leftArr);
        root.right = findRoot(rootIndex,preorder,rightArr);
        return root;
    }

    public static int getIndexOfArray(int[] arr,int value){
        int result = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                result = i;
            }
        }
        return result;
    }
}
