package annotation;


import java.util.ArrayList;


//测试类
public class TypeParameterAndTypeUseAnnonation <@myNotEmpty T>{
    //使用TYPE_PARAMETER类型，编译不通过
//    public @myNotEmpty T test(@myNotEmpty T a)
//    {
//        new ArrayList<@myNotEmpty String>();
//        return a;
//    }

    //使用TYPE_USE类型，编译通过
    public @MyNotNull T test2(@MyNotNull T a)
    {
        new ArrayList<@MyNotNull String>();
        return a;
    }
}
