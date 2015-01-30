package collection;

import java.util.*;

class Student implements Comparable{
    public int id;
	public String name;
    public int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Student(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	@Override
	//I think we should check obj type, if error ,return ??

	public int compareTo(Object obj) {
	     Student p=(Student)obj;
	     return this.age-p.age;
	 }
	
	public String toString(){
		return "[id="+id+",name="+name+",age="+age+"]";
		
	}
}

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, Student> hashMap=new HashMap<>();
		Map<Integer,Student>  treeMap=new TreeMap<>();
		Student p1=new Student(1,"cheng",23);
		Student p2=new Student(2,"zhang",25);
		Student p3=new Student(3,"wang",24);
	}
}

