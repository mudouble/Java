import java.util.ArrayList;
import java.util.stream.Stream;

class backtrace{
    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        int c = (int) res.stream().count();
        System.out.println(c);
        res.stream().forEach(System.out::println);
    }
}