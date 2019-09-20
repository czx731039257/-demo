import java.util.Scanner;


/**
 * 二叉树的中序前序转后序
 *        中序后序转前序
 */
public class PreMidPost {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] mid=new int[100];
        int[] post=new int[100];
        int len=sc.nextInt();
        for(int i=0;i<len;i++){
            mid[i]=sc.nextInt();
        }
        for(int i=0;i<len;i++){
            post[i]=sc.nextInt();
        }
        Node root=MidAndPost(mid,0,len-1,post,0,len-1);
        preprint(root);
    }

    public static Node MidAndPre(int[] mid,int startMid,int endMid,int[] pre,int startPre,int endPre){
        if(startMid>endMid||startPre>endPre)
            return null;
        Node node=new Node();
        node.value=pre[startPre];
        int root=pre[startPre];
        int i=startMid;
        for(;i<endMid;i++){
            if(mid[i]==root){
                break;
            }
        }
        node.left=MidAndPre(mid,startMid,i-1,pre,startPre+1,startPre+i-startMid);
        node.right=MidAndPre(mid,i+1,endMid,pre,endPre-(endMid-i)+1,endPre);
        return node;
    }

    public static Node MidAndPost(int[] mid,int startMid,int endMid,int[] post,int startPost,int endPost){

        if(startMid>endMid||startPost>endPost)
            return null;
        Node node=new Node();
        node.value=post[endPost];
        int root=post[endPost];
        int i=startMid;
        for(;i<endMid;i++){
            if(mid[i]==root){
                break;
            }
        }
        node.left=MidAndPost(mid,startMid,i-1,post,startPost,startPost+i-startMid-1);
        node.right=MidAndPost(mid,i+1,endMid,post,startPost+i-startMid,endPost-1);
        return node;
    }



    public static void postprint(Node node){
        if(node==null){
            return;
        }

        postprint(node.left);
        postprint(node.right);
        System.out.print(node.value+" ");
    }
    public static void preprint(Node node){
        if(node==null){
            return;
        }

        System.out.print(node.value+" ");
        preprint(node.left);
        preprint(node.right);

    }
}
