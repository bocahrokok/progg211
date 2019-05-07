/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtableapp;

import java.io.*;
import java.util.*;
import java.lang.*;

class DataItem{                             
   private String iData;            
   public DataItem(String ii){ iData = ii; }
   public String getKey(){ return iData; }
   }

class HashTable{
  
   private DataItem[] hashArray;
   private int arraySize;
   private DataItem nonItem;     
   public HashTable(int size){
      arraySize = size;
      hashArray = new DataItem[arraySize];
      for (int i = 0; i<arraySize; i++){
          hashArray[i] = null;
      }
      //nonItem = new DataItem(-1);
      }
   public void displayTable(){
      System.out.print("Table: ");
      for(int j=0; j<arraySize; j++){
         if(hashArray[j] != null)
            System.out.print(hashArray[j].getKey() + " ");
         else
            System.out.print("** ");
      }
     
      System.out.println("");
      }
  
   public void insert(DataItem item){
      String key = item.getKey();   
      int hashVal = hashFunc(key);
                                 
      while(hashArray[hashVal] != null){
         ++hashVal;              
         hashVal %= arraySize;   
         }
      hashArray[hashVal] = item;
      }
  
   public DataItem delete(String key){
      int hashVal = hashFunc(key);
      while(hashArray[hashVal] != null){                            
         if(hashArray[hashVal].getKey() == key){
            DataItem temp = hashArray[hashVal];
            hashArray[hashVal] = null;    
            return temp;                     
            }
         ++hashVal;              
         hashVal %= arraySize;   
         }
      return null;               
      }
   
   public DataItem find(String key){
      int hashVal = hashFunc(key);
      while(hashArray[hashVal] != null){                            
         if(hashArray[hashVal].getKey() == key)
            return hashArray[hashVal];
         ++hashVal;              
         hashVal %= arraySize;   
         }
      return null;               
      }
    public int hashFunc(String key){
        int hashVal = 0;
        for(int j=0; j < key.length(); j++){
           int letter = key.charAt(j)-96;     // get char code
           hashVal = (hashVal * 27 + letter) % arraySize; // mod
        }
        return hashVal;
      }
    
   }
class HashTableApp2 {
    
    public static void main(String[] args) throws IOException{
     
      DataItem aDataItem;
      int size, n;
      String aKey;
      String str = "abcdefghijklmnopqrstuvwxyz";

                                 
      System.out.print("Enter size of hash table: ");
      size = getInt();
      System.out.print("Enter initial number of items: ");
      n = getInt();
    
                                 
      HashTable theHashTable = new HashTable(size);
      Random rand = new Random();
      for(int j=0; j < n; j++){
         aKey = str.substring(0,rand.nextInt(26));
         System.out.println(aKey);
         aDataItem = new DataItem(aKey);
         theHashTable.insert(aDataItem);
         }
      while(true){
         System.out.print("Enter first letter of ");
         System.out.print("(s)how, (i)nsert, (d)elete, or (f)ind: ");
         char choice = getChar();
         switch(choice)
            {
            case 's':
               theHashTable.displayTable();
               break;
            case 'i':
            System.out.print("Enter key value to insert: ");
               aKey = getString();
               aDataItem = new DataItem(aKey);
               theHashTable.insert(aDataItem);
               break;
            case 'd':
               System.out.print("Enter key value to delete: ");
               aKey = getString();
               theHashTable.delete(aKey);
               break;
            case 'f':
               System.out.print("Enter key value to find: ");
               aKey = getString();
               aDataItem = theHashTable.find(aKey);
               if(aDataItem != null)
                  {
                  System.out.println("Found " + aKey);
                  }
               else
                  System.out.println("Could not find " + aKey);
               break;
            default:
               System.out.print("Invalid entry\n");
            }
         }
       
      }
  
   public static String getString() throws IOException{
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
   public static char getChar() throws IOException{
      String s = getString();
      return s.charAt(0);
      }
  
   public static int getInt() throws IOException{
     
      String s = getString();
      return Integer.parseInt(s);
      }
    }
    

