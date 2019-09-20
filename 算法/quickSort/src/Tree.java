public class Tree {

    Node head;

}
class Node{
    int value;
    Node[] next;

    public Node(int value, Node[] next) {
        this.value = value;
        this.next = next;
    }

    public Node() {
    }
}
