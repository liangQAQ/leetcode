package reCall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class 全排列 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> target = new ArrayList<>();
        for(int num : nums){
            target = setTarget(num,target);
        }

        System.out.println(target);
    }

    public static List<List<Integer>> setTarget(int num , List<List<Integer>> list){
        List<List<Integer>> result = new LinkedList<>();
        if(list.size()==0){
            LinkedList<Integer> single = new LinkedList<>();
            single.add(num);
            result.add(single);
        }else{
            //这个元素可以插入的位置
            LinkedList<Integer> single = null;
            for(List<Integer> item : list){
                for(int i=0 ; i <= item.size() ; i++){
                    single = new LinkedList();
                    single.addAll(item);//深拷贝
                    single.add(i,num);
                    result.add(single);
                }
            }
        }
        return result;
    }
}
