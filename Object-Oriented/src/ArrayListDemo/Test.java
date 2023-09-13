package ArrayListDemo;

public class Test {
    public static void main(String[] args) {
        ArrayListClass<String> myArrayList = new ArrayListClass<>();
        myArrayList.add("yes");
        myArrayList.add("no");

        System.out.println(myArrayList.size());
        System.out.println(myArrayList);
        myArrayList.remove(1);
        System.out.println(myArrayList);

        myArrayList.forEach(s-> System.out.println(s));





    }
}
