package stack;

import java.util.Stack;

/**
 * 左括号入栈，右括号匹配到栈顶的左括号就出栈
 */
public class 校验括号 {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        Stack s3 = new Stack();
        String[] arr = s.split("");
        boolean flag = true;
        for(String item : arr){
            if("(".equals(item)){
                flag = count(s1,item,"l");
            }else if(")".equals(item)){
                flag =count(s1,item,"r");
            }else if("{".equals(item)){
                flag =count(s2,item,"l");
            }else if("}".equals(item)){
                flag =count(s2,item,"r");
            }else if("[".equals(item)){
                flag =count(s3,item,"l");
            }else if("]".equals(item)){
                flag =count(s3,item,"r");
            }
            if(!flag){
                return false;
            }
        }

        return s1.empty()&&s2.empty()&&s3.empty();
    }

    public static boolean count(Stack s ,String item, String type){
        if("l".equals(type)){
            s.push(item);
        }else{
            if(s.empty()){
                return false;
            }
            if("(".equals(s.peek())||"[".equals(s.peek())||"{".equals(s.peek())){
                s.pop();
            }
        }
        return true;
    }
}
