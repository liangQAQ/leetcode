package stack;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 我们先看一个例子...后缀表达式3 4 + 5 × 6 -的计算
 * 1.从左至右扫描，将3和4压入堆栈；
 * 2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素，注意与前缀表达式做比较），计算出3+4的值，得7，再将7入栈；
 * 3.将5入栈；
 * 4.接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
 * 5.将6入栈；
 * 6.最后是-运算符，计算出35-6的值，即29，由此得出最终结果
 */
public class 逆波兰表达式运算 {

    public static void main(String[] args) {
        System.out.println(countReversePolandStr("3 4 + 5 * 6 -"));
    }

    public static int countReversePolandStr(String reversePolandStr){
        Stack<Integer> stack = new Stack<>();
        Pattern pattern = Pattern.compile("\\d+");
        String[] arr = reversePolandStr.split(" ");
        for(String str : arr){
            if(pattern.matcher(str).matches()){
                //数字 直接入栈
                stack.add(Integer.parseInt(str));
            }else{
                //出栈两个数进行运算
                int result = 0;
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(str.equals("+")){
                    result = num1 + num2;
                }else if(str.equals("-")){
                    result = num1 - num2;
                }else if(str.equals("*")){
                    result = num1 * num2;
                }else if(str.equals("/")){
                    result = num1 / num2;
                }
                //运算结果入栈
                stack.add(result);
            }
        }
        return stack.pop();
    }
}
