import java.util.Scanner;
import java.util.Stack;

public class Calculate {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char[] operation=str.toCharArray();//中缀表达式
        int len=operation.length;

        Stack<Character> stack1=new Stack<>();//数字栈
        Stack<Character> stack2=new Stack<>();//操作符栈

        for(int i=0;i<len;i++){
            if(operation[i]>='0'&&operation[i]<='9'){
                stack1.push(operation[i]);
            }else if(operation[i]=='+'||operation[i]=='-'){
                if(stack2.empty()||stack2.peek()=='('){//碰到栈为空或者栈顶元素为（时 入栈
                    stack2.push(operation[i]);
                }else{
                    Character temp=stack2.pop();
                    stack1.push(temp);
                }
            }else if(operation[i]=='*'||operation[i]=='/'){
                if(stack2.empty()){
                  stack2.push(operation[i]);
                } else if(stack2.peek()=='*'||stack2.peek()=='/'){
                    Character temp=stack2.pop();
                    stack1.push(temp);
                }else{
                    stack2.push(operation[i]);
                }
            }else if(operation[i]=='('||operation[i]==')'){
                if(operation[i]=='('){
                    stack2.push(operation[i]);
                }else if(operation[i]==')'){
                    Character temp=stack2.pop();
                    while(temp!='('){
                        stack1.push(temp);
                        temp=stack2.pop();
                    }
                }
            }
        }
        while(!stack2.empty()){
            Character temp2=stack2.pop();
            stack1.push(temp2);
        }
        int len2=0;
        while(!stack1.empty()){
            Character pop = stack1.pop();
            operation[len2++]=pop;
        }
//        for(int i=0;i<len2;i++){
//            System.out.println(operation[i]);
//        }

        Stack<Integer> stack3=new Stack<>();
        for(int i=len2-1;i>=0;i--){
            if(operation[i]>='0'&&operation[i]<='9'){
                String s="";
                s+=operation[i];
                stack3.push(Integer.valueOf(s));
            }else{
                int b=stack3.pop();
                int a=stack3.pop();
                if(operation[i]=='+')
                    stack3.push(a+b);
                else if(operation[i]=='-')
                    stack3.push(a-b);
                else if(operation[i]=='*')
                    stack3.push(a*b);
                else
                    stack3.push((int)a/b);
            }
        }

        System.out.println("结果为："+stack3.pop());


    }


//    public static int getResult(Stack<Character> stack1,Stack<Character> stack2){
//        if(!stack1.empty()){
//            Character pop = stack1.pop();
//            if(pop>='0'&&pop<='9'){//操作数
//                return Integer.valueOf(pop);
//            }else{//操作符
//
//            }
//        }
//
//        return
//    }
}
