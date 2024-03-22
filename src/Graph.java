import java.util.*;
import java.io.*;
import java.util.Stack;

public class Graph {
    int V;

    ArrayList<ArrayList<Integer>> adj;

    public Graph(int v){
        V=v;
        adj = new ArrayList<>(V);
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int v,int w){adj.get(v).add(w);}

    public void topologicalSortUtil(int V, boolean[]visited, Stack<Integer>stack){
        visited[V]=true;
        int i;

        Iterator<Integer> it = adj.get(V).iterator();

        while(it.hasNext()){
            i = it.next();
            if (!visited[i]){
                topologicalSortUtil(i,visited,stack);
            }
        }

        stack.add(V);
    }

    public void topologicalSort(){
        Stack<Integer>stack=new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i=0;i<V;i++){
            if (visited[i]==false)
                topologicalSortUtil(i,visited,stack);
        }

        while (stack.empty()==false){
            System.out.println(stack.pop() + " ");
        }

    }

}
