package recursion;

import java.util.HashMap;
import java.util.Map;

public class 第N个泰波那契数 {

    private static Map<Integer,Integer> cache = new HashMap();

    public static void main(String[] args) {
        System.out.println(tribonacci(5));
    }


    public static int tribonacci(int n) {
        cache.put(0,0);
        cache.put(1,1);
        cache.put(2,1);
        return gui(n);
    }

    public static int gui(Integer n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }else{
            cache.put(n,gui(n-1)+gui(n-2)+gui(n-3));
            return cache.get(n);
        }
    }
}
