package generic;

import java.util.ArrayList;

//类型的擦除
//原始类型相等
public class Demo08 {
    public static void main(String[] args) {
        ArrayList<String> list1=new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2=new ArrayList<Integer>();
        list2.add(123);

        //泛型类型String和Integer在编译时都被擦除掉了，只剩下原始类型
        System.out.println(list1.getClass()==list2.getClass());//true
    }
}
