package generic;

//多元泛型
public class Demo03 {
    public static void main(String[] args) {
        NotePad<String,Integer> t=null; //定义两个泛型类型的对象
        t=new NotePad<String,Integer>();        //里面的key为String,value为Integer

        t.setKey("Tom");
        t.setValue(20);

        System.out.println("姓名： "+t.getKey());

        System.out.println("年龄： "+t.getValue());
    }
}

class NotePad<K,V>{     //  此处指定了两个泛型变量
    private K key;      //此变量的类型由外部决定
    private V value;    //此变量的类型由外部决定

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
