import java.util.Scanner;

public class Bubble {
    public static int[] arrays=new int[10];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数据个数：");
        int n=sc.nextInt();
        System.out.println("请输入排序数据：");
        for(int i=0;i<n;i++){
            arrays[i]=sc.nextInt();
        }
        sort(n);
        print(n);

    }


    public static void sort(int len){
        for(int i=len-1;i>0;i--){
            for(int j=1;j<=i;j++){
                if(arrays[j]<arrays[j-1]){
                    int temp=arrays[j];
                    arrays[j]=arrays[j-1];
                    arrays[j-1]=temp;
                }
            }
        }
    }

    public static void print(int len){
        for(int i=0;i<len;i++){
            System.out.println(arrays[i]);
        }
    }
}
