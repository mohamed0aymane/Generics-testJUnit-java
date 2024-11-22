package org.mql.java.generics;

import java.util.Vector;
/*ce code sert a illustre divers concepts lies 
 * la genericite,l'heritage,l'utilisation de collections en Java*/
public class QuickReminder {

	public QuickReminder() {
		super();
		exp03();
	}
	
	//exp01
	//creation un vector de chaine de caractere 
	//ajoute trois elements puis les imprime
	void exp01() {
		 //Genericite a partir de (JDK 5.0)=> compile-time feature
		 //Inference de type <>(JDK 7.0)
		Vector<String> v=new Vector<>();//Diamond operator <>
		v.add("JAVA");
		v.add("Node.js");
		v.add("Jakarta EE");
		
		for (String element :v) {
			System.out.println(element);
		}
	}
	
	//exp02
	class Point{
		
	}
	class Pixel extends Point{
		
	}
	//Dans la méthode exp02, pourquoi est-ce que le wildcard Vector<?> accepte le type Vector<Pixel> 
	//mais pas la méthode print(Vector<Point> v), alors que Pixel hérite de Point 
	
	void exp02() {
		//A pixel is a point
		Point p1=new Pixel();//affectation fille=>mere
		
		//Vector<Pixel> is not a Vector<Point>
		Vector<Point> v1=new Vector<Point>();//new Vector<Pixel>();//c est Faux
		v1.add(new Pixel());
		
		Vector<Pixel> v2=new Vector<>();
		print(v1);
		//print(v2); faux
		
		//le wildcard ?: type inconnu
		Vector<?> v3 = new Vector<Pixel>();
		// v3.add(new Pixel()); faux (car le type des elements de v3 est inconnu)
		v3.add(null);
		Vector<?> v4 =v2;
		printWildCard(v2);
	}
	
	
	void print(Vector<Point> v) {
		System.out.println(v);
	}
	void printWildCard(Vector<?> v) {
		System.out.println(v);
	}
	
	//Dans les méthodes exp03 et exp04, nous avons des génériques à borne supérieure (? extends Point) et inférieure (? super Point). 
	//Pourriez-vous clarifier dans quels cas spécifiques on devrait utiliser une borne inférieure super plutôt qu’une borne supérieure extends ?
	//exp03
	void exp03() {
		//genericite delimite
		//cas 1 :type generique a borne superieure(Upper-Bounded Generic Type)
		//ce genre de fonctionnalite existe dans 2 contextes differents:
		//1. a la definition du type
		//1.1 definition du type
		class Data<T extends Point>{//T:type/V:value // cette syntaxe T extends Point signifie la defintion pas la declaration
			private T element;
		}
		
		Data<Point> d1=new Data<>();
		Data<Pixel> d2=new Data<>();
		System.out.println(d1);
		System.out.println(d2);
		//Data<String> d3=new Data<>(); c'est faux
		
		
		//1.2 a la declartion variable ou parametre
		//ici c'est un vector constitue d'un point
		Vector<? extends Point>v1=new Vector<Pixel>();
		//c'est faux de faire v1.add(new Point());
		//v1.add(new Pixel());
		
		class Buffer{
			public static void print(Vector<? extends Point>v) {
				System.out.println(v);
			}
		}
		Vector<Pixel> v2=new Vector<>();
		Buffer.print(v2);
		//2. a la declaration des variables
	}
	
	//exp04
	void exp04() {
		//Genericite delimite
		//Cas 2 :type generique a borne inferieure (lower-bounded generic type)
		
		//il y a un seul contexte d'utilisation de ce genre de restriction:
		//a la declaration:
		Vector<Point> v1 = new Vector<>();
		Vector<Pixel> v2 = new Vector<>();
		Vector<String> v3 = new Vector<>();
		Vector<Object> v4 = new Vector<>();
		
		Vector<? super Point> v5=v1;
		Vector<? super Point> v6=v4;
		//Vector<? super Point> v7=v2; c'est faux
		//Vector<? super Point> v8=v3;	c'est faux
		v6.add(new Point());//affectation fille -> mere
		v6.add(new Pixel());//affectation fille -> mere
		//v6.add(""); // faux
		
		class Buffer{
			public  void init(Vector<? super Point>v,int size) {
				for(int i=0;i<size;i++) {
					v.add(new Point());
				}
			}
		}
		Buffer buffer=new Buffer();
		buffer.init(v1,10);
		System.out.println(v1.size());


	}
	
	//exp05
	void exp05() {
		Vector<String> letters=new Vector<String>(java.util.List.of("A","B","C","D"));
		String s =pop(letters);
		System.out.println("letters :"+ letters);
		System.out.println("s : "+ s);
		String s1=createObject(String.class);
		Integer i1=createObject(Integer.class);
		Point p1=createObject(Point.class);
		
		//Object s2="une chaine"; on ne peut pas casting la classe mere a la classe fille string car on a un integer
		Object s2=20;//on ne peut pas casting la classe mere a la classe fille string car on a un integer
		System.out.println(s2.getClass().getName());
		
		if(s2 instanceof String) {		//la condition pour que s2 soit reelement une instance de string ou non 
			String s3=(String) s2;		//affecation mere s2 -> fille s3 mais il necessite le casting
			System.out.println("s3 =" +s3);
			
		}
		
	
	}
	//modifier le contenu 
	public <T> T pop(Vector<T>v) {
		return v.remove(0);
		
	}
	//base sur la classe
	public <T> T createObject(Class<T> cls) {
		try {
			//introscruption
			cls.getDeclaredFields();
		return cls.getConstructor().newInstance();
		}catch(Exception e) {return null;}
	}
	
	

	
	public static void main(String[] args) {
		new QuickReminder();
	}
}
