package generic;

public class Demo01 {
    private static int add(int a,int b)
    {
        System.out.println(a+"+"+b+"="+(a+b));
        return a+b;
    }

    private static float add(float a,float b)
    {
        System.out.println(a+"+"+b+"="+(a+b));
        return a+b;
    }

    private static double add(double a,double b)
    {
        System.out.println(a+"+"+b+"="+(a+b));
        return a+b;
    }

    //泛型
    private static <T extends Number> double add(T a,T b)
    {
        System.out.println(a+"+"+b+"="+(a.doubleValue()+b.doubleValue()));
        return a.doubleValue()+b.doubleValue();
    }

    public static void main(String[] args) {
        Demo01 demo01=new Demo01();

        demo01.add(1,2);
        demo01.add(1.1,2.2);
        demo01.add(1.12312,2.442143);
    }
}
