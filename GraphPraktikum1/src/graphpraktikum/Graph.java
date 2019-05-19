
package graphpraktikum;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private Vertex V[];
    private int vMax;
    private int[][] adjMat;
    public int nV;
    private Queue<Integer> q = new LinkedList<>();
    private Stack<Integer> s = new Stack<>();
    final static int INF = Integer.MAX_VALUE;
    
    Graph(int vMax){
        this.vMax = vMax;
        nV = 0;
        V = new Vertex[vMax+1];
        adjMat = new int[vMax+1][vMax+1];
        //addition
        for(int i=0; i<vMax;i++){
            for(int j=0; j<vMax; j++)
                adjMat[i][j] = 0;
        }
    }
    
    public void addVertex(String label){
        V[nV] = new Vertex(label);
        nV++;
    }
    
    public void addEdge(int s, int d, int w){
        adjMat[s][d] = w;
        adjMat[d][s] = w;
    }
    
    public int unVisitedAdjVet(int v){
        for(int i=0; i<nV; i++){
            if(adjMat[v][i] == 1 && !V[i].isVisited)
                return i;
        }
        
        return -1;
    }
    
    public void bfs(int start){
        q.add(start);
        V[start].isVisited = true;
        System.out.println(V[start].label+" ");
        
        while(!q.isEmpty()){
            int vet = unVisitedAdjVet(q.peek());
            
            if(vet == -1){
                q.remove();
            } else {
                V[vet].isVisited = true;
                System.out.println(V[vet].label + " ");
                q.add(vet);
            }
        }
    }
    
    public void dfs(int start){
        s.push(start);
        V[start].isVisited = true;
        System.out.println(V[start].label+" ");
        
        while(!s.isEmpty()){
            int vet = unVisitedAdjVet(s.peek());
            
            if(vet == -1){
                s.pop();
            } else {
                V[vet].isVisited = true;
                System.out.println(V[vet].label + " ");
                s.push(vet);
            }
        }
    }
    
    int minDistance(int dist[], Boolean sptSet[])
    {
            
        //intialize min value;
        int min = Integer.MAX_VALUE, min_index = -1;
        
        for(int v=0; v<vMax; v++){
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
            
        
        }
       return min_index;
    }
    void printSolution(int dist[], int n){
        
        System.out.println("Vertex Distance from Source");
        for(int i = 0; i < vMax; i++)
            System.out.println(i + " tt " + dist[i]);
            
    }
    
    void dijikstra(int src){
        int graph[][] = adjMat;
        int dist[] = new int[vMax];
        Boolean sptSet[] = new Boolean[vMax];
        for(int i = 0; i < vMax; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for(int count=0; count< vMax-1; count++){
            int u = minDistance(dist, sptSet);
            sptSet[u]= true;
            for(int v = 0; v< vMax; v++){
                if(!sptSet[v] && graph[u][v] !=0 &&
                        dist[u] != Integer.MAX_VALUE  &&
                        dist[u] + graph[u][v] <dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
            //printthe constructed distances array
            printSolution(dist, vMax);
               
        }
    }
    
}

