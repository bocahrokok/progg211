/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashingtablechaininglistheadstest;

/**
 *
 * @author nurrizkyimani
 */
        
class LinkedHashEntry{
        String key;
        int value;
        
        
    LinkedHasEntry next;
    
    LinkedHashEntry(String key, int value ){
        this.key = key;
        this.value = value;
        this.next = null;
    }
    
 }
