public class Quick {

    public static int[] arrays=new int[5];

    public static void main(String[] args) {

        arrays[0]=3;
        arrays[1]=2;
        arrays[2]=5;
        arrays[3]=1;
        arrays[4]=4;
        quickSort(0,4);
        for(int i:arrays)
            System.out.println(i);
    }

    /**
     * 32514
     * 12534
     * 12354
     *
     * 快速排序
     */
    public static void quickSort(int left,int right) {
        if(left==right)
            return;
        int i=left,j=right;
        int direction=1;
        while(i!=j){
            if(direction==0){
                for (;i<j;i++){
                    if(arrays[i]>arrays[j]){
                        int temp =arrays[i];
                        arrays[i]=arrays[j];
                        arrays[j]=temp;
                        direction=1;
                        break;
                    }
                }
            }else{
                for (;i<j;j--){
                    if(arrays[i]>arrays[j]){
                        int temp =arrays[i];
                        arrays[i]=arrays[j];
                        arrays[j]=temp;
                        direction=0;
                        break;
                    }
                }
            }
        }
        //for(int x:arrays)
           // System.out.println();
        if(j-1>=left)
        quickSort(left,j-1);
        if(j+1<=right)
        quickSort(j+1,right);
    }
}
