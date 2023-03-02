# 创建文件的三种方式

>```
>文件在程序中是以流的形式来操作的
>流：数据在数据源（文件）和程序（内存）之间经历的路径
>输入流：数据从数据源（文件）到程序（内存）的路径
>输出流：数据从程序（内存）到数据源（文件）的路径
>```



~~~java
//方式一
//new File(String pathname)    根据路径构造一个File对象
public void create01()
    {
        String filePath="D:\\JAVA\\Advanced\\IO Test\\news1.txt";

        File file=new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//方式二
//new File(File parent, String child)  根据父目录文件+子路径构建
    @Test
    public void create02()
    {
        File parent=new File("D:\\JAVA\\Advanced\\IO Test");
        String fileName="news2.txt";
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile方法，才会真正的在磁盘创建该文件
        File file = new File(parent, fileName);

        try {
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//方式三
//new File(String parent, String child)    根据父目录+子路径构建
    @Test
    public void create03()
    {
        String parent="D:\\JAVA\\Advanced\\IO Test";
        String child="news03.txt";

        File file=new File(parent,child);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
~~~



# 获取文件信息

~~~java
public void info()
    {
        //先创建文件对象
        File file=new File("D:\\JAVA\\Advanced\\IO Test\\news1.txt");

        //调用相应的方法，得到对应信息
        System.out.println("文件名字="+file.getName());

        //获取文件的绝对路径
        System.out.println("文件绝对路径="+file.getAbsolutePath());

        //得到文件父目录
        System.out.println("文件父级目录="+file.getParent());

        //得到文件大小
        System.out.println("文件大小（字节）="+file.length());

        //判断文件是否存在
        System.out.println("文件是否存在="+file.exists());//true

        //判断是否为一个文件
        System.out.println("是不是一个文件="+file.isFile());//T

        //判断是否为一个目录
        System.out.println("是否为一个目录="+file.isDirectory());//F


    }
~~~

# 目录文件的操作和删除

>```
>mkdir创建一级目录   mkdirs创建多级目录    delete删除空目录或者文件
>```

## 判断文件是否存在，如果存在就删除

~~~java
public void m1()
    {
        String pathName="D:\\JAVA\\Advanced\\IO Test\\news1.txt";
        File file=new File(pathName);

        if(file.exists())
        {
            if(file.delete())
            {
                System.out.println(pathName+"该文件已经删除！");
            }else {
                System.out.println(pathName+"文件删除失败！");
            }
        }
        else
        {
            System.out.println("该文件不存在！");
        }

    }
~~~

## 判断目录是否存在，存在就删除，否则提示不存在



>```
>这里需要体会到在java编程中，目录也被当作文件
>```

~~~java
 public void m2()
    {
        String pathName="D:\\JAVA\\Advanced\\IO Test\\test";
        File file=new File(pathName);

        if(file.exists())
        {
            if(file.delete())
            {
                System.out.println(pathName+"该目录已经删除！");
            }else {
                System.out.println(pathName+"目录删除失败！");
            }
        }
        else
        {
            System.out.println("该目录不存在！");
        }
    }
~~~

## 判断目录是否存在，如果存在就提示已经存在，否则就创建

~~~java
public void m3()
    {
        String directoryPath="D:\\JAVA\\Advanced\\IO Test\\test\\a\\b\\c";
        File file=new File(directoryPath);

        if(file.exists())
        {
            System.out.println(directoryPath+"存在....");
        }
        else {
            if(file.mkdirs())//创建多级目录
            {
                System.out.println(directoryPath+"创建成功...");
            }
            else {
                System.out.println(directoryPath+"创建失败...");
            }
        }
    }
~~~



# Java IO流原理

>```
>1.I/O是Input/Output的缩写，I/O技术是非常实用的技术，用于处理数据传输，如读写文件，网络通讯等
>2.Java程序中，对于数据的输入/输出操作以”流(stream)“的方式进行
>3.java.io包下提供了各种”流“类和接口，用以获取不同种类的数据，并通过方法输入或者输出数据
>4.输入input:读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中
>5.输出output:将程序（内存）数据输出到磁盘、光盘等存储设备中
>```



## 流的分类

>1. 按操作数据单位不同分为：字节流（8 bit)-二进制文件，字符流（按字符，对应几个字节）-文本文件
>2. 按数据流的流向不同分为：输入流，输出流
>3. 按流的角色的不同分为：节点流，处理流/包装流



| 抽象基类 |    字节流    | 字符流 |
| :------: | :----------: | :----: |
|  输入流  | InputStream  | Reader |
|  输出流  | OutputStream | Writer |

>1. Java的IO流共涉及40多个类，实际上非常规则，都是从如上4个抽象基类派生的
>
>2. 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀



## 常用的类

>InputStream : 字节输入流
>
>​	InputStream抽象类是所有类字节输入流的超类
>
>InputStream常用的子类
>
>1.  FileInputStream:文件输入流
>2. BufferedInputStream:缓冲字节输入流
>3. ObjectInputStream:对象字节输入流