package Queue;

public class QueueApp {

	public static void main(String[] args) {
		
		Queue myQueue= new Queue(5);
		myQueue.insert(6);//first in first out
		myQueue.insert(7);
		myQueue.insert(8);
		myQueue.insert(9);
		myQueue.insert(18);
		myQueue.insert(12);//last in last out
		myQueue.view();

	}

}
