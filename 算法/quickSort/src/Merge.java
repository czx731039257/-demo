import java.util.Scanner;

/**
 * 归并排序
 */
public class Merge {
    public static int[] arrays=new int[10];
    public static int[] temp=new int[10];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数组个数：");
        int n = sc.nextInt();
        System.out.println("请输入数据：");
        for(int i=0;i<n;i++){
            arrays[i]=sc.nextInt();
        }
        sort(0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arrays[i]+" ");
        }
    }

    public static void sort(int left ,int right){
        if(left==right)
            return;
        int mid=(left+right)/2;
        sort(left,mid);
        sort(mid+1,right);
        merge(left,mid,right);
    }

    public static void merge(int left,int mid ,int right){
        int i=left,j=mid+1;
        int k=left;
        while(i<=mid&&j<=right){
           if(arrays[i]>arrays[j]){
               temp[k++]=arrays[j++];
           }else{
               temp[k++]=arrays[i++];
           }
        }
        while(i<=mid){
            temp[k++]=arrays[i++];
        }
        while(j<=right){
            temp[k++]=arrays[j++];
        }
        for(i=left;i<=right;i++){
            arrays[i]=temp[i];
        }
    }
}
