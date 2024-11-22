package org.mql.java.generics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class VectorTest {

    @Test
    void testSize() {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);
        assertEquals(3, v.size(), "La taille du vecteur doit être 3 après trois ajouts.");
    }

    @Test
    void testAdd() {
        Vector<Integer> v = new Vector<>(5);
        v.add(10);
        v.add(20);
        v.add(1, 15); // Ajout à l'index 1
        v.add(30);
        assertAll(
            () -> assertEquals(10, v.get(0), "Le premier élément devrait être 10."),
            () -> assertEquals(15, v.get(1), "L'élément à l'index 1 devrait être 15."),
            () -> assertEquals(20, v.get(2), "L'élément à l'index 2 devrait être 20."),
            () -> assertEquals(30, v.get(3), "L'élément à l'index 3 devrait être 30.")
        );
    }


    @Test
    void testRemove() {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);

        // Supprime l'élément à l'index 1 (valeur 20)
        int removed = v.remove(1);
        assertAll(
            () -> assertEquals(20, removed, "L'élément supprimé devrait être 20."),
            () -> assertEquals(10, v.get(0), "Le premier élément devrait rester 10."),
            () -> assertEquals(30, v.get(1), "Le deuxième élément devrait devenir 30."),
            () -> assertEquals(2, v.size(), "La taille du vecteur devrait être 2 après suppression.")
        );
    }

    @Test
    void testSet() {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);

        v.set(1, 99); // Remplace l'élément à l'index 1
        assertEquals(99, v.get(1), "L'élément à l'index 1 devrait être remplacé par 99.");
    }

    @Test
    void testContains() {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);

        assertAll(
            () -> assertTrue(v.contains(20), "Le vecteur doit contenir l'élément 20."),
            () -> assertFalse(v.contains(99), "Le vecteur ne doit pas contenir l'élément 99.")
        );
    }

    @Test
    void testIsEmpty() {
        Vector<Integer> v = new Vector<>();
        assertTrue(v.isEmpty(), "Le vecteur doit être vide après sa création.");

        v.add(10);
        assertFalse(v.isEmpty(), "Le vecteur ne doit pas être vide après l'ajout d'un élément.");
    }

    @Test
    void testClear() {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.clear();

        assertAll(
            () -> assertEquals(0, v.size(), "La taille doit être 0 après un clear."),
            () -> assertTrue(v.isEmpty(), "Le vecteur doit être vide après un clear.")
        );
    }

    @Test
    void testIndexOf() {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);

        assertAll(
            () -> assertEquals(1, v.indexOf(20), "L'index de l'élément 20 doit être 1."),
            () -> assertEquals(-1, v.indexOf(99), "Un élément absent doit retourner -1.")
        );
    }

    @Test
    void testIterator() {
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(20);
        v.add(30);

        Iterator<Integer> it = v.iterator();
        assertAll(
            () -> assertTrue(it.hasNext(), "L'itérateur doit indiquer qu'il y a des éléments."),
            () -> assertEquals(10, it.next(), "Le premier élément retourné doit être 10."),
            () -> assertEquals(20, it.next(), "Le deuxième élément retourné doit être 20."),
            () -> assertEquals(30, it.next(), "Le troisième élément retourné doit être 30."),
            () -> assertFalse(it.hasNext(), "L'itérateur ne doit plus indiquer d'éléments après avoir parcouru la liste.")
        );
    }
}
