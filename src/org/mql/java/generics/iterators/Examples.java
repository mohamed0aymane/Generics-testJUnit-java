package org.mql.java.generics.iterators;

import java.util.Iterator;
import java.util.LinkedList;

public class Examples {

	public Examples() {
		exp02();
	}
	
	/*jamais on fait une boucle for en linkedlist*/
	
	void exp01() {//on fait un autre package car linkedlist c'est du java util c'est pas la classe linkedlist
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		Iterator<Integer> iterator=list.iterator();
		System.out.println(iterator.getClass().getName());
		
		while(iterator.hasNext()) {
			int element =iterator.next();
			System.out.println(element);
		}
		
	}
	void exp02() {//on fait un autre package car linkedlist c'est du java util c'est pas la classe linkedlist
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		for(Integer element : list) {
			System.out.println(element);
		}
		
	}
	
	public static void main(String[] args) {
	new Examples();
	}
}
