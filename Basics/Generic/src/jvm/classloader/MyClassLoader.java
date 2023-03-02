package jvm.classloader;

public class MyClassLoader extends ClassLoader
{
    private String root;

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        byte[] classData=loadClassData(name);
        if(classData==null)
        {
            throw new ClassNotFoundException();
        }
        else {
            return defineClass(name,classData,0,classData.length);
        }
    }

    private byte[] loadClassData(String className)
    {
        return null;
    }
}
