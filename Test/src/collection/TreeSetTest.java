package collection;

import java.util.*;

public class TreeSetTest {
   public static void main(String[] args) {
//	one:let Person implements Comparable
	
	   TreeSet <Person> treeSet=new TreeSet<Person>();
	
 // second: user comparator
	   PersonComparator comparator=new PersonComparator();
   	   TreeSet <Person> sortedByDescription=new TreeSet<Person>(comparator); 

//  second:user anonymous class
//   	TreeSet <Person> sortedByDescription=new TreeSet<Person>(new 
//			Comparator<Person>() {
//		   		@Override
//				public int compare(Person p1, Person p2) {
//					return 0;
//				}
//			} );
   	   treeSet.add(new Person("Aimi",23));
   	   treeSet.add(new Person("Bob",25));
   	   treeSet.add(new Person("Cason",24));
   	   sortedByDescription.addAll(treeSet);
   	   System.out.println("sorted by age");
   	   for(Person element:treeSet)
		System.out.println(element);
   	   
   	   System.out.println("sorted by name");
   	   for(Person element:sortedByDescription)
		System.out.println(element);
   	   String a="a";
   	   a.compareTo(a);
	}
}


class Person implements Comparable{
    public String name;
    public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	@Override
	//I think we should check obj type, if error ,return ??

	public int compareTo(Object obj) {
	     Person p=(Person)obj;
	     return this.age-p.age;
	 }
	
	public String toString(){
		return "[name="+name+",age="+age+"]";
		
	}
}

//if class item was created by others and he didn't rewrite function compareTo(),
//how can we do ? We can transmit the object of Comparator to the constructor of 
//the treeSet to tell it how to sort. Example is as follow:

class PersonComparator implements Comparator<Person>{
    @Override
	public int compare(Person p1, Person p2) {
		String name1=p1.getName();
		String name2=p2.getName();
		return name1.compareTo(name2);
	}
	
	
}
	
