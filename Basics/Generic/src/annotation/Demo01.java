package annotation;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {

    }
}

class A
{
    public void test()
    {

    }
}

class B extends A{

    //重载父类的test方法
    @Override
    public void test() {

    }

    //被弃用的方法
    @Deprecated
    public void oldMethod()
    {

    }

    //忽略告警
    @SuppressWarnings("rawtypes")
    public List processList(){
        List list=new ArrayList();
        return list;
    }
}
