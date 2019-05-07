/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxheap;

/**
 *
 * @author nurrizkyimani
 */

public class MaxHeap1 {
    private int[] Heap;
    private int size;
    private int maxsize;
    
    //constructor to initialize
    //empy amx heap with given maximum
    //capacity
public MaxHeap(int maxsize)
{
    this.maxsize = maxsize;
    this.size = 0;
    Heap = new int[this.maxsize + 1];
    Heap[0] = Integer.MAX_VALUE;
    
}

//Returns position of parent

private int parent(int pos)
{
    return pos/2;
}
    
//Below two functions return left
//right children
private int leftChild(int pos)
{
    return(2*pos) + 1;
    
}
private int rightChild(int pos)
{
    return(2*pos) + 1;
}

//Returns true of given node is leaf

private boolean ifLeaf(int pos)
{
    if (pos>= (size/2) && pos<= size){
        return true;
    }
    return false;
    
}

private void swap(int fpos, int spos)
{
    int tmp;
    tmp= Heap[fpos];
    Heap[fpos] = Heap[spos];
    Heap[spos] = tmp;
    
}

//A recursive function to amx heapify the given
//subtree. This function . assumes that the left and 
//right subtress are already heapfied, we only need
//to fix the root











}
