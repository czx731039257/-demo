import java.util.Scanner;

public class Shell {

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

        for(int step=len/2;step>0;step/=2) {
            for(int i=0;i<step;i++){
                for(int j=i+step;j<len;j+=step){
                    int k=j-step;
                    for(;k>=0;k-=step){
                        if(arrays[k]<arrays[j])
                            break;
                    }
                    int temp=arrays[j];
                    for(int h=j;h>k+step;h-=step){
                        arrays[h]=arrays[h-step];
                    }
                    arrays[k+step]=temp;
                }
            }
//            System.out.println("----");
//            print(len);
//            System.out.println("-----");
        }
    }

    public static void print(int len){
        for(int i=0;i<len;i++){
            System.out.println(arrays[i]);
        }
    }
}
