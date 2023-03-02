package generic;

//泛型的上限
//<? extends A>表示该类型参数可以是A（上边界）或者A的子类类型
public class Demo05 {
    public static void main(String[] args) {
        Info1<Integer> i1=new Info1<Integer>();     //声明Integer的泛型对象
    }
}

class Info1<T extends Number>{      //此处泛型只能是数字类型
    private T var;          //定义泛型变量

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public String toString() {      //直接打印
        return this.var.toString();
    }
}
