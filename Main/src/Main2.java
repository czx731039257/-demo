import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        int[] arr={6,7,2,4,1,3};
        System.out.println(solution(arr));
    }

    static int solution(int[] arr) {
        int len=arr.length;
        int[] arr2 = Arrays.copyOf(arr, len);
        int sum1=0;
        for(int i=len-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    sum1++;
                }
            }
        }

        int sum2=0;
        for(int i=len-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr2[j]<arr2[j+1]){
                    int temp=arr2[j];
                    arr2[j]=arr2[j+1];
                    arr2[j+1]=temp;
                    sum2++;
                }
            }
        }
        if(sum1>sum2){
            return sum2;
        }else {
            return sum1;
        }
    }
}
