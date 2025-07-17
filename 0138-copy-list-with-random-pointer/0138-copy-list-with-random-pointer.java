/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // public Node copyRandomList(Node head) {
        
    //     Map<Node, Node> mp= new HashMap<>();
    //     Node temp=head;

    //     while(temp!=null){
    //         Node newNode = new Node(temp.val);
    //         mp.put(temp,newNode);
    //         temp=temp.next;
    //     }

    //     temp=head;
    //     while(temp != null){
    //         Node curr = mp.get(temp);
    //         curr.next=mp.get(temp.next);
    //         curr.random= mp.get(temp.random);

    //         temp=temp.next;
    //     }


    //     return mp.get(head);
        
    // }


    public Node copyRandomList(Node head) {

        Node temp = head;
        while(temp!=null){
            Node nn= new Node(temp.val);
            nn.next=temp.next;
            temp.next=nn;

            temp=temp.next.next;
        }


        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random=temp.random.next;
            }else{
                temp.next.random = null;
            }

            temp=temp.next.next;
        }


        temp=head;
        Node dummy = new Node(-1);
        Node res=dummy;

        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;

            res=res.next;
            temp=temp.next;
        }
        

        return dummy.next;
    }
}