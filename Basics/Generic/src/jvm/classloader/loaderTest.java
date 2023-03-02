package jvm.classloader;

//类的加载
//1.命令行启动应用时候由JVM初始化加载
//2.通过Class.forName()方法动态加载
//3.通过ClassLoader.loadClass()方法加载
public class loaderTest {
    public static void main(String[] args)throws ClassNotFoundException {
        ClassLoader loader=HelloWord.class.getClassLoader();
        System.out.println(loader);

        try {
            loader.loadClass("Test2");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class HelloWord
{

}

class Test2{
    static{
        System.out.println("静态初始块执行了！");
    }
}
