package reflect;

//获取class对象的三种方式
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(Demo01.class);
        System.out.println();

        Demo01 demo01=new Demo01();
        System.out.println(demo01.getClass());
        System.out.println();

        try {
            System.out.println(Class.forName("reflect.Demo01"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
