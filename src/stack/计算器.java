package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1.通过index遍历表达式
 * 2.如果是数字，就入数字栈
 * 3.如果是符号，就分两种情况
 *     3.1如果符号栈为空，直接入栈
 *     3.2如果符号栈有操作符，则比较优先级，如果当前的操作符运算优先级小于或等于符号栈顶的操作符
 *          则先从数字栈中取出两个数字，栈中取出符号，计算后，符号再入栈
 *          如果符号优先级大于栈中操作符，就直接入符号栈
 * 4.表达式完毕则顺序出栈运算
 * 5.最后数字栈中只有一个数字，就是结果
 */
public class 计算器 {


    static Map<String,Integer> prior = new HashMap<>();

    static {
        prior.put("+",1);
        prior.put("-",1);
        prior.put("*",2);
        prior.put("/",2);
    }

    public static void main(String[] args) {
        System.out.println(count("2+3*6-5+6*6"));
    }

    public static int count(String countStr){

        Stack<Integer> num = new Stack<>();
        Stack<String> oper = new Stack<>();

        for(int i=0 ; i<=countStr.length()-1 ; i++){
            //读取表达式入栈
            String x = countStr.charAt(i)+"";
            if(prior.containsKey(x)){
                //字符
                if(oper.empty()){
                    oper.push(x);
                }else{
                    //判断符号优先级
                    if(prior.get(x)<=prior.get(oper.peek())){
                        Integer num1 = num.pop();
                        Integer num2 = num.pop();
                        num.push(countTwoNum(num2,num1,oper.pop()));
                    }
                    oper.push(x);
                }
            }else{
                //数字
                num.push(Integer.parseInt(x));
            }
        }

        while (oper.size()!=0){
            Integer num1 = num.pop();
            Integer num2 = num.pop();
            num.push(countTwoNum(num2,num1,oper.pop()));
        }

        return num.pop();
    }

    private static Integer countTwoNum(Integer num1,Integer num2,String oper){
        Integer result = null;
        switch (oper){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        return result;
    }
}
