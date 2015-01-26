package collection;

import java.util.*;



public class TreeSetTest {
   public static void main(String[] args) {
	TreeSet<String> treeSet=new TreeSet();
	for(int i=10;i>0;i--)
		treeSet.add("test"+i);
	
	Iterator iter=treeSet.iterator();
	while(iter.hasNext())
		System.out.println(iter.next());
	for(String treeElement:treeSet)
		System.out.println(treeElement);
	}
}
