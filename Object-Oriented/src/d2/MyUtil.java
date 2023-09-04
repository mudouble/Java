package d2;

import java.util.Random;

public class MyUtil {
    static  int number = 80;
    //静态代码块
    static {
        System.out.println("Static code run");
    }
    //实例代码块
    {
        System.out.println("Instance");
    }
    public MyUtil(){
        System.out.println("without parameters develop function");
    }
    public static String createCode(int n){
        String code = "";
        String data= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        for(int i=0;i<n;i++){
            int index = r.nextInt(data.length());
            code+=data.charAt(index);
        }
        return code;
    }

}
