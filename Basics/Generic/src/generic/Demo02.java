package generic;

//简单的泛型类
public class Demo02 {
    public static void main(String[] args) {
        Point<String> point=new Point<String>();    //里面的var类型是String类型
        point.setVar("it");
        point.getVar();

        System.out.println();

        System.out.println(point.getVar().length());
    }
}

class Point<T>{         //此处可以随便写标识符号，T是type的简称
    private T var;  //var的类型由T决定，即由外部决定
    public T getVar(){
        return var; // 返回值的类型由外部决定
    }

    public void setVar(T var){
        this.var=var;
    }
}
