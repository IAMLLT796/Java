package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TryWithResource {
    private static void tryWithResourceTest(){
        try(Scanner scanner=new Scanner(new FileInputStream("c:/abc"),"UTF-8"))
        {
            //code
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void closeResourceInFinally()
    {
        FileInputStream inputStream=null;
        try{
            File file=new File("./tmp.txt");
            inputStream=new FileInputStream(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
    }finally{
            if(inputStream!=null)
            {
                try{
                    inputStream.close();
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
    }
    }
}





