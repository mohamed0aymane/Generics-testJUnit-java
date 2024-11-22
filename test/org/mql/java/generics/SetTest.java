package org.mql.java.generics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class SetTest {
	@Test
    void testSize() {
        Set<Integer> s = new Set<>();
        s.add(10);
        s.add(20);
        s.add(30);
        assertEquals(3, s.size(), "La taille du Set doit être 3 après trois ajouts.");
    }

    @Test
    void testAdd() {
    	Set<Integer> s = new Set<>();
    	s.add(10);
        s.add(20);
        s.add(1, 15); // Ajout à l'index 1
        s.add(30);
        assertAll(
            () -> assertEquals(10, s.get(0), "Le premier élément devrait être 10."),
            () -> assertEquals(15, s.get(1), "L'élément à l'index 1 devrait être 15."),
            () -> assertEquals(20, s.get(2), "L'élément à l'index 2 devrait être 20."),
            () -> assertEquals(30, s.get(3), "L'élément à l'index 3 devrait être 30.")
        );
    }



    @Test
    void testRemove() {
    	 Set<Integer> s = new Set<>();
         s.add(10);
         s.add(20);
         s.add(30);

        // Supprime l'élément à l'index 1 (valeur 20)
        int removed = s.remove(1);
        assertAll(
            () -> assertEquals(20, removed, "L'élément supprimé devrait être 20."),
            () -> assertEquals(10, s.get(0), "Le premier élément devrait rester 10."),
            () -> assertEquals(30, s.get(1), "Le deuxième élément devrait devenir 30."),
            () -> assertEquals(2, s.size(), "La taille du vecteur devrait être 2 après suppression.")
        );
    }

    @Test
    void testSet() {
    	 Set<Integer> s = new Set<>();
         s.add(10);
         s.add(20);
         s.add(30);
        s.set(1, 99); // Remplace l'élément à l'index 1
        assertEquals(99, s.get(1), "L'élément à l'index 1 devrait être remplacé par 99.");
    }

    @Test
    void testContains() {
    	 Set<Integer> s = new Set<>();
         s.add(10);
         s.add(20);
         s.add(30);

        assertAll(
            () -> assertTrue(s.contains(20), "Le vecteur doit contenir l'élément 20."),
            () -> assertFalse(s.contains(99), "Le vecteur ne doit pas contenir l'élément 99.")
        );
    }

    @Test
    void testIsEmpty() {
    	 Set<Integer> s = new Set<>();
        
        assertTrue(s.isEmpty(), "Le vecteur doit être vide après sa création.");

        s.add(10);
        assertFalse(s.isEmpty(), "Le vecteur ne doit pas être vide après l'ajout d'un élément.");
    }

    @Test
    void testClear() {
    	 Set<Integer> s = new Set<>();
         s.add(10);
         s.add(20);
         s.add(30);
        s.clear();

        assertAll(
            () -> assertEquals(0, s.size(), "La taille doit être 0 après un clear."),
            () -> assertTrue(s.isEmpty(), "Le vecteur doit être vide après un clear.")
        );
    }

    @Test
    void testIndexOf() {
    	 Set<Integer> s = new Set<>();
         s.add(10);
         s.add(20);
         s.add(30);

        assertAll(
            () -> assertEquals(1, s.indexOf(20), "L'index de l'élément 20 doit être 1."),
           () -> assertEquals(-1, s.indexOf(99), "Un élément absent doit retourner -1.")
        );
    }

    @Test
    void testIterator() {
    	 Set<Integer> s = new Set<>();
         s.add(10);
         s.add(20);
         s.add(30);
        Iterator<Integer> it = s.iterator();
        assertAll(
            () -> assertTrue(it.hasNext(), "L'itérateur doit indiquer qu'il y a des éléments."),
            () -> assertEquals(10, it.next(), "Le premier élément retourné doit être 10."),
            () -> assertEquals(20, it.next(), "Le deuxième élément retourné doit être 20."),
            () -> assertEquals(30, it.next(), "Le troisième élément retourné doit être 30."),
            () -> assertFalse(it.hasNext(), "L'itérateur ne doit plus indiquer d'éléments après avoir parcouru la liste.")
        );
    }
}
