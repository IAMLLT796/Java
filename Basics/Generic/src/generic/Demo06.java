package generic;

//泛型的下限

import java.util.Iterator;
import java.util.List;

public class Demo06 {
    public static void main(String[] args) {
        Info2<String> i1=new Info2<String>();       //声明String的泛型对象
        Info2<Object> i2=new Info2<Object>();       //声明Object的泛型对象
        i1.setVar("hello");
        i2.setVar(new Object());

        fun(i1);

        fun(i2);

    }

    public static void fun(Info2<? super String> temp)      //只能接受String或者Object类型的泛型，String类的父类只有Object类
    {
        System.out.println(temp+ " ,");
    }



    private <E extends Comparable<? super E>> E max(List<? extends E> e1)
    {
        if(e1==null)
        {
            return null;
        }

        //迭代器返回的元素属于E的某个子类型
        Iterator<? extends E> iterator=e1.iterator();
        E result=iterator.next();

        while(iterator.hasNext())
        {
            E next=iterator.next();

            if(next.compareTo(result)>0)
            {
                result=next;
            }
        }

        return result;
    }
}

class Info2<T>{
    private T var;  //定义泛型变量
    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public String toString() {      //直接打印
        return this.var.toString();
    }
}

