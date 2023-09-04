package Criminal;

import d4.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

//最初的写法：全部写在一个class文件；囚犯类没有构造方法
class People{
   private int code;
   private int location;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}

public class Test1 {

    public boolean unqiue(int code, ArrayList<People> people){
        for (int i = 0; i < people.size(); i++) {
            People people1 = people.get(i);
            if (code== people1.getCode()){
                return false;
            }
        }
        return true;
    }
    //生成囚犯的编号，没有使用构造方法
    public ArrayList<People> criminals(){
        ArrayList<People> people = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i <100; i++) {
            int code = random.nextInt(200)+1;
            if (unqiue(code, people)){
                People people1 = new People();
                people1.setCode(code);
                people1.setLocation(i+1);
                people.add(people1);
            }else{
                i--;
            }
        }
        return people;
    }

    //因为杀掉的人是按照索引进行删除，如果使用remove会导致原数组的大小发生改变，同时迭代器的状态也会发生变化
    //即使使用iterator迭代器进行迭代，其指向也是指向当前元素，而没有按照原来的数组大小进行索引
    //所以最直接的方法就是创建副本
    public People luckier(ArrayList<People> people){


        ArrayList<People> people1 = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            if ((i+1)%2==0){
                people1.add(people.get(i));
            }
        }
        if (people1.size()==1){
            return people1.get(0);
        }else{
            return luckier(people1);  //递归
        }


    }

    public static void main(String[] args) {
        //如果想要在static方法里调用其他方法，那调用的方法应该是类方法，不然就得使用实例化对象引用

    }
}
