package org.mql.java.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

//c est la classe main
public class Examples {
	public Examples() {
		exp04();
	}
	void exp01() {
		//il utilise la genericite pour s'assurer que seuls des objets de type Integer peuvent etre ajoutes a cette liste
		List<Integer> l1=new LinkedList<Integer>();//creer une nouvelle liste de type linkedlist qui peut contenir des elements de type Integer
		l1.add(20);
		l1.add(150);
		l1.add(74);
		System.out.println(l1.toString());//affiche la taille de la liste l1
	
	}
	void exp02() {
		//il utilise la genericite pour s'assurer que seuls des objets de type Integer peuvent etre ajoutes a cette liste
		//creer une nouvelle liste de type linkedlist qui peut contenir des elements de type Integer
		//list n est pas iterable
		
		        LinkedList<Integer> l1 = new LinkedList<>();

		        // Ajout des éléments
		        l1.add(0);
		        l1.add(1);
		        l1.add(2);
		        l1.add(3);
		       
		        System.out.println(" la liste apres ajout : " + l1+"\n");
		       
		        
		        l1.set(1, 7); // Remplace l'élément à l'index 1
		        
		        System.out.println(" la liste apres modification : " + l1+"\n");
		      

		        // Supprimer
		        System.out.println("L'element supprimé est : " + l1.remove(0)+"\n");
		        System.out.println("la liste apres suppression : " + l1+"\n");
		        
		        // get
		        System.out.println("l'index d'element est : " + l1.get(8)+"\n");

		        // contains
		        System.out.println("Est ce que il existe cette element : " + l1.contains(10)+"\n");

		        // indexof
		        System.out.println("L'index de l element est : " + l1.indexOf(3)+"\n");

		        // Ajouter une autre liste
		        LinkedList<Integer> listToAdd = new LinkedList<>();
		        listToAdd.add(8);
		        listToAdd.add(9);
		        listToAdd.add(11);
		        listToAdd.add(12);

		        l1.addLinkList(listToAdd);

		        // Affichage fusion d'une autre liste
		        System.out.println("la liste apres fusion: " + l1+"\n");

		        // isEmpty
		        System.out.println("La liste est vide : " + l1.isEmpty()+"\n");

		        // Effacer la liste
		        l1.clear();
		        System.out.println("la liste apres effacement : " + l1);
		    
		

	}
	
	//vector test
	void exp03() {
	    Vector<Integer> v = new Vector<>(9);
	      
	    // Ajout 
	    v.add(0);
	    v.add(1);
	    v.add(2);
	    v.add(3);

	    // Affichage des éléments du vecteur
	    for (Integer element : v) {
	        System.out.println("Element : "+ element);
	    }
	    
	    // Ajout de l'element 7 à l'index 1
	    v.add(1, 7);
	    
	    // Affichage des éléments du vecteur
	    for (Integer element : v) {
	        System.out.println("Element : "+ element);
	    }
	    
		
	    //Supprimer  
		   System.out.println("l'element supprimer est :"+v.remove(0)); 
        //get
		   System.out.println("l'element retourne est :"+v.get(0)); 
		//Contain
		   System.out.println("Est ce que l'element existe :"+v.contains(7));
		//indexOf
		   System.out.println("L'index d'element est :"+v.indexOf(3));
		
		     // Création d'un Vector avec des éléments à insérer
	        Vector<Integer> vectorAdd = new Vector<>();
	        vectorAdd.add(8);
	        vectorAdd.add(9);
	        vectorAdd.add(11);
	        vectorAdd.add(12);
	        
	        v.addVectorAt(1, vectorAdd);
		
	     // Affichage des éléments du vecteur
		    for (Integer element : v) {
		        System.out.println("Element : "+ element);
		    }
		    //verifier si il est vide
		    System.out.println(v.isEmpty());
		    //clear
		    v.clear();
		    System.out.println(" Vector apres effacement : " + v);
		    
	}
	
	//set has unique element not twice 
	 void exp04() {
		 Set<Integer> s1 = new Set<Integer>();
		 // Ajout 
		    s1.add(0);
		    s1.add(1);
		    s1.add(2);
		    s1.add(3);
	    // Ajout de l'element 7 à l'index 1
		    s1.add(1, 7);
			    
			    // Affichage des éléments du vecteur
			    for (Integer element : s1) {
			        System.out.println("Element : "+ element);
			    }
			    
				
			    //Supprimer  
				   System.out.println("l'element supprimer est :"+s1.remove(0)); 
		        //get
				   System.out.println("l'element retourne est :"+s1.get(0)); 
				//Contain
				   System.out.println("Est ce que l'element existe :"+s1.contains(20));
				//indexOf
				   System.out.println("L'index d'element est :"+s1.indexOf(3));
				   //verifier si il est vide
				    System.out.println("Est set est vide :"+s1.isEmpty());
				    //clear
				    s1.clear();
				    System.out.println("Set apres effacement : " + s1);
				  //verifier si il est vide
				    System.out.println("Est set est vide :"+s1.isEmpty());
	 }
	
	public static void main(String[] args) {
		new Examples();

	}

}
