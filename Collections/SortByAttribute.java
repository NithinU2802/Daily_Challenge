import java.util.*;

class Node implements Comparable<Node> {
    private String a;
    private int b;
    private int c;

    public Node(String a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    public int getC(){
        return c;
    }
    
    @Override
    public int compareTo(Node otherNode) {
        return Integer.compare(this.c, otherNode.c);
    }
}

public class SortByAttribute {
    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node("A", 5, 3));
        nodeList.add(new Node("B", 8, 1));
        nodeList.add(new Node("C", 2, 7));
        Collections.sort(nodeList);

        for (Node node : nodeList) {
            System.out.println(node.getC());
        }
    }
}
