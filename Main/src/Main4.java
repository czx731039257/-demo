import java.util.Scanner;

public class Main4 {
    static int outindex = 0;
    static Node[][] out = null;
    static Node[] temp = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] arr = new Node[n];
        out = new Node[n][2];
        temp = new Node[n];
        int in;
        for (int i = 0; i < n; i++) {
            in = sc.nextInt();
            arr[i] = new Node(in, i);
        }
        sort(arr, 0, n - 1);


    }

    public static void sort(Node[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (right + left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    public static void merge(Node[] arr, int left, int mid, int right) {
        int i = left;
        int tempindex = i;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[j].val < arr[i].val) {
                for (int k = i; k <= mid; k++) {
                    out[outindex][0] = arr[j];
                    out[outindex++][1] = arr[k];
                }
                temp[tempindex++] = arr[j++];
            } else {
                temp[tempindex++] = arr[i++];
            }
        }

        while (i <= mid) {
            temp[tempindex++] = arr[i++];
        }
        while (j <= right) {
            temp[tempindex++] = arr[j++];
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp[k];
        }
    }
}

class Node {
    int val;
    int index;

    public Node(int val, int index) {
        this.val = val;
        this.index = index;
    }
}