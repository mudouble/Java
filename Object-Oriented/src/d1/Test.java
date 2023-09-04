package d1;

public class Test {
    public static void main(String[] args) {
        //类名.类变量
        Student.name = "talyor";

        //对象.类变量(不推荐)
        Student s = new Student();
        s.name = "tom";
        System.out.println(Student.name);

        //实例对象
        s.age = 23;
        Student s1 = new Student();
        s1.age = 18;
        System.out.println(s.age+" "+ s1.age);

        //类方法
        Student.printHelloWorld();
        s.printHelloWorld();

        //实例方法
        s.printScore();

    }
}
