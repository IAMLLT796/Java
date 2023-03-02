package io1;

/**
 * 文件在程序中是以流的形式来操作的
 * 流：数据在数据源（文件）和程序（内存）之间经历的路径
 * 输入流：数据从数据源（文件）到程序（内存）的路径
 * 输出流：数据从程序（内存）到数据源（文件）的路径
 */

//创建文件对象相关构造器和方法

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * new File(String pathname)    根据路径构造一个File对象
 * new File(File parent, String child)  根据父目录文件+子路径构建
 * new File(String parent, String child)    根据父目录+子路径构建
  */
public class Demo01 {
    public static void main(String[] args) {

    }

    //方式一
    @Test
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
}
