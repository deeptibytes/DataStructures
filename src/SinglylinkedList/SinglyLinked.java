package SinglylinkedList;

public class SinglyLinked {
	
	public Node head; //point to head
	
public void insertFirst(Node head, int data) {//inserts at the beginning
		
		Node newNode = new Node(data);
		if(isEmpty()) {
			head = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
		
	}



	
	
public Node deleteFirst(int data) throws Exception{//deletes at the beginning
		
		
		if(isEmpty()) {
			throw new Exception("Nothing to delete, List is empty");
		}else {
			Node tmp = head;
			head = head.next;
			return tmp;
		}
		
	}


public void insertLast(int data) {//inserts at the last. Need to traverse from first to last
	
	Node newNode = new Node(data);
	if(isEmpty()) {
		head = newNode;
	}else {
		Node current = head;
		
		while(current.next!=null) {
			current = current.next;			
		}
		
		current.next = newNode;
		
	}
	
}
		
public boolean isEmpty() {
			return (head==null);
}

public void displayList() {
	
	System.out.println("Dislaying from first to last**");
	Node currentNode = head;
	
	while(currentNode!=null) {
		System.out.println(currentNode.data);
		currentNode = currentNode.next;
	}
}

}
