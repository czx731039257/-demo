import java.util.EmptyStackException;
import java.util.Stack;

public class StackToQueue {
    private Stack<Integer> s1,s2;

    public StackToQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void add(int i){
        s1.push(i);
    }

    public int poll(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        Integer pop = s2.pop();
        return pop;
    }

    public static void main(String[] args) {
        StackToQueue queue=new StackToQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.poll();
        int poll = queue.poll();
        System.out.println(poll);
    }
}
