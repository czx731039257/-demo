public class Main {


    public static void main(String[] args) {
        Main5 main5 = new Main5();
        Main6 main6 = (Main6) new Main4().bind(main5);
        main6.println();

    }

    public static Node buildLink(int[] arr) {
        int len = arr.length;
        Node head = new Node(arr[0], null);
        Node p = head;
        for (int i = 1; i < len; i++) {
            Node q = new Node(arr[i], null);
            p.next = q;
            p = q;
        }
        return head;
    }

    public static void print(Node head) {
        Node p = head;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

    public static Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node reverseHead = null;
        Node currentNode = head;
        Node preNode = null;
        while (currentNode != null) {
            if (currentNode.next == null) {
                reverseHead = currentNode;
            }
            Node nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return reverseHead;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

