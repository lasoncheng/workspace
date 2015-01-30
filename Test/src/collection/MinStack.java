package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    public ArrayList stack;
    public int top;
    public MinStack(){
        this.stack=new ArrayList();
        this.top=-1;
    }
    public void push(int x) {
        top++;
        stack.add(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
        stack.remove(top);
        top--;
        }
    }

    public int top() {
        if(!stack.isEmpty())
        return (int) stack.get(top);
        else
        return -1;
    }

    public int getMin() {
        if(!stack.isEmpty()){
          int min=(int)stack.get(0);
          for(int i=0;i<=top;i++)
            if(min>(int)stack.get(i)) min=(int)stack.get(i);
          return min;
        }
        else
        return -1;
    }
    public static void main(String[] args) {
		MinStack stack=new MinStack();
		for(int i=-10000;i<90000;i++){
			stack.push(i);
		}
		for(int i=0;i<1000;i++)
		stack.pop();
		System.out.println(stack.getMin()+"|"+stack.top);
	}
}
// what a pity! I don't consider the price of getMin function. As we discuss,it can use two stacks,one 
// is true stack structure ,the other is for store the min value of the first stack. Of course,we can 
// use one stack to satisfy this problem. The answers are as follows:

//one way
class MinStack1 {
    long min;
    Stack<Long> stack;

    public MinStack1(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;//If negative, increase the min value

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}

//second way
class MinStack2
{
    static class Element
    {
        final int value;
        final int min;
        Element(final int value, final int min)
        {
            this.value = value;
            this.min = min;
        }
    }
    final Stack<Element> stack = new Stack<>();

    public void push(int x) {
        final int min = (stack.empty()) ? x : Math.min(stack.peek().min, x);
        stack.push(new Element(x, min));
    }

    public void pop()
    {
        stack.pop();
    }

    public int top()
    {
        return stack.peek().value;
    }

    public int getMin()
    {
        return stack.peek().min;
    }
}