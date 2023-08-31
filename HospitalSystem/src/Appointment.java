import java.time.LocalDateTime;
import java.time.LocalTime;

public class Appointment {
    private String userName;
    private char sex;
    private int age;
    private String tel;
    private String desc;
    private String departName;
    private String doctorId;
    private LocalDateTime appintDateTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppintDateTime() {
        return appintDateTime;
    }

    public void setAppintDateTime(LocalDateTime appintDateTime) {
        this.appintDateTime = appintDateTime;
    }
}
