/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpraktikum;

/**
 *
 * @author nurrizkyimani
 */
public class Graphpraktikum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Graph g = new Graph(7);
        
        
        g.addVertex("JOG");
        g.addVertex("CGK");
        g.addVertex("SUB");
        g.addVertex("BAC");
        g.addVertex("MKS");
        g.addVertex("PON");
        g.addVertex("KUT");
        
        
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        
        g.bfs(0);
        
    }
    
}
