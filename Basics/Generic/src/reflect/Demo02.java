package reflect;

public class Demo02 extends Object {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("reflect.User");
        System.out.println(c1);

        Class<?> c2 = Class.forName("reflect.User");
        Class<?> c3 = Class.forName("reflect.User");
        Class<?> c4 = Class.forName("reflect.User");

        //一个类在内存中只有一个Class对象
        //一个类在被加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}

class User
{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

