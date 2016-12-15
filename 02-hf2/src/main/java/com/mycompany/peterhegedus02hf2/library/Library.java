/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peterhegedus02hf2.library;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Péter
 */
public class Library {
    
    private static Library instance;
    
    private Map<Item, Person> lendings;
     
    public Library(){
        this.lendings = new HashMap<>();
    }

    public static Library getInstance() {
         if(null==instance){
            instance=new Library();
        }
       return instance;
    }
    
    public void lendItem(Item item, Person person){
        if(lendings.containsKey(item)){
            throw new MyLibraryException(item.getTitle() + " has not been returned.");
        }
        else{
            lendings.put(item, person);
        }
    }
    
    public void returnItem(Item item){
        if(lendings.containsKey(item)){
           lendings.remove(item);
        }
        else{
             throw new MyLibraryException(item.getTitle() + " has not been lent.");
        }
    }

    boolean isLent(Item item) {
        return this.lendings.containsKey(item);
    }
    
}
