package reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获取类的信息
public class Demo08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflect.User");

        /*
        User user=new User();
        Class c1=user.getClass();
        */


        //获取类的名字
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        //获得类的属性
        System.out.println("===========================");
        Field[] fields = c1.getFields();//只能找到public属性
        for(Field field:fields)
        {
            System.out.println(field);
        }

        System.out.println("===========================");
        fields=c1.getDeclaredFields();//找到全部属性
        for(Field field:fields)
        {
            System.out.println(field);
        }

        //获得指定属性的值
        Field name=c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("===========================");
        Method[] methods = c1.getMethods();//获取本类及其父类的全部public方法
        for(Method method:methods)
        {
            System.out.println(method);
        }

        System.out.println("================================");

        methods=c1.getDeclaredMethods();//获得本类的所有方法
        for(Method method:methods)
        {
            System.out.println(method);
        }


        //获得指定方法
        //重载
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);

        System.out.println(getName);
        System.out.println(setName);

        //获得指定的构造器
        System.out.println("======================");
        Constructor[] constructors = c1.getConstructors();//public方法
        for(Constructor constructor:constructors)
        {
            System.out.println(constructor);
        }

        constructors=c1.getDeclaredConstructors();//所有方法
        for(Constructor constructor:constructors)
        {
            System.out.println("###"+constructor);
        }

        //获得指定的构造器
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        System.out.println("constructor"+constructor);
    }
}
