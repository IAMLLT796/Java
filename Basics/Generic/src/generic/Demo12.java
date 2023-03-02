package generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 通过反射获取泛型的参数类型
 */
public class Demo12<T> {
    public static void main(String[] args) {
        Demo12<String> demo12=new Demo12<String>(){};

        Type superclass=demo12.getClass().getGenericSuperclass();
        //getActualTypeArguments返回确切的泛型参数，如Map<String,Integer>返回[String,Integer]
        Type type=((ParameterizedType)superclass).getActualTypeArguments()[0];

        System.out.println(type);
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
