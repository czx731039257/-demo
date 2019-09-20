import java.util.Scanner;

public class Select {
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
        for(int i=0;i<len;i++){
            int minindex=i;
            for(int j=i+1;j<len;j++){
                if(arrays[j]<arrays[minindex]){
                    minindex=j;
                }
            }
            if(minindex!=i){
                int temp=arrays[i];
                arrays[i]=arrays[minindex];
                arrays[minindex]=temp;
            }
        }
    }

    public static void print(int len){
        for(int i=0;i<len;i++){
            System.out.println(arrays[i]);
        }
    }
}
