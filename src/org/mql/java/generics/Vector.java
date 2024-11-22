package org.mql.java.generics;

import java.util.Arrays;
import java.util.Iterator;
//vector est un tabvleau dynamique  avec  un nombre de case modifiable similaire a ArrayList
//Iterable<T>  pour permettre une iteration sur les elements du vecteur avec une boucle for-each
public class Vector<T> implements List<T>, Iterable<T> {

	private Object data[];
	private int elemNbr=0;
	private int capacity=10;
	
	
	public Vector() {
		data=new Object[capacity];
	}
	
	public Vector(int size) {
		this.capacity=size;
		data=new Object[size];
	}
	public void HorsLimite(int index) {
		if(index> capacity || index< 0) {
			throw new IndexOutOfBoundsException("index est hors limite");
		}
	}
	@Override
	public int size() {
		return this.elemNbr;
	}
	
	
	//on vecteur la capacite d'un tableau se duplice
	public  void grow() {
		if(this.capacity==0) {
			this.data=new Object[1];
			
		}else {
			Object datacpy[]=new Object[capacity*2];
				for(int i=0;i<capacity;i++) 
					datacpy[i]=this.data[i];
				this.data=datacpy;
		}
		this.capacity=capacity();
	}
	
	
	public  int capacity() {
		return this.data.length;
	}

	@Override
	public void add(T e) {
		if(capacity()==this.elemNbr||capacity==0)  grow();
		this.data[elemNbr++]=e;
		
	}
	
	public void add(int index,T e) {
		HorsLimite(index);
		if(capacity()==this.elemNbr||capacity==0)  grow();
		for(int i=this.elemNbr;i>index;i--) this.data[i]=this.data[i-1];
		data[index]= e;
		this.elemNbr++;
	}

	public synchronized void addVectorAt(int index,List<T> v ) {
		HorsLimite(index);
		Object datacpy[]=new Object[capacity+( (Vector<T>) v).size()];
		
		for(int i=0;i<index;i++) {
			datacpy[i]=this.data[i];
		}
		int temp=index;
		
		for (int i = 0; i < v.size() ; i++) {
			datacpy[temp++] = ((List<T>) v).get(i);
			this.elemNbr++;
		}
		
		for (int i = index; i < capacity ; i++)
		    datacpy[temp++] = this.data[i];
		this.elemNbr = elemNbr + v.size();
		data = datacpy;
		System.out.println(toString());
		
	}
	@Override
	public T remove(int index) {
		T removed=this.get(index);
		for(int i=index;i<this.elemNbr-1;i++) this.data[i]=this.data[i+1];
		this.data[--this.elemNbr]=null;
		return removed;
	}

	@Override
	public T get(int index) {
		HorsLimite(index);
		return (T)this.data[index];
	}

	@Override
	public void set(int index, T e) {
		HorsLimite(index);
		if(index<this.elemNbr) this.data[index]=e;
		else {
			throw new IndexOutOfBoundsException("le size de donne: "+this.elemNbr+"et index utilise est " +index);
		}
	
	}


	@Override
	public boolean isEmpty() {
		return this.elemNbr==0;
	}

	@Override
	public boolean contains(T e) {
		for(int i=0;i<size();i++) {
			if((boolean)this.data[i].equals(e)) return true;
		}
		return false;
	}

	@Override
	public void clear() {
		data=new Object[capacity];
		this.elemNbr=0;
		
	}

	@Override
	public int indexOf(T e) {
		int index=0;
		while(index<size())
			if(data[index++]==e)
				return index;
		return -1;
		
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
		private Vector <T> pointer; // This is our current position
		private int it; // This is here to save our index while browsing the vector
		public Iter(Vector <T> V) {
			it = 0;
			this.pointer = V;
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
