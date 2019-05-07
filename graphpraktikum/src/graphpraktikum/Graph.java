/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpraktikum;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author nurrizkyimani
 */
public class Graph {
    
    private final vertex  V[];
    private int vMax; 
    private int[][]  adjMat;
    private int nV; //counter vertext    
    private Queue<Integer> q = new LinkedList<>();
    private Stack<Integer> s = new Stack<>();
    
    Graph(int vMax){
        this.vMax = vMax;
        nV = 0;
        V = new vertex[vMax];
        adjMat = new int[vMax][vMax];
    }
    public void addVertex(String label1){
        V[nV] = new vertex(label1);
        nV++;
        
    }
    
    public void addEdge(int s, int d){
        adjMat[s][d] = 1;
        adjMat[d][s] = 1;
    }
    
    public int unVisitedAdjVet(int v){
        for(int i=0;i<nV;i++){
            if(adjMat[v][i] == 1 && !V[i].isVisited) //label in vertex;
                return i;
        }
        return -1;
    }
    
    public void bfs(int start){
        q.add(start);
        V[start].isVisited = true; //from vertex
        System.out.println(V[start].label + " "); //label in vertex
        
        while(!q.isEmpty()){
            int vet = unVisitedAdjVet(q.peek());
            
            if(vet==-1){
                q.remove();
                
            }
            else {
                V[vet].isVisited = true;
                System.out.println(V[vet].label + ""); //label in vertex
            }
        }
    }
    
}
