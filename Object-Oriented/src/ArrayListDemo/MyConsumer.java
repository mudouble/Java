package ArrayListDemo;
@FunctionalInterface
public interface MyConsumer<E> {
    void accept(E e);
}


//@FunctionalInterface 注解用于标记接口 MyConsumer<E>，指示该接口是一个函数式接口，
// 即只包含一个抽象方法，可以用于 Lambda 表达式或方法引用
//函数接口允许使用Lambda表达式；支持函数式编程，传递函数；Stream API使用；标准化API