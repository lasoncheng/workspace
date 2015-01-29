package collection;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue=new ArrayDeque<Integer>();
		Queue<Integer> priorityQueue=new PriorityQueue<Integer>();
		for(int i=0;i<10;i++){
			queue.add((int)(Math.random()*100));
			priorityQueue.add((int)(Math.random()*100));
		}
		for(int element:priorityQueue){
			System.out.print(element+"  ");
		}
		priorityQueue.remove();
		System.out.println();
		for(int element:priorityQueue){
			System.out.print(element+"  ");
		}
		
	}
}
