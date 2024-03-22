import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NodeofGraph {
        int data;
        boolean visited;
        List<NodeofGraph> neighbours;

        public NodeofGraph(int data){
            this.data=data;
            this.neighbours = new ArrayList<>();
        }

        public void addneighbours(NodeofGraph node){
            neighbours.add(node);
        }

        public List<NodeofGraph> getNeighbours(){
            return neighbours;
        }

        public void setNeighbours(List<NodeofGraph> neighbours){
            this.neighbours = neighbours;
        }

        public String toString(){
            return ""+data;
        }


}
