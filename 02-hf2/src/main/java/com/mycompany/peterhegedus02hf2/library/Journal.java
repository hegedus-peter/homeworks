/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peterhegedus02hf2.library;

import java.util.Objects;

/**
 *
 * @author Péter
 */
public class Journal extends Item{
    
    String issue;
    
    public Journal(String title, String issue){
        super(title);
        this.issue=issue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.issue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Journal other = (Journal) obj;
        if (!Objects.equals(this.issue, other.issue)) {
            return false;
        }
        return true;
    }
    
    
}
