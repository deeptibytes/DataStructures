package Queue;

public class Queue {
	
	private int maxSize;
	private int rear;
	private int front;
	private int nItems;
	private long[] queArray;
	
	public Queue (int size) {
		maxSize = size;
		rear= -1;
		front = 0;
		nItems = 0;
		queArray= new long[size];
		
	}
	
	public void insert(long l) {	//enqueue	
		
		if(!isFull()) {
			rear++;
			queArray[rear] = l;
			nItems++;
		}else {//if the queue is full, first element will be replaced with upcoming element
			rear= -1;
			rear++;
			queArray[rear] = l;
			nItems++;//I guess we dont need here
			System.out.println("Queue is full so replacing older elements with newer elementss");
		}
			
		
		
	}
	
	public long remove() {	//dequeue	
		
	if(!isEmpty()) {
		long temp = queArray[front];
		front++;
		if(front==maxSize) {//this becomes empty stack. means we removed last element
			front = 0; //front is zero for empty stack and rear is -1
		    rear = -1;
		}
		nItems--;		
		return temp;
		
	}else {
		System.out.println("Queue is empty");
		return -1;
	}
		
	}
	
	public boolean isEmpty() {
		return (nItems==0);
	}
	
     public boolean isFull() {		
       	 return (maxSize==nItems);
	   }
	
	public long peekFront() {
		return queArray[front];
	}
	
	public void view() {
		
		for(int i =0; i<queArray.length; i++) {
			
			System.out.println(queArray[i]);
		}
	}
	
	
	

}
