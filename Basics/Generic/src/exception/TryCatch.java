package exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 三种情况
 * 1.try没有捕获异常
 * 2.try捕获到异常，但没有处理此异常的catch的语句
 * 3.try捕获到异常，有处理此异常的catch语句
 */
public class TryCatch {
    private static void readFile(String filePath) throws  MyException
    {
        File file=new File(filePath);
        String result;
        BufferedReader reader=null;

        try
        {
            reader=new BufferedReader(new FileReader(file));
            while((result=reader.readLine())!=null)
            {
                System.out.println(result);
            }

        }catch(IOException e){
            System.out.println("readFile method catch block.");
            MyException ex=new MyException("read file failed.");
            ex.initCause(e);
            throw ex;
    }finally{
            System.out.println("readFile method finally block.");

            if(null!=reader)
            {
                try{
                    reader.close();
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}





















