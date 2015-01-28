package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
    public ArrayList<Integer> stack;
    public int top;
    public Stack<Integer> minStack;
    int temp;
    public MinStack(){
        this.stack=new ArrayList();
        this.minStack=new Stack();
        this.top=-1;
    }
    
    public void push(int x) {
        top++;
        stack.add(x);
        if(top==0 || minStack.peek()>=x)
            minStack.push(x);
    }

    public void pop() {
       
        if(!stack.isEmpty()){
            if(stack.get(top).equals(minStack.peek()))
            //if(stack.get(top)==minStack.peek()) warnning :wrong answer!
                 temp=minStack.pop();
            stack.remove(top);
            top--;
      
        }
    }

    public int top() {
        if(!stack.isEmpty())
        return stack.get(top);
        else
        return -1;
    }

    public int getMin() {
        if(!minStack.isEmpty()){
          return minStack.peek();
        }
        else
        return -1;
    }
   
    public static void main(String[] args) {
    	MinStack stack=new MinStack();
    	stack.push(512);
    	stack.push(-1024);
    	stack.push(-1024);
    	stack.push(512);
    	stack.pop();
    	System.out.println(stack.getMin());
    	stack.pop();
    	System.out.println(stack.getMin());
    	stack.pop();
    	System.out.println(stack.getMin());
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