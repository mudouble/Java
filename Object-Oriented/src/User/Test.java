package User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String userStr = "1001:张三:男:1999-10-10#1002:张以:男:1999-10-10#1003:张而:男:1999-10-10" +
                "#1004:张三:男:1999-10-10#1005:张刘:男:1999-10-10#1006:张里:男:1999-10-10";
        ArrayList<User> users = new ArrayList<>();
        String[] usersList = userStr.split("#");
        for (int i = 0; i < usersList.length; i++) {
            String[] usersLists = usersList[i].split(":");
            Long number = Long.parseLong(usersLists[0]);
            String name = usersLists[1];
            String gender = usersLists[2];
            String birthdayStr = usersLists[3];
            LocalDate birthday = LocalDate.parse(birthdayStr);
            User user = new User(name, gender, number,birthday);
            users.add(user);
        }

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }

        Map<String, Integer> map = new HashMap<>();
//        for (User user : users) {
//
//        }
        for (int i = 0; i < users.size(); i++) {
            String name = users.get(i).getName();
            if (map.containsKey(name)){
                map.compute(name,(key,oldvalue)->(oldvalue+1));
//                map.put(name, map.get(name)+1);
            }else{
                map.put(name,1);
            }
        }

        //遍历map
        map.forEach((key, value)->{
            System.out.println(key+": "+value);
        });

    }
}
