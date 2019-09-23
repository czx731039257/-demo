import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] arr=new int[100000];
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
            }
            int sum=0;
            int len=0;
            int max=0;
            for(int j=0;j<n;j++){
                if(arr[j]>=sum){
                    sum+=arr[j];
                    len++;
                }else{
                    if(len>max){
                        max=len;
                    }
                    len=1;
                    sum=arr[j];
                }
            }
            if(len>max){
                max=len;
            }
            System.out.println(max);
        }
    }
}
