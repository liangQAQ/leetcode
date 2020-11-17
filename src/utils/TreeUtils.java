package utils;

import ListNode.entity.TreeNode;

public class TreeUtils {
    public static TreeNode array2TreeNode(Integer[] arr){

        TreeNode result = new TreeNode(0);
        helper(result,arr,0);

        return result;
    }

    public static void helper(TreeNode result,Integer[] arr,int index){
        if(index>=arr.length){
            return ;
        }
        result.val = arr[index];
        int indexLeft = 2*index+1;
        int indexRight = 2*index+2;
        if(indexLeft <= arr.length-1 && arr[indexLeft]!=null){
            result.left = new TreeNode(arr[indexLeft]);
            helper(result.left,arr,indexLeft);
        }
        if(indexRight <= arr.length-1 && arr[indexRight]!=null){
            result.right = new TreeNode(arr[indexRight]);
            helper(result.right,arr,indexRight);
        }
    }

    public static void main(String[] args) {
//        Integer[] arr = {3,9,20,null,null,15,7};
        Integer[] arr = {1,null,2,3};
        array2TreeNode(arr);

    }
}
