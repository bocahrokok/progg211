
package graphpraktikum;

public class GraphPraktikum {

    public static void main(String[] args) {
        Graph g = new Graph(5);
        
        g.addVertex("JOG");
        g.addVertex("SUB");
        g.addVertex("CGK");
        g.addVertex("MKS");
        g.addVertex("BAC");
        
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 4, 7);
        g.addEdge(1, 2, 3);

        
        g.bfs(4);
        
        g.dijikstra( 0);
        
    }
    
}
