
public class reservelink {


    public static void main(String[] args) {

        Node head=initlink();
        //print(head);
        Node reserve = reserve(head);
        print(reserve);

    }

    public static Node reserve(Node head){
        Node node = head;
        Node p=null,temp;
        while(node.next!=null){
            temp=node.next;
            node.next=p;
            p=node;
            node=temp;
        }
        return p;
    }

    public static void print(Node head){
        Node next=head;
        while(next!=null){
            System.out.println(next.value);
            next=next.next;
        }
    }

    public static Node initlink(){
        Node head=new Node();
        head.value=0;
        head.next=null;
        Node next=head,temp;
        for(int i=1;i<=5;i++){
            temp=new Node();
            temp.value=i;
            temp.next=null;
            next.next=temp;
            next=temp;
        }
        return head;
    }
}


class Node{
    int value;
    Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}