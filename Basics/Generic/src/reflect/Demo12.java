package reflect;

import java.lang.annotation.*;

//练习反射操作注解
public class Demo12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("reflect.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        {
            System.out.println(annotations);
        }

        //获得注解的value的值
        Table table=(Table)c1.getAnnotation(Table.class);
        String value=table.value();
        System.out.println(value);

        //获得类指定的注解
        java.lang.reflect.Field f = c1.getDeclaredField("name");
        Field annonation=f.getAnnotation((Field.class));

        System.out.println(annonation.columnName());
        System.out.println(annonation.type());
        System.out.println(annonation.length());

    }
}

@Table("db_student")
class Student2{
    @Field(columnName = "dp_id",type="int",length=10)
    private int id;
    @Field(columnName = "dp_age",type="int",length=10)
    private int age;
    @Field(columnName = "dp_name",type="varchar",length=3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field{
    String columnName();
    String type();
    int length();
}
