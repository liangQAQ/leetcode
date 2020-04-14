package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 1.数字直接入队列
 * 2.运算符要与栈顶元素比较
 *  ①栈为空直接入栈
 *  ②运算符优先级大于栈顶元素优先级则直接入栈
 *  ③小于或等于则出栈入列，再与栈顶元素进行比较，直到运算符优先级小于栈顶元
 *     素优先级后，操作符再入栈
 * 3.操作符是 ( 则无条件入栈
 * 4.操作符为 )，则依次出栈入列，直到匹配到第一个(为止，此操作符直接舍弃，(直接出栈舍弃
 *
 */
public class 中缀表达式转换为后缀表达式 {

    public static void main(String[] args) {
        System.out.println(string2ReversePoland("1 + ( ( 2 + 3 ) * 4 ) - 5"));
    }

    public static String string2ReversePoland(String string){
        List<String> ready = new ArrayList<>();
        Stack<String> operStack = new Stack<>();
        String[] arr = string.split(" ");
        for(String str : arr){
            boolean matches = Pattern.compile("\\d+").matcher(str).matches();
            if(matches){
                //数字
                ready.add(str);
            }else{
                //运算符
                if(operStack.empty()){
                    operStack.push(str);
                }else{
                    if("(".equals(str)){
                        //左括号直接入栈
                        operStack.push(str);
                    }else if(")".equals(str)){
                        //依次出操作栈直到匹配到（ ,将括号以外的内容输出到队列
                        while (true){
                            String s = operStack.pop();
                            if("(".equals(s)){
                                break;
                            }else{
                                ready.add(s);
                            }
                        }
                    }else{
                        //操作符
                        compareLevel(operStack,str,ready);
                    }
                }
            }
        }
        return ready.toString();
    }

    private static void compareLevel(Stack<String> operStack,String str,List ready){
        if(operStack.empty()){
            operStack.push(str);
            return;
        }
        String oper = operStack.peek();//栈顶操作符
        if("(".equals(oper)){
            operStack.push(str);
            return;
        }
        if(getLevel(str)>getLevel(oper)){
            operStack.push(str);
        }else{
            ready.add(operStack.pop());
            compareLevel(operStack,str,ready);
        }
    }

    private static int getLevel(String key){
        if("+".equals(key)||"-".equals(key)){
            return 1;
        }else if("*".equals(key)||"/".equals(key)){
            return 2;
        }
        return 0;
    }
}
