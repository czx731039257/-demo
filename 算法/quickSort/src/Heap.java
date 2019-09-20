import java.util.Scanner;

public class Heap {

    public static int[] arrays=new int[10];

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数据个数：");
        int n=sc.nextInt();
        System.out.println("请输入排序数据：");
        for(int i=0;i<n;i++){
            arrays[i]=sc.nextInt();
        }
        buildMaxHeap(n);//建堆
        //sort(n);
//        for(int i=0;i<n;i++){
//            System.out.println(arrays[i]);
//        }

        sort(n);
        for(int i=0;i<n;i++){
            System.out.println(arrays[i]);
        }


    }


    /**
     * 建大顶堆
     * @param
     */
    public static void buildMaxHeap(int len){
        for(int i=(int)(len/2);i>=0;i--){
            heapify(i,len);
        }
    }

    public static void heapify(int i,int len){
        int max=i;
        int left=i*2+1;//i节点的左儿子的值
        int right=i*2+2;//i节点的右儿子的值
        if(right<len&&arrays[right]>arrays[max]){
            max=right;
        }
        if(left<len&&arrays[left]>arrays[max]){
            max=left;
        }
        if(max!=i){
            swap(i,max);
            heapify(max,len);
        }
    }

    /**
     * 交换操作
     * @param i
     * @param j
     */
    public static void swap(int i,int j){
        //System.out.println("交换"+i+"和"+j);
        int temp=arrays[i];
        arrays[i]=arrays[j];
        arrays[j]=temp;
    }

    /**
     * 堆建完后的排序算法
     */
    public static void sort(int len){
        while(len!=1) {
            //System.out.println("-----------");
            swap(0, len-1);
            len--;
            heapify(0, len);
        }
    }


}