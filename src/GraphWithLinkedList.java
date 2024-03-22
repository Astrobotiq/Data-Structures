import java.util.List;
import java.util.Stack;

public class GraphWithLinkedList {
    Stack<NodeofGraph> stack;

    public GraphWithLinkedList(){
        stack = new Stack<>();
    }

    public void topologicalSort(NodeofGraph node)
    {
        List<NodeofGraph>neighbours = node.getNeighbours();

        for (int i =0;i< neighbours.size();i++){
            NodeofGraph Node = neighbours.get(i);
            if (Node!=null && Node.visited==false){
                topologicalSort(Node);
                Node.visited=true;
            }

        }
        stack.push(node);
    }

    public void print(){
        while (stack.empty()==false){
            System.out.println(stack.pop() + " ");
        }
    }
}
