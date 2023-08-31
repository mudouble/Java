import jdk.swing.interop.SwingInterOpUtils;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class HospitalManager {
    //科室信息
    private ArrayList<Department> allDepartments = new ArrayList<>();
    // 预约信息
    private ArrayList<Appointment> appointments = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("===欢迎进入仁爱医院信息管理系统===");
            System.out.println("1、科室管理-添加科室");
            System.out.println("2、科室管理-删除科室");
            System.out.println("3、科室管理-修改科室");
            System.out.println("4、医生管理-录入医生");
            System.out.println("5、医生管理-医生坐诊设置（可设置当天和未来6天的坐诊情况）");
            System.out.println("6、医生管理-展示全部医生的坐诊详情（当前和未来6天的坐诊情况）");
            System.out.println("7、医生管理-挂号预约");
            System.out.println("8、搜索某个医生当前和未来6天内的病人预约详情（展示每天预约病人的具体信息）");
            System.out.println("请输入操作命令： ");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    removeDepartment();
                    break;
                case 3:
                    alterDepartment();
                    break;
                case 4:
                    addDoctor();
                    break;
                case 5:
                    seeingPatient();
                    break;
                case 6:
                    displaySeeingPatients();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("输入命令无效，请重新输入！");
            }

        }
    }

    private void displaySeeingPatients() {
        System.out.println("===全部医生的坐诊信息===");
        for (int i = 0; i < allDepartments.size(); i++) {
           Department department = allDepartments.get(i);
            System.out.println((i+1)+"."+department.getName());
            System.out.println("--------------------------------------");
            ArrayList<Doctor> doctors = department.getDoctors();
            for (int j = 0; j < doctors.size(); j++) {
                Doctor doctor = doctors.get(i);
                System.out.println(doctor.getName()+"医生的坐诊信息如下： ");
                ArrayList<Schedule> schedules = doctor.getSchedules();
                updateSchedule(schedules);    //更新一下时间
//                System.out.println(schedules.size());
                for (int k = 0; k < schedules.size(); k++) {
                    Schedule schedule = schedules.get(k);
                    System.out.println(schedule.getTody());
                    if (!schedule.isUpdate()){
                        System.out.println("未排班");
                        continue;
                    }
                    if (schedule.isMorning()){
                        System.out.println("上午 "+schedule.getMstart()+"-"+schedule.getMend()
                        +"总数/预约数： "+schedule.getmTotalNumber());
                    }else{
                        System.out.println("上午休息");
                    }
                    if (schedule.isAfternoon()){
                        System.out.println("下午 "+schedule.getAstart()+"-"+schedule.getAend()
                                +"总数/预约数： "+schedule.getaTotalNumber());
                    }else{
                        System.out.println("下午休息");
                    }
                }
            }
        }

    }

    private void seeingPatient() {
        System.out.println("===设置医生的坐诊时间===");
        while (true) {
            Department department = departmentByUser();
            ArrayList<Doctor> doctors = department.getDoctors();
            if (doctors.size()==0){
                System.out.println("当前科室并无医生");
                return;
            }
            System.out.println("当前科室医生如下： ");
            for (int i = 0; i < doctors.size(); i++) {
                Doctor doctor = doctors.get(i);
                System.out.println((i+1)+"、"+doctor.getName());
            }
            System.out.println("请选择： ");
            int command = sc.nextInt();
            if (command<1 || command>doctors.size()){
                System.out.println("选择有误，请重新确认~");
            }
            Doctor doctor = doctors.get(command-1);

            ArrayList<Schedule> schedules = doctor.getSchedules();

            //更新未来七天的时间
            updateSchedule(schedules);

            for (int i = 0; i < schedules.size(); i++) {
                Schedule schedule = schedules.get(i);
                updateDoctorSchedule(schedule);
            }
            break;
        }

    }

    private void updateDoctorSchedule(Schedule schedule) {
        LocalDate today = schedule.getTody();
        System.out.println(today+"的安排如下： ");
        if(!schedule.isUpdate()){
            System.out.println("未排班");
        }else{
            System.out.println("上午");
            if (schedule.isMorning()){
                System.out.println("坐诊时间为： "+schedule.getMstart()+"-"
                +schedule.getMend()+"总数/预约数： "+schedule.getmTotalNumber());
            }else{
                System.out.println("休息");
            }
            System.out.println();
            System.out.println("下午");
            if (schedule.isAfternoon()){
                System.out.println("坐诊时间为： "+schedule.getAstart()+"-"
                        +schedule.getAend()+"总数/预约数： "+schedule.getaTotalNumber());
            }else{
                System.out.println("休息");
            }
        }
        System.out.println("是否修改？y/n");
        String rs = sc.next();
        if("y".equals(rs)){
            schedule.setUpdate(true);
            System.out.println("上午是否上班？y/n");
            String rs2 = sc.next();
            if("y".equals(rs2)){
                schedule.setMorning(true);
                System.out.println("上班的开始时间和结束时间是： ");
                String start = sc.next();
                String end = sc.next();
                System.out.println("可预约的人数是： ");
                int number = sc.nextInt();
                schedule.setMstart(LocalTime.parse(start));
                schedule.setMend(LocalTime.parse(end));
                schedule.setmTotalNumber(number);
            }else{
                schedule.setMorning(false);
            }

            System.out.println("下午是否上班？y/n");
            String rs3 = sc.next();
            if("y".equals(rs3)){
                schedule.setAfternoon(true);
                System.out.println("上班的开始时间和结束时间是： ");
                String start = sc.next();
                String end = sc.next();
                System.out.println("可预约的人数是： ");
                int number = sc.nextInt();
                schedule.setAstart(LocalTime.parse(start));
                schedule.setAend(LocalTime.parse(end));
                schedule.setaTotalNumber(number);
            }else{
                schedule.setAfternoon(false);
            }

        }
    }

    //更新当前到未来6天的时间
    private void updateSchedule(ArrayList<Schedule> schedules) {
        if (schedules.size()==0){
            for (int i = 0; i < 7; i++) {
                Schedule schedule = new Schedule();
                LocalDate now = LocalDate.now();
                schedule.setTody(now.plusDays(i));   //在当前日期上加上i
                schedules.add(schedule);
            }
            return;
        }
        //去除过期时间
        for (int i = 0; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);
            LocalDate now = LocalDate.now();     //当前时间
            LocalDate current = schedule.getTody();   //schedule的日程日期
            if(current.equals(now)){
                break;
            }
            if (current.isBefore(now)){
                schedules.remove(schedule);
                i--;
            }
        }

        //补全当前和未来6天的时间
        LocalDate last = schedules.get(schedules.size()-1).getTody();
        int time = schedules.size();   //变量一定要用变量存下来
        for (int i = 0; i < 7-time; i++) {
            Schedule schedule = new Schedule();
            schedule.setTody(last.plusDays(i+1));
            schedules.add(schedule);
        }

    }

    private Department departmentByUser() {
        if (allDepartments.size() == 0) {
            System.out.println("没有科室");
            return null;
        }
        System.out.println("请选择科室： ");
        for (int i = 0; i < allDepartments.size(); i++) {
            Department department = allDepartments.get(i);
            System.out.println((i + 1) + "、" + department.getName());

        }
        System.out.println("请输入： ");
        int command = sc.nextInt();
        if (command < 1 || command > allDepartments.size()) {
            System.out.println("选择有误，请重新确认~");
        }

        Department department = allDepartments.get(command - 1);
        return department;
    }

    private void addDoctor() {
        System.out.println("==添加医生==");
        while (true) {
            Department department = departmentByUser();
            System.out.println("请输入医生的姓名");
            String name = sc.next();
            System.out.println("请输入医生的年龄");
            int age = sc.nextInt();
            System.out.println("请输入医生的性别");
            String sex = sc.next();
            System.out.println("请输入医生的特长： ");
            String specialty = sc.next();
            System.out.println("请输入医生的入职时间（yyyy-MM-dd）： ");
            String joinDateString = sc.next();
            LocalDate joinDate = LocalDate.parse(joinDateString);    //需要将时间字符串转换为时间对象

            Doctor doctor = new Doctor();
            doctor.setDoctorId(UUID.randomUUID().toString());   //可以类似ATM项目里随机生成8位编号
            doctor.setAge(age);
            doctor.setName(name);
            doctor.setDepartment(department.getName());
            doctor.setGender(sex);
            doctor.setSpecialty(specialty);
            doctor.setJoinDate(joinDate);
            //department.setDoctors(doctor);    //添加的医生需要是列表  ？
            department.getDoctors().add(doctor);
            break;
        }

    }


    private void alterDepartment() {
        System.out.println("==修改科室==");
        OUT:
        while (true) {
            Department department = departmentByUser();
            if(department==null){
                return;
            }else{
                System.out.println("请输入新的科室名字");
                String newName = sc.next();
                for (int i = 0; i < allDepartments.size(); i++) {
                    if(newName.equals(department.getName())){
                        System.out.println("输入的科室名称与原来的相同，请重新输入");
                        continue OUT;
                    }

                }
                department.setName(newName);
                System.out.println("修改科室成功");
                break;
            }
        }

    }

    private void removeDepartment() {
        System.out.println("==删除科室==");
        while (true) {
            Department department = departmentByUser();
            if(department==null){
                return;
            }else{
                allDepartments.remove(department);
                System.out.println("删除科室成功");
                break;
            }
        }
    }

    private void addDepartment() {
        System.out.println("==添加科室==");
        OUT:
        while (true) {
            System.out.println("请输入科室的名称：");
            String name = sc.next();
            for (int i = 0; i < allDepartments.size(); i++) {
                Department department = allDepartments.get(i);
                if (name.equals(department.getName())) {
                    System.out.println("该科室已经存在");
                    continue OUT;
                }
            }
            Department new_department = new Department();
            new_department.setName(name);
            allDepartments.add(new_department);
            System.out.println("添加科室成功");
            break;
        }


    }


}
