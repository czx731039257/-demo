import java.util.*;

public class BFS {

    private Map<String,String[]> map=null;

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.add("A",new String[]{"B","C"});
        bfs.add("B",new String[]{"E"});
        bfs.add("C",new String[]{"D","F"});
        bfs.add("D",new String[]{"E"});
        bfs.add("E",new String[]{"H"});
        bfs.add("F",new String[]{"G"});
        bfs.add("G",new String[]{"H"});
        bfs.add("H",new String[]{});
        Node target = bfs.findTarget("A", "H");
        bfs.printPath(target);
    }

    public BFS(){
        map=new HashMap<>();
    }

    public void add(String name,String[] children){
        map.put(name,children);
    }


    public Node findTarget(String start,String target){
        List<Node> hasfindNode=new ArrayList<>();
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(new Node(start));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.getId().equals(target)){
                return node;
            }
            if(hasfindNode.contains(node)){
                continue;
            } else{
                String[] strings = map.get(node.getId());
                for(String i:strings){
                    queue.add(new Node(i,node,null));
                }
                hasfindNode.add(node);
            }
        }
        return null;
    }

    public void printPath(Node node){
        List<Node> path=new ArrayList<>();
        while(node.getParent()!=null){
            path.add(node);
            node=node.getParent();
        }
        path.add(node);

        for(int i=path.size()-1;i>=0;i--){
            System.out.println(path.get(i).getId());
        }
    }


    class Node{
        private String id;
        private Node parent;
        private List<Node> children;

        public Node(String id) {
            this.id = id;
        }

        public Node(String id, Node parent, List<Node> children) {
            this.id = id;
            this.parent = parent;
            this.children = children;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }
}
