/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peterhegedus02hf2.library;

/**
 *
 * @author Péter
 */
public class MyLibraryException extends RuntimeException{

    public MyLibraryException(String message) {
        super(message);
    }

    public MyLibraryException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyLibraryException(Throwable cause) {
        super(cause);
    }

    public MyLibraryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
