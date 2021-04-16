package array;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 *
 * 给定target=20，返回false。
 *
 *
 * 思路：站在右上角看。这个矩阵其实就像是一个Binary Search Tree。然后，聪明的大家应该知道怎么做了。
 */
public class 有序二维数组中的查找 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length-1;
        return compare(matrix,target,i,j);
    }

    private static boolean compare(int[][] matrix, int target,int i,int j){
        if(j<0||i>=matrix.length){
            return false;
        }
        if(matrix[i][j]==target){
            return true;
        }else if(matrix[i][j]>target){
            j--;
        }else{
            //小于
            i++;
        }
        return compare(matrix, target, i, j);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 6;
        System.out.println(findNumberIn2DArray(arr,target));
    }
}
