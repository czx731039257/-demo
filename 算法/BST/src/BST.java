import javax.management.Query;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BST {
    int a;

    public BST(int a) {
        this.a = a;
    }
    //    public static void main(String[] args) {
//        Node insert = insert(null, 6);
//        insert = insert(insert, 3);
//        insert = insert(insert, 1);
//        insert = insert(insert, 5);
//        insert = insert(insert, 2);
//        insert = insert(insert, 4);
//        insert = insert(insert, 8);
//        insert = insert(insert, 7);
//        insert = insert(insert, 9);
//        insert = insert(insert, 10);
//        postorder(insert);
//
//    }

    public static void main(String[] args) {

    }


    /**
     * 二叉搜索树的插入操作
     * @param value
     * @return
     */
    public static Node insert(Node head,int value){
        if(head==null){
            head=new Node();
            head.value=value;
            return head;
        }
        Node node=head;
        while(node!=null){
            if(value==node.value){
                break;
            }else if(value>node.value){
                if(node.right==null){
                    Node i=new Node();
                    i.value=value;
                    node.right=i;
                    System.out.println("在节点"+node.value+"右侧插入节点"+value);
                    break;
                }
                node=node.right;
            }else{
                if(node.left==null){
                    Node i=new Node();
                    i.value=value;
                    node.left=i;
                    System.out.println("在节点"+node.value+"左侧插入节点"+value);
                    break;
                }

                node=node.left;
            }
        }
        return head;
    }


    /**
     * 中序遍历
     * @param node
     */
    public static void midorder(Node node){
        if(node==null){
            return;
        }
        midorder(node.left);
        System.out.println(node.value);
        midorder(node.right);
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * 后续遍历
     * @param node
     */
    public static void postorder(Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }


//    public static void preAndMidToPost(int[] pre,int[] mid){
//        if(pre.length==1){
//            System.out.println(pre[0]);
//            return;
//        }
//        int r=pre[0];
//        int i=0;
//        for(i=0;i<mid.length;i++){
//            if(mid[i]==r){
//                break;
//            }
//        }
//        preAndMidToPost();
//    }

}

class Node{
    int value;
    Node right;
    Node left;
}
