import java.util.Scanner;

public class Fib {

    public static void main(String[] args) {
        int[] arr=new int[100];
        System.out.println("请输入n：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr[0]=0;
        arr[1]=1;
        for(int i=0;i<n;i++){
            if(i>1){
                arr[i]=arr[i-1]+arr[i-2];
            }
        }
        System.out.println(arr[n-1]);
    }
}
