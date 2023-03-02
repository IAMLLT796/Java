package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class Demo11 {
    public void test01(Map<String,User> map, List<User> list)
    {
        System.out.println("test01");
    }

    public Map<String,User> test02()
    {
        System.out.println("test02");
        return null;
    }

    //通过注解获取泛型
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Demo11.class.getMethod("test01", Map.class, List.class);
        //method.setAccessible(true);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#"+genericParameterType);

            if(genericParameterType instanceof ParameterizedType)
            {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();

                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        method=Demo11.class.getMethod("test02",null);

        Type genericReturnType = method.getGenericReturnType();
        System.out.println("##"+genericReturnType);

        if(genericReturnType instanceof ParameterizedType)
        {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();

            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}
