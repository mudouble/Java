package Target;

import d3.A;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static ArrayList<Numberss> numbers = new ArrayList<>();
    public static int nums[] = {5, 7, 7, 8, 8, 10};
    public static int ans[] = {-1, -1};

    public static void main(String[] args) {

        while (true) {
            System.out.println("target：");
            Scanner sc = new Scanner(System.in);
            int target = sc.nextInt();
            //暴力求解
//            boolean flag = false;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i]==target){
//                    ans[0]=i;
//                    if (i==nums.length-1){
//                        ans[1]=i;
//                        break;
//                    }
//                    for (int j = i+1; j < nums.length; j++) {
//                        if (nums[j]>target){
//                            ans[1]=j-1;
//                            flag = true;
//                            break;
//                        }
//                    }
//                    if (flag){
//                        break;
//                    }
//                }
//            }
//            System.out.println(ans[0]+" "+ ans[1]);


            //面向对象方法   （下面的方法本质上还是暴力求解，虽然使用对象思想，但是没必要）
            // public static ArrayList<Numberss> numbers = new ArrayList<>();  类变量不能在方法之内声明
            //类变量（也称为静态变量）通常在类的顶部、方法之外声明
//            for (int i = 0; i < nums.length; i++) {
//                if (unique(nums[i])==null){
//                    Numberss number = new Numberss(nums[i], i, i);
//                    numbers.add(number);
//                }else{
//                    unique(nums[i]).setEnd(i);
////                    Numberss numberss = unique(nums[i]);
////                    numberss.setEnd(i);
//                }
//            }
//
//            boolean flag = true;
//            for (int i = 0; i < numbers.size(); i++) {
//                Numberss numberss = numbers.get(i);
//                if (target==numberss.getValue()){
//                    System.out.println(numberss.getStart()+" "+numberss.getEnd());
//                    flag=false;
//                }
//            }
//            if (flag){
//                System.out.println(-1+" "+-1);
//            }

            //折半查找log2n
            //找到最左边的target和最右边的target的位置
            int low = 0;
            int high = nums.length - 1;
            int ans[] = {-1, -1};

            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    ans[0] = mid;
                    //继续往左边找
                    high = mid-1;
                }
            }

            int low_right = 0;
            int high_right = nums.length - 1;
            while (low_right <= high_right) {
                int mid = (low_right + high_right) / 2;
                if (nums[mid] < target) {
                    low_right = mid + 1;
                } else if (nums[mid] > target) {
                    high_right = mid - 1;
                } else {
                    ans[1] = mid;
                    //继续往右边找
                    low_right = mid+1;
                }
            }
            System.out.println(ans[0]+" "+ans[1]);

        }


    }

    public static Numberss unique(int value) {

        for (int i = 0; i < numbers.size(); i++) {
            Numberss numberss = numbers.get(i);
            if (value == numberss.getValue()) {
                return numberss;
            }
        }
        return null;
    }

}
