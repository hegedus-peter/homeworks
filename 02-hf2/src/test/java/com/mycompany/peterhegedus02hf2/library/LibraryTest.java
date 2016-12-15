/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peterhegedus02hf2.library;

import com.mycompany.peterhegedus02hf2.library.Library;
import com.mycompany.peterhegedus02hf2.library.Item;
import com.mycompany.peterhegedus02hf2.library.Journal;
import com.mycompany.peterhegedus02hf2.library.MyLibraryException;
import com.mycompany.peterhegedus02hf2.library.Person;
import com.mycompany.peterhegedus02hf2.library.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Péter
 */
public class LibraryTest {
    
    Library testLibrary;
    
    public LibraryTest() {
        testLibrary = Library.getInstance();
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testBookLendGood() {
        Book aranyEmber = new Book("Az aranyember", "Jokai Mor", "1872");
        assertEquals(false,testLibrary.isLent(aranyEmber));
        testLibrary.lendItem(aranyEmber, new Person("Kiss Istvan",0));
        assertEquals(true,testLibrary.isLent(aranyEmber));
    }
    
    @Test(expected = MyLibraryException.class)
    public void testBookLendBad() {
        Book koszivu = new Book("A koszivu ember fiai", "Jokai Mor", "1869");
        testLibrary.lendItem(koszivu, new Person("Kiss Istvan",0));
        testLibrary.lendItem(koszivu, new Person("Horvath Geza",1));
    }    
    
    @Test(expected = MyLibraryException.class)
    public void testBookReturnBad() {
        testLibrary.returnItem(new Book("Janos vitez", "Petofi Sandor", "1844"));
    }
    
    @Test
    public void testBookReturnGood() {
        Item toldi = new Book("Toldi", "Arany Janos", "1846");
        testLibrary.lendItem(toldi, new Person("Kiss Istvan",0));
        assertEquals(true,testLibrary.isLent(toldi));
        testLibrary.returnItem(toldi);
        assertEquals(false,testLibrary.isLent(toldi));
    }
    
    @Test
    public void testJournalLendGood() {
        Journal magyarSebesz = new Journal("Magyar Sebeszet", "2016.05.");
        assertEquals(false,testLibrary.isLent(magyarSebesz));
        testLibrary.lendItem(magyarSebesz, new Person("Kiss Istvan",0));
        assertEquals(true,testLibrary.isLent(magyarSebesz));
    }
    
    @Test(expected = MyLibraryException.class)
    public void testJournalLendBad() {
        Journal magyarPszicho = new Journal("Magyar Pszichologiai Szemle", "2000.04.");
        testLibrary.lendItem(magyarPszicho, new Person("Kiss Istvan",0));
        testLibrary.lendItem(magyarPszicho, new Person("Horvath Geza",1));
    }    
    
    @Test(expected = MyLibraryException.class)
    public void testJournalReturnBad() {
        testLibrary.returnItem(new Journal("Muveszettorteneti Ertesito", "2014.02."));
    }
    
    @Test
    public void testJournalReturnGood() {
        Journal orvosi = new Journal("Orvosi Hetilap", "1996.12");
        testLibrary.lendItem(orvosi, new Person("Kiss Istvan",0));
        assertEquals(true,testLibrary.isLent(orvosi));
        testLibrary.returnItem(orvosi);
        assertEquals(false,testLibrary.isLent(orvosi));
    }
    
}
