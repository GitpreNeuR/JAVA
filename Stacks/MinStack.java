package Stacks;


import java.util.*;
public class MinStack {
	
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
    void push(int x) {
		s1.push(x);
		if(s2.isEmpty() || getMin() >= x){
			s2.push(x);
		}
    }
    void pop() {
	    if(s1.peek() == getMin()){
			s2.pop();
		}
		s1.pop();
    }
    int top() {
	    return s1.peek();
    }
    int getMin() {
	    return s2.peek();
    }
}