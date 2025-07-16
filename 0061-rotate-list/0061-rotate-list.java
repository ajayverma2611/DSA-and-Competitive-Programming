/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }

        tail.next=head;
        k=k%len;
        k=len-k;

        ListNode temp=head;
        while(k>1){
            temp=temp.next;
            k--;
        }
        
        head=temp.next;
        temp.next=null;

        return head;
    }
}