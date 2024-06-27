package MapCount;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target>nums[mid]){
                left = mid+1;
            }
            if(target<nums[mid]){
                right = mid-1;
            }
//            System.out.println(mid+" "+left+" " +right);
        }
//        System.out.println(left+" " +right);
        return left;

    }

    public int removeDuplicates(int[] nums) {
        // 快慢指针
        int slow = 0;
        for(int fast=0;fast<nums.length; fast++){
            if(nums[slow]!=nums[fast]){
                slow+=1;
                nums[slow]=nums[fast];
            }

        }
        return slow;
    }

    public int[] moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast=0;fast<nums.length; fast++){
            if(nums[fast]!=0){
                nums[slow] = nums[fast];
                slow+=1;
            }
        }

        while(slow<nums.length){
            nums[slow]=0;
            slow+=1;
        }

        return nums;
    }

    public String back(String s){
        if(!s.equals("#") && s.length()==1){
            return s;
        }
        int slow = 0;
        int fast = 1;
        char [] newStr = s.toCharArray();
        while(fast<newStr.length){
            if(newStr[fast]=='#'){
                fast+=1;
                if(fast<newStr.length){newStr[slow]=newStr[fast];}
            }
            else{
                slow+=1;
                fast+=1;
            }
        }
        if(newStr[slow]=='#'){
            slow-=1;
        }
        return String.valueOf(Arrays.copyOfRange(newStr, 0, slow));

    }
    public boolean backspaceCompare(String s, String t) {
        if(back(s).equals(back(t))){
            return true;
        }
        else{
            return false;
        }
    }

    public String reverseStr(String s, int k) {
        int temp = s.length()-2*k;
        char [] charStr = s.toCharArray();

        String res = new String(charStr);
        return res;

    }
}
public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = new int[]{0,1,0,3,12};
//        int [] ans = s.moveZeroes(nums);
//        System.out.println(s.back("a"));
//        System.out.println(s.back("a#"));
//        System.out.println(s.backspaceCompare("a","a#"));
//        s.reverseStr("abcdefg", 2);
        int [] arr ={1,2,3,4};
        String st = "fdhfsjhgfsjk";
        String[] k = {"fsf","asfsdf"};
        char [] d = {'k','l'};
        char [] charStr = st.toCharArray();
        System.out.println(arr);
        System.out.println(k);
        System.out.println(st);
        System.out.println(d);
        System.out.println(charStr);



    }
}
