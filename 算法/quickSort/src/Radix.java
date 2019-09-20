import java.util.Arrays;
import java.util.Scanner;

public class Radix {

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
       int[][] bucket=new int[10][0];
       int max=arrays[0];
       for(int i=0;i<len;i++){
           if(arrays[i]>max)
               max=arrays[i];
       }
       int numberLength=0;
       for(int i=max;i>0;i/=10){
           numberLength++;
       }


       for(int i=0;max/i>0;i*=10){
           for(int j=0;j<len;j++){
               int buckedIndex=(arrays[i]/i)%10;
               arrAppend(bucket[buckedIndex],arrays[i]);
           }
           arrays = swap(bucket, len);
       }
        return arrays;
    }

    public static void print(int len){
        for(int i=0;i<len;i++){
            System.out.println(arrays[i]);
        }
    }

    public static int[] arrAppend(int[] arr,int i){
        int[] ints = Arrays.copyOf(arr, arr.length + 1);
        ints[arr.length]=i;
        return ints;
    }

    public static int[] swap(int[][] bucket,int len){
        int index=0;
        int[] arrays=new int[len];
        for(int i=0;i<bucket.length;i++){
            for(int j=0;j<bucket.length;j++){
                arrays[index++]=bucket[i][j];
            }
        }
        return arrays;

    }
}
