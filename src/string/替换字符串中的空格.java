package string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 */
public class 替换字符串中的空格 {
    public static String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        char[] charArr = s.toCharArray();
        for(char c : charArr){
            if(c == ' '){
                result.append("%20");
            }else{
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
