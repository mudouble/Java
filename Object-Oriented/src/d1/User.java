package d1;

public class User {
    public static int number;
    public User(){
        //每个对象都会调用这个构造方法，那么number就会加
        User.number++;

        //在同一个类中，访问自己类的类变量，可省略类名不写
        //number++;
    }
}
