import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t;
        t=sc.nextInt();
        int[] arr=new int[t];
        for(int i=0;i<t;i++){
            arr[i]=sc.nextInt();
        }
        long[] out=new long[t];


        for(int i=0;i<t;i++){
            long sn=0;
            long sum=0;
            long d=1;
            while(arr[i]-sn>9){
                sum+=9*d;
                sn+=9;
                d*=10;
            }
            sum+=(arr[i]-sn)*d;
            out[i]=sum;
        }


        for(int i=0;i<t;i++){
            System.out.println(out[i]);
        }
    }

}
