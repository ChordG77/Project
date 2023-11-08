package com.review.www;

import java.math.BigDecimal;
import java.util.Comparator;

public class EnumDemo {

    public static void main(String[] args) {
        // 枚举类型
        System.out.println(inner.test.getI());
        double i  =0.1;
        BigDecimal a = BigDecimal.valueOf(i);
        System.out.println(BigDecimal.valueOf(i));


        String s = "100";
        int  ss =  Integer.valueOf(s);
        System.out.println(ss);

        inner in = new sinner(new Comparator<sinner>(){
            @Override
            public int compare(sinner o1, sinner o2) {
                return 0;
            }            
        });
        in.doubletest();
    }
}

class  inner {

    public class test{
        public static  int  i =  10;
        public static int getI(){
            return i ;
        }
    }

    public void doubletest(){
        System.out.println("test");
    }

}

class sinner extends  inner{

    public sinner(Comparator<sinner> comparator) {
        super();
    }
}
enum Color {
    RED(100), GREEN(1), BLUE(20);

    private final int value;
    private  Color(int i){
        this.value = i;
    }
    public  int getValue(){
        return value;
    }
}