package generic;

import java.util.ArrayList;

/**
 * 类型检查是在编译时完成的，new ArrayList()只是在内存中开辟了一个存储空间，可以存储任何类型对象
 * 真正涉及类型检查的是它的引用
 * 因为我们是使用它引用list1来调用它的方法
 * 所以list1引用能完成泛型类型的检查，而引用list2没有使用泛型，所以不行
 */
public class Demo11 {

    public static void main(String[] args) {
        ArrayList<String> list1=new ArrayList<>();
        list1.add("1");
        //list1.add(1);编译会错误
        String str1=list1.get(0); //返回类型就是String

        ArrayList list2=new ArrayList<String>();
        list2.add("1");//编译通过
        list2.add(1);//编译通过

        Object object=list2.get(0);//返回类型就是Object

        new ArrayList<String>().add("11");//编译通过
        //new ArrayList<String>().add(22);//编译错误

        String str2=new ArrayList<String>().get(0);//返回类型就是String

        //类型检查是针对引用的
        //谁是一个引用，用这个引用调用泛型方法，就会对这个引用调用的方法进行类型检测
        //而无关它真正引用的对象
    }
}
