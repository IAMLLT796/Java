package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//使用注解
public class TestMethodAnnotation {
    @Override
    @MyMethodAnnotation(title = "toStringMethod",description = "override toString method")
    public String toString()
    {
        return "Override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method",description = "deprecated old static method")
    public static void oldMethod()
    {
        System.out.println("old method don't use it");
    }

    @SuppressWarnings({"unchecked","deprecation"})
    @MyMethodAnnotation(title = "test method",description="suppress warning static method")
    public static void genericsTest()
    {
        List l=new ArrayList<>();
        l.add("abc");
        oldMethod();
    }


    //用反射接口获取注解信息
    public static void main(String[] args) {
        try {
            //获取所有methods
            Method[] methods=TestMethodAnnotation.class.getClassLoader()
                    .loadClass("annonation.TestMethodAnnotion")
                    .getMethods();

            //遍历
            for(Method method:methods)
            {
                //方法上是否有MyMethodAnnotation注解
                if(method.isAnnotationPresent(MyMethodAnnotation.class))
                {
                    try{
                        //获取并遍历MyMethodAnnonation对象信息
                        for(Annotation anno:method.getDeclaredAnnotations()){
                            System.out.println("Annotation in method '"+method+"' :"+anno);
                        }

                        //获取MyMethodAnnonation对象信息
                        MyMethodAnnotation methodAnno=method.getAnnotation(MyMethodAnnotation.class);
                        System.out.println(methodAnno.title());
                    }catch(Throwable ex)
                    {
                        ex.printStackTrace();
                    }

                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}




































