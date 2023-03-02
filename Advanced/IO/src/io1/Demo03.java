package io1;

import com.sun.security.jgss.GSSUtil;
import org.junit.Test;

import java.io.File;

//目录的操作和文件删除
//mkdir创建一级目录   mkdirs创建多级目录    delete删除空目录或者文件
public class Demo03 {
    public static void main(String[] args) {

    }

    //判断文件是否存在，如果存在就删除
    @Test
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

    //判断目录是否存在，存在就删除，否则提示不存在
    //这里需要体会到在java编程中，目录也被当作文件
    @Test
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

    //判断目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
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
}
