package com.itheima;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}
class Solution{
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(true){
            ListNode start = prev.next;
            ListNode end = prev;
            for (int i = 0; i < k&& end!=null; ++i) {
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode nextGroup = end.next;
            end.next = null;
            prev.next = reverse(start);
            start.next = nextGroup;
            prev = start;

        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
public class Main{
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode newHead = solution.reverseKGroup(head,2);
        printList(newHead); // 输出：2 1 4 3 5
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}

