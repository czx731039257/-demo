import java.util.Scanner;

public class RotateArrays {

    /**
     * 求旋转数组的最小值(2分查找)
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[100];
        int len=sc.nextInt();
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        int min = getMin(arr,len);
        System.out.println(min);
    }

    public static int getMin(int[] arr,int len){
        int start=0;
        int end=len-1;
        while(start!=end){
            int mid=arr[(end+start)/2];
            if(mid>arr[start]){
                start=(end+start)/2;
            }else if(mid<arr[start]){
                end=(end+start)/2;
            }else{
                start++;
            }

        }
        return arr[start];
    }
}
