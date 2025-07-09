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

    public ListNode findKthN(ListNode temp,int k){
    
        for(int i=1;i<k && temp!=null;i++){
            temp=temp.next;
        }

        return temp;
    }

    public ListNode reverse(ListNode head){
        if(head==null|| head.next==null){
            return head;
        }

        ListNode newNode=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;

        return newNode;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp=head;
        ListNode prevNode=null;
        while(temp!=null){
            ListNode KthNode=findKthN(temp,k);
            if(KthNode == null){
              if(prevNode != null) prevNode.next=temp;
               break;
            }
            ListNode nextNode=KthNode.next;
            KthNode.next=null;

            reverse(temp);

            if(temp == head){
                head=KthNode;
            }else{
                prevNode.next=KthNode;
            }

            prevNode=temp;
            temp=nextNode;
        }

        return head;
    }
}