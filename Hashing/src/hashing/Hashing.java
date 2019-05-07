package hashing;

import java.util.Random;

/**
 *
 * @author Kresna
 */
public class Hashing {

 
    public static int[] ArrayData;
    int arraySize;
    int itemsInArray = 0;

    Hashing(int size) {
        arraySize = size;
        ArrayData = new int[size]; //set nilai awal array "-1" sbg
        for (int i = 0; i < size; i++) {   // tanda array masih kosong
            ArrayData[i] = -1;
        }
    }

    public int modMethod(int hashvalue, int sizehash, int[] Arr) {
        int index = hashvalue % sizehash;
        return index;
    }

    public boolean apaArrayPenuh(int[] array) {
        boolean dec = true;
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == -1) {
                dec = false;
                break;
            }
        }
        return dec;
    }

    public void insert(int key, int[] Array) {
        int indexArr = modMethod(key, arraySize, ArrayData);
        if (apaArrayPenuh(Array) == true) {
            System.out.println("Array penuh!");
        } else {
            while (ArrayData[indexArr] != -1) { //menggunakan linear probing
                indexArr += 1;
                if (indexArr == arraySize) {
                    indexArr = 0;
                }
            }
            ArrayData[indexArr] = key;
        }
    }

    public void insert2(int key, int[] Array) {
        int indexArr = modMethod(key, arraySize, ArrayData);
        int i = 1;
        if (apaArrayPenuh(Array) == true) {
            System.out.println("Array penuh!");
        } else {
            while (ArrayData[indexArr] != -1) { //menggunakan quadratic probing
                indexArr += i * i;
                if (indexArr == arraySize) {
                    indexArr = 0;
                } else if (indexArr >= arraySize) {
                    indexArr %= arraySize;
                }
                i++;
            }
            ArrayData[indexArr] = key;
        }
    }

    public void insert3(int key, int[] Array) { //Double hashing
        int index1 = modMethod(key, arraySize, ArrayData); //index fungsi hash 1
        int index2 = (key + (key % 10)) % arraySize; //index fungsi hash 2
        if (apaArrayPenuh(Array) == true) {
            System.out.println("Array penuh!");
        } else {
            int indexNext = index1;
            while (ArrayData[indexNext] != -1) {
                int i = 1;
                indexNext = index1 + (i * index2);
                if (indexNext == arraySize) {
                    indexNext = 0;
                } else if (indexNext >= arraySize) {
                    indexNext %= arraySize;
                }
                i++;
            }
            ArrayData[indexNext] = key;
        }
    }
    
    public int cluster(){
        int clusterNum = 0;
        
        if (ArrayData[0] != -1 ){
            clusterNum++;
        }
        else clusterNum += 0;
        
        for(int i=1; i< arraySize; i++){
          if (ArrayData[i] == -1  && ArrayData[(i+1)%arraySize] > -1){
              clusterNum++;
          }
        
        }
        return clusterNum; 
    };
    //finding Average clusterSize from loadFactor;
    public float loadFactor(double loadFactors){
        float sum = 0;
        double times = arraySize*loadFactors;
        
        for(int j=0; j<6; j++){
            for (int i=0; i<times; i++){
                Random rand = new Random();
                int n = rand.nextInt(1000);
                insert(n, ArrayData);
            }
            
            sum = sum+cluster();
            for(int i=0; i< arraySize;i++){
                ArrayData[i] = -1;
            }
        
        }
        return sum/6;
    }
    

    
    public static void main(String[] args) {
 
        Hashing theFunc = new Hashing(60);
        
        System.out.println(theFunc.loadFactor(0.1) + ", Succes! 1");
        System.out.println(theFunc.loadFactor(0.2) + ", Succes! 2");
        System.out.println(theFunc.loadFactor(0.3) + ", Succes! 3");
        System.out.println(theFunc.loadFactor(0.4) + ", Succes! 4");
        System.out.println(theFunc.loadFactor(0.5) + ", Succes! 5");
        System.out.println(theFunc.loadFactor(0.6) + ", Succes! 6" );
        System.out.println(theFunc.loadFactor(0.7) + ", Succes! 7");
        System.out.println(theFunc.loadFactor(0.8) + ", Succes! 8");
        System.out.println(theFunc.loadFactor(0.9) + ", Succes! 9");
        System.out.println(theFunc.loadFactor(0.10) + ", Succes!");
        System.out.println(theFunc.loadFactor(0.11) + ", Succes!");
        System.out.println(theFunc.loadFactor(0.12) + ", Succes!");
        System.out.println(theFunc.loadFactor(0.13) + ", Succes!");
        System.out.println(theFunc.loadFactor(0.14) + ", Succes!");
        System.out.println(theFunc.loadFactor(0.15) + ", Succes!");
        System.out.println(theFunc.loadFactor(0.16) + ", Succes!");
        
        

    
        

    }

}
