package doublyLinkedList;

public class DoublyLinkedList {
	
	private Node first;
	private Node last;

public void insertFirst(int data) {
	Node newNode = new Node(data);
	
	if(isEmpty()) {		
		last = newNode;
	}
	
	newNode.next = first;//linking
	first.previous = newNode;//linking
	first = newNode;//assignment
	
	
}


public void insertLast(int data) {
	
  Node newNode = new Node(data);
  
  
  if(isEmpty()) {
	first = newNode;  
	  
  } 
  last.next = newNode;//linking
  newNode.previous = last;//linking
  last = newNode;	//assignment
}


public int deleteFirst() throws Exception {
	
	if(isEmpty()) {
		throw new Exception("Empty List");
	}
	
	int removed = first.data;
	if(hasOneElement()) {
		first = null;
		last = null;
		return removed;
	}
	
	first.next.previous = null;//linking
	first = first.next;
	return removed;
	
}

public int deleteLast() throws Exception  {
	
	if(isEmpty()) {
		throw new Exception("Empty List");
	}
	
	int removed = last.data;
	if(hasOneElement()) {
		first = null;
		last = null;
		return removed;
	}
	
	last.previous.next = null;
	last = last.previous;
	return removed;	
}

public  boolean insertAfter(int data, int key) {

    Node newNode = new Node(data);   
    Node current = first;
    
    while(current.data!=key) {
    	 current = current.next; 
    	 
    	 if(current==null) {//means no match found till end
    		 return false;
    		 
   		 
    	 }
    	 
    }
    
    if(current == last) {////if key found at last element
    	    current.next = newNode;
    	    newNode.previous= current;
    }else {//current is either first or in the middle, total 4 links will be changed
        newNode.previous = current;
        newNode.next = current.next;//
        current.next.previous = newNode;
        current.next = newNode;//
    }
    
    return true;
   
 
}

public boolean deleteKey(int key) {
	
	 Node current = first;
	 
	 while(current.data!=key) {		 
		 current = current.next;
		 if(current==null) {//means no match found till end
    		 return false;
		 } 
    	 }
		 
		 if(current == last) {////if key found at last element
	    	    current.previous.next = null;
	    	    last = current.previous;
	    	    
		 }else if(current==first) {
	    	    	current.next.previous = null;
	    	    	first = current.next;
	    	    	
	    	 }else {//current is either first or in the middle
	    	    current.previous.next = current.next;//this can be used if current==last
	    	    current.next.previous= current.previous;///this can be used if current==first
	    }
	    
	    return true;
	 }
	


public boolean isEmpty() {
	
	return (first== null);
}

public boolean hasOneElement() {
	
	return (first.next== null);
}




}
