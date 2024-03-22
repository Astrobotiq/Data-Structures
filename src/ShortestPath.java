public class ShortestPath {
    int V;
    int[][] matrix;

    public ShortestPath(int v){
        V = v;
        matrix = new int[V][V];
    }

    public void addEdge(int x,int y, int edge){
        matrix[x][y]=edge;
    }

    public void shortestPath(int vertex){
        double[] distance = new double[V];

        for (int i = 0; i<distance.length;i++){
            distance[i] = Double.POSITIVE_INFINITY;
        }

        distance[vertex] = 0;




    }
}
