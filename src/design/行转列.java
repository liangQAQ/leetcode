package design;

public class 行转列 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{2,3,4},{3,4,5},{4,5,6},{5,6,7}};
        printArr(arr);
        printArr(rows2line(arr));
    }

    public static void printArr(int[][] arr){
        for(int i=0;i< arr.length ; i++){
            for(int j=0;j<arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rows2line(int[][] arr){
        int[][] result = new int[arr[0].length][arr.length];
        for(int i=0 ; i< result.length ; i++){
            for(int j=0 ; j< result[0].length ; j++){
                result[i][j] = arr[j][i];
                // [0][0]=[0][0] [0][1]=[1][0] [0][2]=[2][0]
            }
        }
        return result;
    }
}
