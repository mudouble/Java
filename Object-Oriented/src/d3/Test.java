package d3;

public class Test {
    public static void main(String[] args) {
//        A a1=A.getObject();
//        A a2=A.getObject();
//        System.out.println(a1);
//        System.out.println(a2);
        A a = A.getInstance();
        A a1 = A.getInstance();
        System.out.println(a);
        System.out.println(a1);

    }
}
