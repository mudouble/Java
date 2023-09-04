package Criminal;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static ArrayList<Criminal> criminals = new ArrayList<>();
    public static void main(String[] args) {
        //生成囚犯编号
        Random random = new Random();
        for (int i = 1; i <= 100 ; i++) {
            int code = random.nextInt(200)+1;
            if (unique(code)){
                Criminal criminal = new Criminal(code, i);
                criminals.add(criminal);
            }else{
                i--;
            }
        }
        //输出囚犯信息
        for (int i = 0; i < criminals.size(); i++) {
            System.out.println(criminals.get(i).toString());
        }
        
        //杀掉奇数的人---实际上就是保留偶数的人
        while(criminals.size()>1){
            ArrayList<Criminal> tempCriminals = new ArrayList<>();
            for (int i = 0; i <criminals.size(); i++) {
                if ((i+1)%2==0){
                    tempCriminals.add(criminals.get(i));
                }
            }
            criminals = tempCriminals;
            System.out.println("tempCriminals.size "+tempCriminals.size());
            
        }
        //输出幸运儿
        System.out.println(criminals.get(0).toString());
        
    }
    
    public static boolean unique(int code){
        for (int i = 0; i < criminals.size(); i++) {
            Criminal criminal = criminals.get(i);
            if (criminal.getCode()==code){
                return false;
            }
        }
        return true;
    }
}
