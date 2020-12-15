package design;

/**
 * 两个超长位数的相加
 * long型都装不下
 *
 * 从后往前  逐位相加   大于10向前进1位
 */
public class 两个超长位数相加 {

    public static void main(String[] args) {


    }

    public String sum(String num1,String num2){
        int length1 = num1.length();
        int length2 = num2.length();

        StringBuilder result = new StringBuilder();

        int inc = 0;

        while(length1 != 0 || length2 != 0){
            int singSum = inc + Integer.parseInt(String.valueOf(num1.indexOf(length1))) + Integer.parseInt(String.valueOf(num2.indexOf(length2)));
            if(singSum >= 10){
                inc = 1;
            }
            result.insert(0,"");
        }

        if(length1>=length2){

        }else{

        }


        return null;
    }
}
