package sort;


/**
 * (1)首先设定一个分界值，通过该分界值将数组分成左右两部分。 [2]
 * (2)将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分中各元素都小于或等于分界值，而右边部分中各元素都大于或等于分界值。 [2]
 * (3)然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。 [2]
 * (4)重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左、右两个部分各数据排序完成后，整个数组的排序也就完成了。 [2]
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr ={2,3,7,6,4,1,0,5,9,10,8};
        quickSort(arr);
        for(int i : arr){
            System.out.print(i+",");
        }
        System.out.println();
    }

    public static void quickSort(int arr[]){
        quickSortmethod(arr,0,arr.length-1);
    }

    private static void quickSortmethod(int[] arr,int startIndex,int endIndex){
        int i=startIndex;
        int j=endIndex;
        int tag = arr[i];
        String swapFrom = "j";
        while(i!=j){
            if(swapFrom.equals("j")){
                if(arr[j]<tag){
                    //i,j交换位置
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swapFrom = "i";
                }else{
                    j--;
                    continue;
                }
            }else{
                if(arr[i]>tag){
                    //i,j交换位置
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swapFrom = "j";
                }else{
                    i++;
                    continue;
                }
            }
        }
        //排左边的
        if(startIndex<i-1){
            quickSortmethod(arr,startIndex,i-1);
        }
        //排右边的
        if(i+1<endIndex){
            quickSortmethod(arr,i+1,endIndex);
        }
    }

}
