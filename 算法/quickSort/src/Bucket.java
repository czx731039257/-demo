import java.util.Arrays;
import java.util.Scanner;

public class Bucket {

    public static int[] arrays=new int[10];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数据个数：");
        int n=sc.nextInt();
        System.out.println("请输入排序数据：");
        for(int i=0;i<n;i++){
            arrays[i]=sc.nextInt();
        }
        sort(n,11);
        print(n);

    }

    public static void sort(int len,int bucketSize){
        int max=arrays[0];
        int min=arrays[0];
        for(int i=0;i<len;i++){
            if(arrays[i]>max)
                max=arrays[i];
            if(arrays[i]<min)
                min=arrays[i];
        }

        int bucketCount=(max-min+1)/bucketSize;
        int[][] bucket=new int[bucketCount][0];
        for(int i=0;i<len;i++){
            int bucketIndex=(arrays[i]-min)/bucketSize;
            bucket[bucketIndex]=arrAppend(bucket[bucketIndex],arrays[i]);
        }

        int arrIndex=0;
        for(int i=0;i<bucketCount;i++){
            if(bucket[i].length==0)
                continue;
            else{
                int[] sort = Insert.sort(bucket[i], bucket[i].length);
                bucket[i]=sort;
                for(int j=0;j<bucket[i].length;j++){
                    arrays[arrIndex++]=bucket[i][j];
                }
            }
        }
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
}
