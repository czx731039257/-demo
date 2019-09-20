import java.util.Scanner;

public class DFS {
    public static int[][] map=null;
    public static int[][] hasfindmap=null;
    public static int[][] direction={{-1,0},{0,-1},{1,0},{0,1}};//方向数组
    public static Coord target;//终点
    public static Coord start;//起点
    public static int rows,cols;

    public static void main(String[] args) {
        int m,n,sx,sy,tx,ty;
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入行数：");
        rows=scanner.nextInt();
        System.out.print("请输入列数：");
        cols=scanner.nextInt();

        System.out.print("请输入地图（0为道路 1为墙）：");
        map=new int[rows][cols];
        hasfindmap=new int[rows][cols];
        for(int i=0;i<rows;i++){//输入
            for(int j=0;j<cols;j++){
                map[i][j]=scanner.nextInt();
            }
        }

        System.out.print("请输入起点：");
        sx=scanner.nextInt();sy=scanner.nextInt();
        start=new Coord(sx,sy);
        System.out.print("请输入终点：");
        tx=scanner.nextInt();ty=scanner.nextInt();
        target=new Coord(tx,ty);
        find(start);


    }


    public static void find(Coord coord){
        if(coord.equals(target)){

        }
        if(hasfindmap[coord.y][coord.x]==1){
            return;
        }
        else {
            for (int i = 0; i < 4; i++) {
                int x = coord.x + direction[0][0];
                int y = coord.y + direction[0][1];
                if ((y >= 0 && y < rows) && (x >= 0 && x < cols)) {
                    Coord next = new Coord(x, y);
                    next.parent = coord;
                    find(next);
                }
            }
        }



    }


}
class Coord{
    public int x;
    public int y;
    public Coord parent;
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Coord i=(Coord)obj;
        if(i.x==x&&i.y==y){
            return true;
        }
        return false;
    }
}