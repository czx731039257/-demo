import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] out=new int[t];
        for(int i=0;i<t;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int p=sc.nextInt();
            int q=sc.nextInt();
            int count=0;
            while(b-a>p){
                p=p*q;
                count++;
            }
            count++;
            out[i]=count;
            if(a>=b){
                out[i]=0;
            }
        }

        for(int i=0;i<t;i++){
            System.out.println(out[i]);
        }

    }
}
