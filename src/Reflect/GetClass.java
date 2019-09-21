package Reflect;

public class GetClass {
    public static void main(String[] args) {
        checkClass();
    }
    public static void checkClass() {
        try{
            System.out.println("使用对象的getClass方法:");
            Class c1=new Student().getClass();
            System.out.println(c1.getName());

            System.out.println("使用类名.class方法:");
            Class c2=Student.class;
            System.out.println(c1.getName());

            System.out.println("使用Class类的静态方法:");
            Class c3=Class.forName("Reflect.Student");
            System.out.println(c1.getName());
            Class c4=new Student().getClass();

            System.out.println("c1c2:"+(c1==c2)+"\nc2c3:"+(c2==c3)+"\nc1c3:"+(c1==c3));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }
class Student{
    private int id;
    private  String name;
    public Student(){
        id=0;
        name="def";
    }
}
