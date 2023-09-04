package d3;

public class A {
    //2.定义一个类变量记住类的一个对象
//    private static A a = new A();
    private static A a;  //懒汉式单例设计
//    //1.私有类的构造器，私有之后外面都不可以创建对象
    private A(){

    }
    //定义一个类方法返回类的对象
    public static A getInstance(){
        if(a==null){
            a=new A();
        }
        return a;
    }
//    public static A getObject(){
//        return a;
//    }




}
