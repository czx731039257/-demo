import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueToStack {

    private Queue<Integer> queue;

    public QueueToStack() {
        queue = new LinkedList<>();
    }

    public void push(int i) {
        queue.add(i);
    }

    public int pop() throws EmptyStackException{

        if(queue.size()==0){
            throw new EmptyStackException();
        }else{
        Queue<Integer> temp=new LinkedList<>();
        while (queue.size() != 1) {
            temp.add(queue.poll());
        }
        int out=queue.poll();
        queue=temp;
        return out;
        }
    }

    public static void main(String[] args) {
        QueueToStack stack=new QueueToStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int pop = stack.pop();
        System.out.println(pop);

    }

}
