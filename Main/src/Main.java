import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    }


    static String solution(String[] input) {


        int n=input.length;
        int[][] map1=new int[n][];
        int[][] map2=new int[n][];
        String[] split;
        for(int i=0;i<n;i++){
            split = input[i].split("\\s+");
            int splitlen=split.length;
            map1[i]=new int[splitlen];
            map2[i]=new int[splitlen];
            for(int j=0;j<splitlen;j++){
                map1[i][j]=Integer.valueOf(split[j]);
            }
        }

        for(int i=0;i<n;i++){
            int map2index=0;
            int lastindex=-1;
            int length = map1[i].length;
            for(int j=0;j<length;j++){
                if(map1[i][j]!=0) {
                    if (lastindex != -1) {
                        if (map1[i][lastindex] == map1[i][j]) {
                            map2[i][map2index++] = map1[i][lastindex] + map1[i][j];
                            lastindex = -1;
                            continue;
                        } else{
                            map2[i][map2index++]=map1[i][lastindex];
                        }
                    }
                    lastindex = j;
                }
            }
            if(lastindex!=-1){
                map2[i][map2index]=map1[i][lastindex];
            }
        }


        String out="";
        for(int i=0;i<n;i++){
            int length = map2[i].length;
            for(int j=0;j<length;j++){
                if(j!=n-1)
                    out+=map2[i][j]+"";
                else
                    out+=map2[i][j]+"\n";
            }
        }
        return out;
    }

}
