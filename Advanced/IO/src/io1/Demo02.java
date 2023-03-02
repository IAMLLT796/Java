package io1;

import org.junit.Test;

import java.io.File;

public class Demo02 {
    public static void main(String[] args) {

    }

    //获取文件信息
    @Test
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
}
