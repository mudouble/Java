package d4;

class Students{
    private String name;
    private  int age;
    private String schoolName;

    public Students() {
    }


    public Students(String name, int age) {
//        this.name = name;
//        this.age = age;
//        this.schoolName = "qingHua";
        this(name, age, "qingHua");
    }

    public Students(String name, int age, String schoolName) {
        this.name = name;
        this.age = age;
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        B b = new B();
        b.print2(2,3);
        b.print1();

        Student s = new Student("yes", 18);

        System.out.println(s.toString());    //地址
//        System.out.println(s);

        Students s1 = new Students("yes", 10, "Bili");
        Students s2 = new Students("no", 23);
        System.out.println(s1);
        System.out.println(s2);

    }
}
