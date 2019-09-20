import java.util.Scanner;

public class Insert {

    public static int[] arrays=new int[10];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数据个数：");
        int n=sc.nextInt();
        System.out.println("请输入排序数据：");
        for(int i=0;i<n;i++){
            arrays[i]=sc.nextInt();
        }
        sort(arrays,n);
        print(n);

    }

    public static int[] sort(int[] arrays,int len){
        for(int i=1;i<len;i++){
            int j=i-1;//逆序遍历数组
            for(;j>=0;j--){
                if(arrays[j]<arrays[i])
                    break;
            }
            int temp=arrays[i];
            for(int k=i-1;k>j;k--){
                arrays[k+1]=arrays[k];
            }
            arrays[j+1]=temp;
        }
        return arrays;
    }

    public static void print(int len){
        for(int i=0;i<len;i++){
            System.out.println(arrays[i]);
        }
    }
}
