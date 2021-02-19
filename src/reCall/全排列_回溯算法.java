package reCall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * for 选择 in 选择列表:
 * 回溯算法解题套路框架
 *
 * # 做选择
 * 将该选择从选择列表移除
 * 路径.add(选择)
 * backtrack(路径, 选择列表)
 * # 撤销选择
 * 路径.remove(选择)
 * 将该选择再加⼊选择列表
 */
public class 全排列_回溯算法 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        count(list);
        System.out.println(res);
    }

    static List<List<Integer>> res = new LinkedList<>();

    private static void count(List<Integer> list){
        for(Integer k : list){
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> path = new LinkedList<>();
            //选择了k
            path.add(k);
            result.add(path);
            //继续选择,可选择的路径中要剔除k
            List<Integer> choiceLeft = new LinkedList<>(list);
            choiceLeft.remove(k);
            choice(result,choiceLeft);
        }
    }

    /**
     * @param result 已经走过的路
     * @param choice 剩下的选择
     * @return
     */
    private static void choice(List<List<Integer>> result, List<Integer> choice) {
        System.out.println("result="+result+">>>>"+"choice="+choice);
        if(choice==null || choice.size()==0){
            res.addAll(result);
            return ;
        }
        List<List<Integer>> newResult = new LinkedList<>();
        for(Integer k : choice){
            for(List<Integer> pathItem : result){
                if(pathItem.contains(k)){//为什么需要判断
                    continue;
                }
                List<Integer> path = new LinkedList<>(pathItem);
                //选择了k
                path.add(k);
                newResult.add(path);
                //继续选择,可选择的路径中要剔除k
                List<Integer> choiceLeft = new LinkedList<>();
                choiceLeft.addAll(choice);
                choiceLeft.remove(k);
                choice(newResult,choiceLeft);
            }
        }
    }
}
