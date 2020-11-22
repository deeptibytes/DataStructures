package circularLinkedList;

public class CircularLinkedList {
	
	
	public Node first;
	public Node last;
	
	public CircularLinkedList()
	{
		
		first = null;
		last = null;
	}
	
	public void insertFirst(int dataToInsert) {
		
		Node newNode = new Node (dataToInsert);		
		
		if(isEmpty()) {
			last = newNode;
		}
					
		    newNode.next = first;//linking
			first = newNode;//assignmenet
				
	}
	
   public void insertLast(int dataToInsert) {
		
	   Node newNode = new Node (dataToInsert);
	   
	   if(isEmpty()) {
			first = newNode;
		}
	   
	   last.next = newNode;//linking
	   last = newNode;//assignment
	   
	   
		
	}
   
   public void deleteLast() {
		
	   if(isEmpty()) {
			//throw exception
		}
	   
	   if(first.next == null) {//has only one element		   
		  first = null; 
	   }
	   last = null;
		
	}
   
   public int deleteFirst() throws Exception{
	   
	   if(isEmpty()) {
		   
		   throw new Exception("List is empty");
	   }
	   
	   int removed = first.data;
	   
	   if(first.next==null) {//has only one element
		   //first =null;
		   last = null;
		   
	   }else {
		   first = first.next; 
	   }
	  
	  
	   return removed;		
	}
   
   
   public boolean isEmpty() {
	   
	   return (first==null);
   }
	
	
	
	

}
