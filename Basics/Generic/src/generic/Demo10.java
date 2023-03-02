package generic;

import java.util.ArrayList;
import java.util.Date;

/**
 * 在调用泛型方法的时候，可以指定泛型，也可以不指定泛型
 *  1.在不指定泛型的情况下，泛型变量的类型为该方法中的几种类型的同一父类的最小级，直到Object
 *  2.在指定泛型的情况下，该方法的几种类型必须是该泛型的实力的类型或者其子类
 */
public class Demo10 {
    public static void main(String[] args) {
        /**
         * 不指定泛型的时候
         */
        int i=Demo10.add(1,2);//这两个参数都是Integer,所以T为Integer类型
        Number f=Demo10.add(1,1.2);//这两个参数一个是Integer,另一个是Float，所以取同一父类的最小级，为Number
        Object o=Demo10.add(1,"asd");//这两个参数一个是Integer,一个是String，所以取同一父类的最小级，为Object

        /**
         * 指定泛型的时候
         */
        int a=Demo10.<Integer>add(1,2);//指定了Integer,所以只能为Integer类型或者其子类
        //int b=Demo10.<Integer>add(1,2.4);//编译会出错，指定了Integer，不能为Float
        Number c=Demo10.<Number>add(1,2.4);//指定为Number,所以可以为Integer和Float


        //在泛型类中，不指定泛型的时候，此时泛型为Object
        //比如在ArrayList中，如果不指定泛型，那么这个ArrayList可以存储任意的对象
        ArrayList list=new ArrayList();
        list.add(1);
        list.add("1231");
        list.add(new Date());
    }

    //这是一个简单的泛型方法
    public static <T> T add(T x,T y)
    {
        return y;
    }
}
