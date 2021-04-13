package dp;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 *
 *  第n阶台阶的跳发dp[n]
 *  第n-1阶台阶的跳发dp[n-1]
 *  第n-2阶台阶的跳发dp[n-2]
 *      dp[n] = dp[n-1]+dp[n-2]
 *      dp[1] = 1;
 *      dp[2] = 2;
 */
public class 青蛙跳台阶问题 {

    public static int numWays(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int i =3 ;
        if(n<i){
            return dp[n];
        }
        while(i<=n){
            dp[i] = dp[i-1] + dp[i-2];
            i++;
        }
        return dp[n] ;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
