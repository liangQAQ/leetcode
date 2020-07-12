package dp;

/**
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 回文的特点：一个字符串为回文，它的左右两头相等，去掉后子串依旧相等。
 * i,j分别表示字符串的开始，结束下标
 * 动态规划：dp[i][j] = (s[i]==s[j]) && dp[i+1][j-1]
 */
public class 最长的回文子串 {

    public static String longestPalindrome(String s) {
        String result = "";
        if(s==null||s.length()<1){
            return result;
        }
        if(s.length()==1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int m=0 ; m<s.length() ; m++){//m为长度
            for(int n=0 ; n<s.length() ; n++){
                int i = n;
                int j = m+n;
                if(j>=s.length()){
                    break;
                }
                if(i==j){
                    dp[i][j] = true;
                }else if(j-i>2){//当长度大于3的时候，才适配状态转移方程
                    dp[i][j] = (s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
                }else{
                    dp[i][j] = (s.charAt(i)==s.charAt(j));
                }
                if(dp[i][j]){//当满足回文，为true的时候，记录下结果集，最长的一定是长度m最大的结果。
                    result = s.substring(i,j+1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "aaaaa";
        System.out.println(longestPalindrome(str));
    }

}
