package generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

//类型的擦除
//通过反射添加其他类型元素
public class Demo09 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);    //这样调用add方法只能存储整型，因为泛型类型的实例为Integer

        /**
         * 利用反射调用add()方法的时候，可以存储字符串
         * 这说明了泛型实力在编译之后被擦除掉了，只保留了原始类型
         */

        try {
            list.getClass().getMethod("add", Object.class).invoke(list, "asd");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
