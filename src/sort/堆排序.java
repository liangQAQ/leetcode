package sort;

import java.util.Arrays;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){

        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1 ;j>0;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }

    /**
     * 将以 i为下标 的非叶子节点的树调整为大顶堆
     * 例如数组{4,6,8,5,9} 在经过adjustHeap一次后 => {4,9,8,5,6}
     *
     * @param arr 需要调整的数组
     * @param i 需要调整的顶堆中的非叶子节点
     * @param length 数组长度 （逐渐减少）
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for(int k = 2*i+1 ; k < length ; k=2*k+1){
            if(k+1 < length && arr[k] < arr[k+1]){//选出i节点中较大的子节点
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i=k;
            }else{
                break;

            }
            arr[i] = temp;
        }
    }

    //交换位置
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
