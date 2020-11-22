package stack;

public class Stack {
	
	private char[] stackArray;
	private int top;
	private int maxSize;
	
	
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray= new char[maxSize];
		this.top = -1;
		
	}
	
	/*
	 * add the element to stack
	 */
	public void push(char l) {
		
		//before pushing check if stack is already full
		if(!isFull()) {
			top++;
			stackArray[top] = l;
			
		}else {
			System.out.println("Stack is full");
		}
	}
	
	/*
	 * Removes the top element 
	 */
	public char pop() {
				
		//before popping check if stack is not empty
		if(!isEmpty()) {	
			int old_top = top;
			top--;
			return stackArray[old_top];
		}else {
			System.out.println("Stack is empty");
			return ' ';
		}
		
		
	}
	
	/*
	 * Gives the top element without removing
	 */
	public long peak() {
		
		return this.stackArray[top];
	}
	
	public boolean isFull() {
		return (maxSize-1 == top);
		
	}
	
	public boolean isEmpty() {		
			return (this.top==  -1);				
	}
	
}
