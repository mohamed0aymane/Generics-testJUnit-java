package org.mql.java.generics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void testAddAndSize() {
		List<Integer> l1=new LinkedList<Integer>();//creer une nouvelle liste de type linkedlist qui peut contenir des elements de type Integer
		l1.add(20);
		l1.add(150);
		l1.add(74);
		assertEquals(3, l1.size());//3 c'est la taille
	}
	@Test
	void testSize() {
		List<Integer> l1=new LinkedList<Integer>();//creer une nouvelle liste de type linkedlist qui peut contenir des elements de type Integer
		assertEquals(0, l1.size());
	}
	
	@Test
	void testGetNull() {
		List<Integer> l1=new LinkedList<Integer>();//creer une nouvelle liste de type linkedlist qui peut contenir des elements de type Integer
		assertEquals(null, l1.get(0));
	}

	@Test
	void testGet() {
		List<Integer> l1=new LinkedList<Integer>();//creer une nouvelle liste de type linkedlist qui peut contenir des elements de type Integer
		l1.add(20);
		l1.add(150);
		l1.add(74);
		assertAll(
				()->assertEquals(20, l1.get(0)),
				()->assertEquals(74, l1.get(2)),
				()->assertEquals(null, l1.get(3))
			);

	}
	@Test
	void testRemove() {
		List<Integer> l1=new LinkedList<Integer>();//creer une nouvelle liste de type linkedlist qui peut contenir des elements de type Integer
		l1.add(20);
		l1.add(150);
		l1.add(74);
		int removed=l1.remove(0);
		assertAll(
				()->assertEquals(20, removed),
				()->assertEquals(2, l1.size())
			);

	}
	@Test
	 void testContains() {
		 List<Integer> l = new LinkedList<Integer>();
	     l.add(10);
	     l.add(20);
	     l.add(30);

	     assertAll(
	            () -> assertTrue(l.contains(20), "la liste doit contenir l'element 20."),
	            ()-> assertFalse(l.contains(100),"la liste ne doit pas contenir l'element 50")
	        );
	    }
	@Test
    void testSet() {
		List<Integer> l1=new LinkedList<Integer>();
        l1.add(10);
        l1.add(20);
        l1.add(30);

        l1.set(1, 99); // Remplace l'élément à l'index 1
        assertEquals(99, l1.get(1), "L'élément à l'index 1 devrait être remplacé par 99.");
    }
	   @Test
	    void testIsEmpty() {
			List<Integer> l1=new LinkedList<Integer>();
	       
	        assertTrue(l1.isEmpty(), "Le vecteur doit être vide apres sa création.");

	        l1.add(10);
	        assertFalse(l1.isEmpty(), "Le vecteur ne doit pas être vide après l'ajout d'un élément.");
	    }
	   
	   @Test
	    void testClear() {
		   List<Integer> l1=new LinkedList<Integer>();
	        l1.add(10);
	        l1.add(20);
	        l1.add(30);
	        l1.clear();

	        assertAll(
	            () -> assertEquals(0, l1.size(), "La taille doit être 0 après un clear."),
	            () -> assertTrue(l1.isEmpty(), "Le vecteur doit être vide après un clear.")
	        );
	    }
	   
	   @Test
	   void testIndexOf() {
	       LinkedList<Integer> l1 = new LinkedList<>();
	       l1.add(10);
	       l1.add(20);
	       l1.add(30);

	       // Test avec un élément présent dans la liste
	       assertAll(
	           () -> assertEquals(0, l1.indexOf(10), "L'index de l'élément 10 doit être 0."),
	           () -> assertEquals(1, l1.indexOf(20), "L'index de l'élément 20 doit être 1."),
	           () -> assertEquals(2, l1.indexOf(30), "L'index de l'élément 30 doit être 2."),
           // Test avec un élément qui n'existe pas dans la liste
           () -> assertEquals(-1, l1.indexOf(99), "Un élément absent doit retourner -1.")
	       );
	   }
	   
	   
	   @Test
	    void testIterator() {
	        // Créer une LinkedList et ajouter des éléments
	        LinkedList<Integer> l1 = new LinkedList<>();
	        l1.add(10);
	        l1.add(20);
	        l1.add(30);

	        // Créer un itérateur pour l1
	        Iterator<Integer> iterator = l1.iterator();

	        // Vérification de l'itération sur les éléments
	        assertAll(
	            () -> assertTrue(iterator.hasNext(), "Il devrait y avoir un élément suivant."),
	            () -> assertEquals(10, iterator.next(), "Le premier élément doit être 10."),
	            () -> assertTrue(iterator.hasNext(), "Il devrait y avoir un élément suivant."),
	            () -> assertEquals(20, iterator.next(), "Le deuxième élément doit être 20."),
	            () -> assertTrue(iterator.hasNext(), "Il devrait y avoir un élément suivant."),
	            () -> assertEquals(30, iterator.next(), "Le troisième élément doit être 30."),
	            () -> assertFalse(iterator.hasNext(), "Il ne devrait pas y avoir d'élément suivant.")
	        );
	    }
	   
	   


}
