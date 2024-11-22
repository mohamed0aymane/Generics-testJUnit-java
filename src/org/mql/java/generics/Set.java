package org.mql.java.generics;

import java.util.Arrays;
import java.util.Iterator;

public class Set<T> implements List<T>,Iterable<T> {

	private Object data [];
	private int elemNbr = 0;
	private int capacity = 10;
//	Dans une collection Set, il n'y a pas de doublons, on se basera sur ça
	
	public Set(){
		data = new Object[capacity];
	}

	public Set (int size) {
		this.capacity = size;
		data = new Object[size];
	}
	
	public void HorsLimite(int index) {
		if(index > capacity  || index < 0) {
			throw new IndexOutOfBoundsException("index est hors limite."); 
		}
	}
	
//	La methode qui va s'assurer qu'un element n'existera qu'une seule fois
	public void check(T e) {
		if (contains(e)) {
			throw new IllegalStateException("A set has unique elements. Cannot add the same element twice.");
		}
	}
	
	public void grow() {
		if(this.capacity == 0) {
			this.data = new Object[1] ;
		} else {
			Object datacpy [] = new Object[capacity*2];
			for (int i = 0; i < capacity ; i++)
				datacpy[i] = this.data[i];
			this.data = datacpy;
		}
		this.capacity = capacity();
	}
	
	@Override
	public void add(T e) { //Add after the last element
		check(e);
		if (capacity == this.elemNbr || capacity == 0) grow();
		this.data[elemNbr++] = e;
	}
	
	public void add(int index,T e) { // Shift Elements after a certain index
		check(e);
		HorsLimite(index);
		if(capacity == this.elemNbr || capacity == 0) grow();
		for (int i = this.elemNbr; i > index; i--) this.data[i] = this.data[i-1];
		data[index] = e;
		this.elemNbr++;
	}
	
	@Override
	public T remove(int index) {
		T removed = this.get(index);
		for (int i = index; i < this.elemNbr - 1 ; i++) {
			this.data[i] = this.data[i+1];
		}
		this.data[--this.elemNbr] = null;
		return removed;
	}

	@Override
	public boolean contains(T e) {
		for(int i=0;i < size();i++) {
			if(this.data[i].equals(e)) return true;
		}
		return false;
	}
	@Override
	public void set(int index,T e) {
		check(e);
		HorsLimite(index);
		if(index < this.elemNbr) this.data [index] = e;
		else {
			throw new IndexOutOfBoundsException("Data size is : "+this.elemNbr+" and Index used is : "+index);
		}
	}
	@Override
	public T get(int index) {
		HorsLimite(index);
		return (T)this.data[index];
	}
	
	@Override
	public int indexOf(T e) {
		int index =  0;
		while (index< size() )
		    if (data[index++] == e)
		         return index;
		return -1;
	}

	@Override
	public int size() {
		return this.elemNbr;
	}
	public int capacity() {
		return this.data.length;
	}
	@Override
	public boolean isEmpty() {
		return this.elemNbr == 0;
	}

	@Override
	public void clear() {
		data = new Object[capacity];
		this.elemNbr = 0;
	}
	
	@Override
	public synchronized String toString() {
		return "Vector [data=" + Arrays.toString(data) + ", elemNbr=" + elemNbr + ", capacity=" + capacity + "]";
	}
	
	

	@Override
	public Iterator<T> iterator() {
		return new Iter(this);
	}
	public class Iter implements Iterator<T> {
		private Set<T> pointer; // This is our current position
		private int it; // This is here to save our index while browsing the set
		public Iter(Set<T> set) {
			it = 0;
			this.pointer = set;
		}

		@Override
		public boolean hasNext() {
			return this.pointer.size()  != it;
		}

		@Override
		public T next() {
			return (T)this.pointer.data[it++];
		}	
	
	}
}
