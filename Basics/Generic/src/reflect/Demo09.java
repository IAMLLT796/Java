package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class Demo09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1=Class.forName("reflect.User");

        //构造一个对象
        //User user=(User)c1.newInstance();//本质上是调用了类的无参构造器
        //System.out.println(user);

        //通过构造器创建对象
        //Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        //User user2=(User)declaredConstructor.newInstance("LLT","001","18");
        //System.out.println(user2);

        //通过反射调用普通方法
        User user3=(User)c1.newInstance();
        //通过反射获取一个方法
        //invoke:激活的意思
        //(对象，”方法的值“）
        Method setName=c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3,"LLT");
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4=(User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);//启动和关闭访问安全检查的开关
        name.set(user4,"LLT796");
        System.out.println(user4.getName());

    }
}
